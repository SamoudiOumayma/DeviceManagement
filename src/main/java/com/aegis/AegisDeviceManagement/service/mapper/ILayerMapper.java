package com.aegis.AegisDeviceManagement.service.mapper;

import com.aegis.AegisDeviceManagement.domain.Layer;
import com.aegis.AegisDeviceManagement.service.dto.LayerDTO;
import org.mapstruct.*;
<<<<<<< HEAD

=======
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
import java.util.List;

@Mapper(componentModel = "spring")
public interface ILayerMapper {

<<<<<<< HEAD
    LayerDTO toDTO(Layer layer);

    Layer toEntity(LayerDTO layerDTO);

    List<LayerDTO> toDTOList(List<Layer> layers);

    List<Layer> toEntityList(List<LayerDTO> layerDTOs);
=======
LayerDTO toDTO( Layer layer);

Layer toEntity(LayerDTO layerDTO);

List<LayerDTO> toDTOList(List<Layer> layers);

List<Layer> toEntityList(List<LayerDTO> layerDTOs);
>>>>>>> fd2916cb76622af27e886c3de364282dc20bf0d6
}
