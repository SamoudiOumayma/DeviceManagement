package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.Template;
import com.aegis.AegisDeviceManagement.service.dto.TemplateDTO;
import org.mapstruct.*;
<<<<<<< HEAD

=======
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
import java.util.List;

@Mapper(componentModel = "spring")
public interface ITemplateMapper {

<<<<<<< HEAD
    TemplateDTO toDTO(Template template);

    Template toEntity(TemplateDTO templateDTO);

    List<TemplateDTO> toDTOList(List<Template> templates);

    List<Template> toEntityList(List<TemplateDTO> templateDTOs);
=======
TemplateDTO toDTO( Template template);

Template toEntity(TemplateDTO templateDTO);

List<TemplateDTO> toDTOList(List<Template> templates);

List<Template> toEntityList(List<TemplateDTO> templateDTOs);
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
}
