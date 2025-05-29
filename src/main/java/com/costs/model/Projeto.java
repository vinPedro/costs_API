package com.costs.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;
    private BigDecimal budget;

    private BigDecimal cost = BigDecimal.ZERO;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "projeto_id")
    private List<Servico> servicos = new ArrayList<Servico>();
}
