package com.costs.service.impl;

import com.costs.dto.ProjetoRequestDTO;
import com.costs.dto.ProjetoResponseDTO;
import com.costs.exception.ProjetoNotFoundException;
import com.costs.mapper.CategoriaMapper;
import com.costs.mapper.ProjetoMapper;
import com.costs.mapper.ServicoMapper;
import com.costs.model.Projeto;
import com.costs.model.Servico;
import com.costs.repository.ProjetoRepository;
import com.costs.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProjetoServiceImpl implements ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private ProjetoMapper projetoMapper;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Autowired
    private ServicoMapper servicoMapper;


    @Override
    public ResponseEntity<ProjetoResponseDTO> salvar(ProjetoRequestDTO dto) {
        Projeto projeto = projetoMapper.toEntity(dto);
        Projeto salvo = projetoRepository.save(projeto);
        return new ResponseEntity<>(projetoMapper.toDTO(salvo), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ProjetoResponseDTO>>  recuperTodos() {
        List<Projeto> projetos = projetoRepository.findAll();
        List<ProjetoResponseDTO> dtoList = projetos.stream()
                .map(projetoMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProjetoResponseDTO>  buscarPorId(Long id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new ProjetoNotFoundException("Projeto com ID " + id + " não encontrado"));

        ProjetoResponseDTO dto = projetoMapper.toDTO(projeto);
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<List<ProjetoResponseDTO>> buscarPorNome(String nome) {
        List<Projeto> projetos = projetoRepository.findByNomeContainingIgnoreCase(nome);
        List<ProjetoResponseDTO> dtoList = projetos.stream()
                .map(projetoMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ProjetoResponseDTO> atualizar(Long id, ProjetoRequestDTO dto) {
        Optional<Projeto> projetoOpt = projetoRepository.findById(id);
        if (projetoOpt.isEmpty()) {
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Projeto existente = projetoOpt.get();
        projetoMapper.updateUsuario(dto, existente);
//        existente.setNome(dto.getNome());
//        existente.setBudget(dto.getBudget());
//        existente.setCategoria(categoriaMapper.toEntity(dto.getCategoria()));

        if (dto.getServicos() != null) {
            List<Servico> servicos = dto.getServicos().stream()
                    .map(servicoMapper::toEntity)
                    .collect(Collectors.toList());
            // Se tiver o campo projeto em Servico
            servicos.forEach(servico -> servico.setProjeto(existente));

            existente.getServicos().clear();
            existente.getServicos().addAll(servicos); // ← Agora está certo

        }

        atualizarCustoTotalProjeto(existente);

        Projeto atualizado = projetoRepository.save(existente);

        return new ResponseEntity<>(projetoMapper.toDTO(atualizado), HttpStatus.OK) ;

    }

    @Override
    public ResponseEntity<Void> deletar(long id) {
        Optional<Projeto> projetoOpt = projetoRepository.findById(id);
        if (projetoOpt.isPresent()){
            projetoRepository.delete(projetoOpt.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private void atualizarCustoTotalProjeto(Projeto projeto) {
        BigDecimal custoTotal = projeto.getServicos().stream()
                .map(Servico::getValor)
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        projeto.setCost(custoTotal);
    }

}
