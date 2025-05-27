package com.costs.mapper;

import com.costs.dto.CategoriaRequestDTO;
import com.costs.dto.CategoriaResponseDTO;
import com.costs.model.Categoria;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    Categoria toEntity(CategoriaRequestDTO categoriaDTO);
    CategoriaResponseDTO toDTO(Categoria entityCategoria);
}
