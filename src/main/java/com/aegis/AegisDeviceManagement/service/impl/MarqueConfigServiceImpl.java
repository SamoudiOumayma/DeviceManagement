package com.aegis.AegisDeviceManagement.service.impl;

import com.aegis.AegisDeviceManagement.domain.Marque;
import com.aegis.AegisDeviceManagement.repository.MarqueRepository;
import com.aegis.AegisDeviceManagement.service.IMarqueConfigService;
import com.aegis.AegisDeviceManagement.service.dto.MarqueConfigDTO;
import com.aegis.AegisDeviceManagement.repository.MarqueConfigRepository;
import com.aegis.AegisDeviceManagement.service.mapper.IMarqueConfigMapper;
import com.aegis.AegisDeviceManagement.domain.MarqueConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MarqueConfigServiceImpl implements IMarqueConfigService {

    @Autowired
    private MarqueRepository marqueRepository;
    private final MarqueConfigRepository marqueConfigRepository;
    private final IMarqueConfigMapper marqueConfigMapper;

    public MarqueConfigServiceImpl(MarqueConfigRepository marqueConfigRepository, IMarqueConfigMapper marqueConfigMapper) {
        this.marqueConfigRepository = marqueConfigRepository;
        this.marqueConfigMapper = marqueConfigMapper;
    }

    @Override
    public MarqueConfigDTO createMarqueConfig(MarqueConfigDTO marqueConfigDTO) {
        MarqueConfig marqueConfig = marqueConfigMapper.toEntity(marqueConfigDTO);

        Marque existingMarque = marqueRepository.findById(marqueConfigDTO.getMarqueId())
                .orElseThrow(() -> new RuntimeException("Marque not found"));
        marqueConfig.setMarque(existingMarque);

        marqueConfig = marqueConfigRepository.save(marqueConfig);

        MarqueConfigDTO responseDTO = marqueConfigMapper.toDTO(marqueConfig);
        responseDTO.setMarqueId(existingMarque.getId());
        return responseDTO;
    }
    
    @Override
    public MarqueConfigDTO updateMarqueConfig(UUID configId, MarqueConfigDTO marqueConfigDTO) {
        MarqueConfig marqueConfig = findMarqueConfigById(configId);
        updateMarqueConfigFields(marqueConfig, marqueConfigDTO);
        return save(marqueConfig);
    }

    @Override
    public void deleteMarqueConfig(UUID configId) {
        if (!marqueConfigRepository.existsById(configId)) {
            throw new RuntimeException("MarqueConfig not found with ID: " + configId);
        }
        marqueConfigRepository.deleteById(configId);
    }

    @Override
    public MarqueConfigDTO getMarqueConfigById(UUID configId) {
        return marqueConfigMapper.toDTO(findMarqueConfigById(configId));
    }

    @Override
    public List<MarqueConfigDTO> getAllMarqueConfigs() {
        return marqueConfigRepository.findAll()
                .stream()
                .map(marqueConfigMapper::toDTO)
                .collect(Collectors.toList());
    }


    private MarqueConfig findMarqueConfigById(UUID configId) {
        return marqueConfigRepository.findById(configId)
                .orElseThrow(() -> new RuntimeException("MarqueConfig not found with ID: " + configId));
    }

    private void updateMarqueConfigFields(MarqueConfig marqueConfig, MarqueConfigDTO marqueConfigDTO) {
        marqueConfig.setName(marqueConfigDTO.getName());
        marqueConfig.setEndpointUrl(marqueConfigDTO.getEndpointUrl());
        marqueConfig.setAuthMethod(marqueConfigDTO.getAuthMethod());
        marqueConfig.setAuthCredentials(marqueConfigDTO.getAuthCredentials());
        marqueConfig.setConnectionStatus(marqueConfigDTO.getConnectionStatus());
    }

    private MarqueConfigDTO save(MarqueConfig marqueConfig) {
        return marqueConfigMapper.toDTO(marqueConfigRepository.save(marqueConfig));
    }

}
