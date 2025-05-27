package com.costs.service;

import com.costs.dto.ServicoRequestDTO;
import com.costs.dto.ServicoResponseDTO;
import com.costs.model.Servico;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ServicoService {

    public ResponseEntity<ServicoResponseDTO> salvar(ServicoRequestDTO dto);
    public ResponseEntity<List<ServicoResponseDTO>> recuperTodos();
    public ResponseEntity<ServicoResponseDTO> buscarPorId(Long id);
    public ResponseEntity<Void> deletar(long id);

}
