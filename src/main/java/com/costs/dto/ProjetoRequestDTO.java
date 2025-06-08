package com.costs.dto;

import com.costs.model.Categoria;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProjetoRequestDTO {

    private String nome;
    private BigDecimal budget;
    private CategoriaRequestDTO categoria;
    private List<ServicoRequestDTO> servicos;

}
