package com.costs.dto;

import com.costs.model.Categoria;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProjetoRequestDTO {

    private String nome;
    private BigDecimal budget;
    private CategoriaRequestDTO categoria;

}
