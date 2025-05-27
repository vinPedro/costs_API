package com.costs.service.impl;

import com.costs.dto.ServicoRequestDTO;
import com.costs.dto.ServicoResponseDTO;
import com.costs.mapper.ServicoMapper;
import com.costs.model.Servico;
import com.costs.repository.ServicoRepository;
import com.costs.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServicoServiceImpl implements ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    @Autowired
    private ServicoMapper servicoMapper;

    @Override
    public ResponseEntity<ServicoResponseDTO> salvar(ServicoRequestDTO dto) {
        Servico servico = servicoMapper.toEntity(dto);
        Servico salvo = servicoRepository.save(servico);
        return new ResponseEntity<>(servicoMapper.toDTO(salvo), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<ServicoResponseDTO>> recuperTodos(){
        List<Servico> servicos = servicoRepository.findAll();
        List<ServicoResponseDTO> dtoList = servicos.stream()
                .map(servicoMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ServicoResponseDTO> buscarPorId(Long id){
        Optional<Servico> servico = servicoRepository.findById(id);
        return servico
                .map(value -> new ResponseEntity<>(servicoMapper.toDTO(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Void>  deletar(long id){
        Optional<Servico> servicoOpt = servicoRepository.findById(id);
        if(servicoOpt.isPresent()){
            servicoRepository.delete(servicoOpt.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
