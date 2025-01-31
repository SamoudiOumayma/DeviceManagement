package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.Model;
import com.aegis.AegisDeviceManagement.service.dto.ModelDTO;
import org.mapstruct.Mapper;
import org.springframework.context.annotation.Primary;

import java.util.List;
@Primary
@Mapper(componentModel = "spring")
public interface IModelMapper extends IBaseMapper<Model, ModelDTO> {

}
