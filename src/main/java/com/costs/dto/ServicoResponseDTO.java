package com.costs.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServicoResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal valor;
}
