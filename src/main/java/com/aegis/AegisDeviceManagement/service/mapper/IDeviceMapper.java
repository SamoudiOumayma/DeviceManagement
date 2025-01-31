package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.Device;
import com.aegis.AegisDeviceManagement.service.dto.DeviceDTO;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;

import java.util.List;
@Primary
@Mapper(componentModel = "spring")
public interface IDeviceMapper  extends IBaseMapper<Device, DeviceDTO> {

}
