package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.Layer;
import com.aegis.AegisDeviceManagement.service.dto.LayerDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ILayerMapper {

    LayerDTO toDTO(Layer layer);

    Layer toEntity(LayerDTO layerDTO);

    List<LayerDTO> toDTOList(List<Layer> layers);

    List<Layer> toEntityList(List<LayerDTO> layerDTOs);
}
