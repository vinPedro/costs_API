package com.costs.service.impl;

import com.costs.dto.CategoriaRequestDTO;
import com.costs.dto.CategoriaResponseDTO;
import com.costs.mapper.CategoriaMapper;
import com.costs.model.Categoria;
import com.costs.model.Projeto;
import com.costs.repository.CategoriaRepository;
import com.costs.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private CategoriaMapper categoriaMapper;

    @Override
    public ResponseEntity<CategoriaResponseDTO> salvar(CategoriaRequestDTO dto) {
        Categoria categoria = categoriaMapper.toEntity(dto);
        Categoria salvo = categoriaRepository.save(categoria);
        return new ResponseEntity<>(categoriaMapper.toDTO(salvo), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CategoriaResponseDTO>> recuperTodos() {
        List<Categoria> categorias = categoriaRepository.findAll();
        List<CategoriaResponseDTO> dtoList = categorias.stream()
                .map(categoriaMapper::toDTO)
                .collect(Collectors.toList());
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CategoriaResponseDTO> buscarPorId(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria
                .map(value -> new ResponseEntity<>(categoriaMapper.toDTO(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Void> deletar(long id) {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(id);
        if(categoriaOpt.isPresent()){
            categoriaRepository.delete(categoriaOpt.get());
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
