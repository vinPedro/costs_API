package com.costs.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ServicoRequestDTO {

    private String nome;
    private String descricao;
    private BigDecimal cost;
}
