package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.Device;
import com.aegis.AegisDeviceManagement.domain.MarqueConfig;
import com.aegis.AegisDeviceManagement.service.dto.DeviceDTO;
import com.aegis.AegisDeviceManagement.service.dto.MarqueConfigDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.context.annotation.Primary;

import java.util.List;
@Primary
@Mapper(componentModel = "spring")
public interface IMarqueConfigMapper extends  IBaseMapper< MarqueConfig, MarqueConfigDTO > {


}
