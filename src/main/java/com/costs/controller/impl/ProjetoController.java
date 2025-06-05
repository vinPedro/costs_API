package com.costs.controller.impl;

import com.costs.controller.ProjetoControllerAPI;
import com.costs.dto.ProjetoRequestDTO;
import com.costs.dto.ProjetoResponseDTO;
import com.costs.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/projetos")
public class ProjetoController implements ProjetoControllerAPI {

    @Autowired
    private ProjetoService projetoService;

    @PostMapping
    public ResponseEntity<ProjetoResponseDTO> salvar(@RequestBody ProjetoRequestDTO dto) {
        return projetoService.salvar(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjetoResponseDTO> atualizar(@PathVariable Long id, @RequestBody ProjetoRequestDTO dto) {
        return projetoService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return projetoService.deletar(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoResponseDTO> buscarPorId(@PathVariable Long id) {
        return projetoService.buscarPorId(id);
    }

    @GetMapping
    public ResponseEntity<List<ProjetoResponseDTO>> buscarTodos() {
        return projetoService.recuperTodos();
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<ProjetoResponseDTO>> buscarPorNome(@RequestParam String nome) {
        return projetoService.buscarPorNome(nome);
    }
}
