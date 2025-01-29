package com.aegis.AegisDeviceManagement.service;

import com.aegis.AegisDeviceManagement.service.dto.MarqueConfigDTO;

import java.util.List;
import java.util.UUID;

public interface IMarqueConfigService {

    MarqueConfigDTO createMarqueConfig(MarqueConfigDTO marqueConfigDTO);

    MarqueConfigDTO updateMarqueConfig(UUID configId, MarqueConfigDTO marqueConfigDTO);

    void deleteMarqueConfig(UUID configId);

    MarqueConfigDTO getMarqueConfigById(UUID configId);

    List<MarqueConfigDTO> getAllMarqueConfigs();

}
