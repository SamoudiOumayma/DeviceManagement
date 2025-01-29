package com.aegis.AegisDeviceManagement.service;

import com.aegis.AegisDeviceManagement.service.dto.ModelDTO;

import java.util.List;
import java.util.UUID;

public interface IModelService {
    ModelDTO createModel(ModelDTO modelDTO);

    ModelDTO updateModel(UUID modelId, ModelDTO modelDTO);

    void deleteModel(UUID modelId);

    ModelDTO getModelById(UUID modelId);

    List<ModelDTO> getAllModels();
}
