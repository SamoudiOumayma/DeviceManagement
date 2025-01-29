package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.DeviceError;
import com.aegis.AegisDeviceManagement.service.dto.DeviceErrorDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDeviceErrorMapper {

    DeviceErrorDTO toDTO(DeviceError deviceError);

    DeviceError toEntity(DeviceErrorDTO deviceErrorDTO);

    List<DeviceErrorDTO> toDTOList(List<DeviceError> deviceErrors);

    List<DeviceError> toEntityList(List<DeviceErrorDTO> deviceErrorDTOs);
}
