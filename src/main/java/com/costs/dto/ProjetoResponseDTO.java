package com.costs.dto;

import com.costs.model.Categoria;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProjetoResponseDTO {

    private Long id;
    private String nome;
    private BigDecimal budget;
    private BigDecimal cost;
    private CategoriaResponseDTO categoria;
    private List<ServicoResponseDTO> servicos;
}
