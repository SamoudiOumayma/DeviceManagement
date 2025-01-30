package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.ModelTemplate;
import com.aegis.AegisDeviceManagement.service.dto.ModelTemplateDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IModelTemplateMapper {

    ModelTemplateDTO toDTO(ModelTemplate modelTemplate);

    ModelTemplate toEntity(ModelTemplateDTO mtDTO);

    List<ModelTemplateDTO> toDTOList(List<ModelTemplate> modelTemplates);

    List<ModelTemplate> toEntityList(List<ModelTemplateDTO> mtDTOs);

}
