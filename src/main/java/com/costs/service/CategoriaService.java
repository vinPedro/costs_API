package com.costs.service;

import com.costs.dto.CategoriaRequestDTO;
import com.costs.dto.CategoriaResponseDTO;
import com.costs.model.Categoria;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CategoriaService {

    public ResponseEntity<CategoriaResponseDTO> salvar(CategoriaRequestDTO dto);
    public ResponseEntity<List<CategoriaResponseDTO>> recuperTodos();
    public ResponseEntity<CategoriaResponseDTO> buscarPorId(Long id);
    public ResponseEntity<Void> deletar(long id);
}
