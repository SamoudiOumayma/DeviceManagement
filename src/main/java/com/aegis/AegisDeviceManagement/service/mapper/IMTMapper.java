package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.MT;
import com.aegis.AegisDeviceManagement.service.dto.MTDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMTMapper {

    MTDTO toDTO(MT mt);

    MT toEntity(MTDTO mtDTO);

    List<MTDTO> toDTOList(List<MT> mts);

    List<MT> toEntityList(List<MTDTO> mtDTOs);
}
