package com.aegis.AegisDeviceManagement.service.impl;

import com.aegis.AegisDeviceManagement.service.ILayerService;
import com.aegis.AegisDeviceManagement.service.dto.LayerDTO;
import com.aegis.AegisDeviceManagement.repository.LayerRepository;
import com.aegis.AegisDeviceManagement.service.mapper.ILayerMapper;
import com.aegis.AegisDeviceManagement.domain.Layer;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class LayerServiceImpl implements ILayerService {

    private final LayerRepository layerRepository;
    private final ILayerMapper layerMapper;

    public LayerServiceImpl(LayerRepository layerRepository, ILayerMapper layerMapper) {
        this.layerRepository = layerRepository;
        this.layerMapper = layerMapper;
    }

    @Override
    public LayerDTO createLayer(LayerDTO layerDTO) {
        return save(layerMapper.toEntity(layerDTO));
    }

    @Override
    public LayerDTO updateLayer(UUID layerId, LayerDTO layerDTO) {
        Layer layer = findLayerById(layerId);
        updateLayerFields(layer, layerDTO);
        return save(layer);
    }

    @Override
    public void deleteLayer(UUID layerId) {
        if (!layerRepository.existsById(layerId)) {
            throw new RuntimeException("Layer not found with ID: " + layerId);
        }
        layerRepository.deleteById(layerId);
    }

    @Override
    public LayerDTO getLayerById(UUID layerId) {
        return layerMapper.toDTO(findLayerById(layerId));
    }

    @Override
    public List<LayerDTO> getAllLayers() {
        return layerRepository.findAll()
                .stream()
                .map(layerMapper::toDTO)
                .collect(Collectors.toList());
    }

    private Layer findLayerById(UUID layerId) {
        return layerRepository.findById(layerId)
                .orElseThrow(() -> new RuntimeException("Layer not found with ID: " + layerId));
    }

    private void updateLayerFields(Layer layer, LayerDTO layerDTO) {
        layer.setName(layerDTO.getName());
        layer.setCondition(layerDTO.getCondition());
        layer.setElements(layerDTO.getElements());
    }

    private LayerDTO save(Layer layer) {
        return layerMapper.toDTO(layerRepository.save(layer));
    }

}
