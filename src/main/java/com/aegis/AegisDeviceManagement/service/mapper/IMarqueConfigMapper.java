package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.MarqueConfig;
import com.aegis.AegisDeviceManagement.service.dto.MarqueConfigDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMarqueConfigMapper {

    MarqueConfigDTO toDTO(MarqueConfig marqueConfig);

    MarqueConfig toEntity(MarqueConfigDTO marqueConfigDTO);

    List<MarqueConfigDTO> toDTOList(List<MarqueConfig> marqueConfigs);

    List<MarqueConfig> toEntityList(List<MarqueConfigDTO> marqueConfigDTOs);

}
