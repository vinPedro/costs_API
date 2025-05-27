package com.costs.mapper;

import com.costs.dto.ServicoRequestDTO;
import com.costs.dto.ServicoResponseDTO;
import com.costs.model.Servico;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ServicoMapper {

    Servico toEntity(ServicoRequestDTO ServicoDTO);
    ServicoResponseDTO toDTO(Servico entityServico);
}
