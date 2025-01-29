package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.Model;
import com.aegis.AegisDeviceManagement.service.dto.ModelDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IModelMapper {

<<<<<<< HEAD
    ModelDTO toDTO(Model model);

    Model toEntity(ModelDTO modelDTO);

    List<ModelDTO> toDTOList(List<Model> models);

    List<Model> toEntityList(List<ModelDTO> modelDTOs);
=======
ModelDTO toDTO(Model model);

Model toEntity(ModelDTO modelDTO);

List<ModelDTO> toDTOList(List<Model> models);

List<Model> toEntityList(List<ModelDTO> modelDTOs);
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
}
