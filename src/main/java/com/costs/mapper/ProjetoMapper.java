package com.costs.mapper;

import com.costs.dto.ProjetoRequestDTO;
import com.costs.dto.ProjetoResponseDTO;
import com.costs.model.Projeto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring", uses = {ServicoMapper.class, CategoriaMapper.class}, nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE )
public interface ProjetoMapper {

    Projeto toEntity(ProjetoRequestDTO projetoDTO);
    ProjetoResponseDTO toDTO(Projeto entityProjeto);
    void updateUsuario(ProjetoRequestDTO projetoDTO, @MappingTarget Projeto entityProjeto);
}
