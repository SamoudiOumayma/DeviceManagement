package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.Marque;
import com.aegis.AegisDeviceManagement.service.dto.MarqueDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMarqueMapper {

    MarqueDTO toDTO(Marque marque);

    Marque toEntity(MarqueDTO marqueDTO);

    List<MarqueDTO> toDTOList(List<Marque> marques);

    List<Marque> toEntityList(List<MarqueDTO> marqueDTOs);

}
