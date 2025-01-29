package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.DeviceError;
import com.aegis.AegisDeviceManagement.service.dto.DeviceErrorDTO;
import org.mapstruct.*;
<<<<<<< HEAD

=======
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
import java.util.List;

@Mapper(componentModel = "spring")
public interface IDeviceErrorMapper {

<<<<<<< HEAD
    DeviceErrorDTO toDTO(DeviceError deviceError);

    DeviceError toEntity(DeviceErrorDTO deviceErrorDTO);

    List<DeviceErrorDTO> toDTOList(List<DeviceError> deviceErrors);

    List<DeviceError> toEntityList(List<DeviceErrorDTO> deviceErrorDTOs);
=======
DeviceErrorDTO toDTO( DeviceError deviceError);

DeviceError toEntity(DeviceErrorDTO deviceErrorDTO);

List<DeviceErrorDTO> toDTOList(List<DeviceError> deviceErrors);

List<DeviceError> toEntityList(List<DeviceErrorDTO> deviceErrorDTOs);
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
}
