package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.DeviceTemplateProduct;
import com.aegis.AegisDeviceManagement.service.dto.DeviceTemplateProductDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IDeviceTemplateProductMapper {

    DeviceTemplateProductDTO toDTO(DeviceTemplateProduct deviceTemplateProduct);

    DeviceTemplateProduct toEntity(DeviceTemplateProductDTO dtpDTO);

    List<DeviceTemplateProductDTO> toDTOList(List<DeviceTemplateProduct> deviceTemplateProducts);

    List<DeviceTemplateProduct> toEntityList(List<DeviceTemplateProductDTO> dtpDTOs);

}
