package com.costs.controller.impl;

import com.costs.dto.CategoriaRequestDTO;
import com.costs.dto.CategoriaResponseDTO;
import com.costs.dto.ServicoRequestDTO;
import com.costs.dto.ServicoResponseDTO;
import com.costs.service.CategoriaService;
import com.costs.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<ServicoResponseDTO> salvar(@RequestBody ServicoRequestDTO dto) {
        return servicoService.salvar(dto);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        return servicoService.deletar(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> buscarPorId(@PathVariable Long id) {
        return servicoService.buscarPorId(id);
    }

    @GetMapping
    public ResponseEntity<List<ServicoResponseDTO>> buscarTodos() {
        return servicoService.recuperTodos();
    }
}
