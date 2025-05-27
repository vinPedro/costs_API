package com.costs.controller;

import com.costs.dto.ProjetoRequestDTO;
import com.costs.dto.ProjetoResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProjetoControllerAPI {

    public ResponseEntity<ProjetoResponseDTO> salvar(@RequestBody ProjetoRequestDTO dto);
    public ResponseEntity<ProjetoResponseDTO> atualizar(@PathVariable Long id, @RequestBody ProjetoRequestDTO dto);
    public ResponseEntity<Void> deletar(@PathVariable Long id);
    public ResponseEntity<ProjetoResponseDTO> buscarPorId(@PathVariable Long id);
    public ResponseEntity<List<ProjetoResponseDTO>> buscarTodos();
    public ResponseEntity<List<ProjetoResponseDTO>> buscarPorNome(@RequestParam String nome);
}
