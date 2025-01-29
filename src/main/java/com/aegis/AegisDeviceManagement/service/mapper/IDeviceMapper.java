package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.Device;
import com.aegis.AegisDeviceManagement.service.dto.DeviceDTO;
import org.mapstruct.*;
<<<<<<< HEAD

=======
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
import java.util.List;

@Mapper(componentModel = "spring")
public interface IDeviceMapper {

<<<<<<< HEAD
    DeviceDTO toDTO(Device device);

    Device toEntity(DeviceDTO deviceDTO);

    List<DeviceDTO> toDTOList(List<Device> devices);

    List<Device> toEntityList(List<DeviceDTO> deviceDTOs);
=======
DeviceDTO toDTO( Device device);

Device toEntity(DeviceDTO deviceDTO);

List<DeviceDTO> toDTOList(List<Device> devices);

List<Device> toEntityList(List<DeviceDTO> deviceDTOs);
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
}
