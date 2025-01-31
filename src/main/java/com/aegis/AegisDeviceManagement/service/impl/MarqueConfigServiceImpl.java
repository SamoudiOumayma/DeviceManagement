package com.aegis.AegisDeviceManagement.service.impl;

import com.aegis.AegisDeviceManagement.domain.Marque;
import com.aegis.AegisDeviceManagement.repository.IMarqueConfigRepository;
import com.aegis.AegisDeviceManagement.repository.IMarqueRepository;
import com.aegis.AegisDeviceManagement.service.IMarqueConfigService;
import com.aegis.AegisDeviceManagement.service.dto.MarqueConfigDTO;
import com.aegis.AegisDeviceManagement.service.mapper.IMarqueConfigMapper;
import com.aegis.AegisDeviceManagement.domain.MarqueConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MarqueConfigServiceImpl implements IMarqueConfigService {

    @Autowired
    private IMarqueRepository marqueRepository;
    private final IMarqueConfigRepository marqueConfigRepository;
    private final IMarqueConfigMapper marqueConfigMapper;

    public MarqueConfigServiceImpl(IMarqueConfigRepository marqueConfigRepository, IMarqueConfigMapper marqueConfigMapper) {
        this.marqueConfigRepository = marqueConfigRepository;
        this.marqueConfigMapper = marqueConfigMapper;
    }

    @Override
    public MarqueConfigDTO createMarqueConfig(MarqueConfigDTO marqueConfigDTO) {
        return  save (marqueConfigMapper.toEntity(marqueConfigDTO));

    }
    
    @Override
    public MarqueConfigDTO updateMarqueConfig(UUID configId, MarqueConfigDTO marqueConfigDTO) {
        if(!marqueConfigRepository.isDeleted ( configId )) {
            throw new RuntimeException ( "maque config does not exist" );
        }
        MarqueConfig marqueConfig = findMarqueConfigById(configId);
        updateMarqueConfigFields(marqueConfig, marqueConfigDTO);
        return save(marqueConfig);
    }

    @Override
    public void deleteMarqueConfig(UUID configId) {
        if (!marqueConfigRepository.existsById(configId)) {
            throw new RuntimeException("Config not found with ID: " + configId);
        }
        marqueConfigRepository.softDelete(configId);
    }

    @Override
    public MarqueConfigDTO getMarqueConfigById(UUID configId) {
        if(!marqueConfigRepository.isDeleted ( configId )) {
            throw new RuntimeException ( "maque config does not exist" );
        }
        return marqueConfigMapper.toDTO(findMarqueConfigById(configId));
    }

    @Override
    public List<MarqueConfigDTO> getAllMarqueConfigs() {
        return marqueConfigRepository.findAllActive ()
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
        marqueConfig.setUpdatedAt ( LocalDateTime.from ( java.time.Instant.now () ) );

    }

    private MarqueConfigDTO save(MarqueConfig marqueConfig) {
        return marqueConfigMapper.toDTO(marqueConfigRepository.save(marqueConfig));
    }

}
