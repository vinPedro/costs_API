package com.costs.repository;

import com.costs.model.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {

    public List<Projeto> findByNomeContainingIgnoreCase(String nome);
}
