package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.Template;
import com.aegis.AegisDeviceManagement.service.dto.TemplateDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ITemplateMapper {

    TemplateDTO toDTO(Template template);

    Template toEntity(TemplateDTO templateDTO);

    List<TemplateDTO> toDTOList(List<Template> templates);

    List<Template> toEntityList(List<TemplateDTO> templateDTOs);
}
