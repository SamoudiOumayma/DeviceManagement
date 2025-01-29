package com.aegis.AegisDeviceManagement.service;

import com.aegis.AegisDeviceManagement.service.dto.LayerDTO;

import java.util.List;
import java.util.UUID;

public interface ILayerService {

    LayerDTO createLayer(LayerDTO layerDTO);

    LayerDTO updateLayer(UUID layerId, LayerDTO layerDTO);

    void deleteLayer(UUID layerId);

    LayerDTO getLayerById(UUID layerId);

    List<LayerDTO> getAllLayers();
}
