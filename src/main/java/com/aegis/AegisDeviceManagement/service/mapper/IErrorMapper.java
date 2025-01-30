package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.Error;
import com.aegis.AegisDeviceManagement.service.dto.ErrorDTO;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface IErrorMapper {

    ErrorDTO toDTO(Error deviceError);

    Error toEntity(ErrorDTO errorDTO);

    List<ErrorDTO> toDTOList(List<Error> deviceErrors);

    List<Error> toEntityList(List<ErrorDTO> errorDTOS);

}
