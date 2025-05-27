package com.costs.service;

import com.costs.dto.ProjetoRequestDTO;
import com.costs.dto.ProjetoResponseDTO;
import com.costs.model.Projeto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProjetoService {

    public ResponseEntity<ProjetoResponseDTO> salvar(ProjetoRequestDTO dto);
    public ResponseEntity<List<ProjetoResponseDTO>> recuperTodos();
    public ResponseEntity<ProjetoResponseDTO> buscarPorId(Long id);
    public ResponseEntity<List<ProjetoResponseDTO>> buscarPorNome(String nome);
    public ResponseEntity<ProjetoResponseDTO> atualizar(Long id, ProjetoRequestDTO dto);
    public ResponseEntity<Void> deletar(long id);
}
