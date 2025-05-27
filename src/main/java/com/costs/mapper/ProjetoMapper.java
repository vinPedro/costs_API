package com.costs.mapper;

import com.costs.dto.ProjetoRequestDTO;
import com.costs.dto.ProjetoResponseDTO;
import com.costs.model.Projeto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ServicoMapper.class, CategoriaMapper.class})
public interface ProjetoMapper {

    Projeto toEntity(ProjetoRequestDTO projetoDTO);
    ProjetoResponseDTO toDTO(Projeto entityProjeto);
}
