package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.Device;
import com.aegis.AegisDeviceManagement.service.dto.DeviceDTO;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "spring")
public interface IDeviceMapper {

DeviceDTO toDTO( Device device);

Device toEntity(DeviceDTO deviceDTO);

List<DeviceDTO> toDTOList(List<Device> devices);

List<Device> toEntityList(List<DeviceDTO> deviceDTOs);
}
