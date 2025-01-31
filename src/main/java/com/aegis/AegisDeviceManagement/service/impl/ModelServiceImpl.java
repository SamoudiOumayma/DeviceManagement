package com.aegis.AegisDeviceManagement.service.impl;

import com.aegis.AegisDeviceManagement.repository.IModelRepository;
import com.aegis.AegisDeviceManagement.service.IModelService;
import com.aegis.AegisDeviceManagement.service.dto.ModelDTO;
import com.aegis.AegisDeviceManagement.service.mapper.IModelMapper;
import com.aegis.AegisDeviceManagement.domain.Model;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements IModelService {

    private final IModelRepository modelRepository;
    private final IModelMapper modelMapper;

    public ModelServiceImpl(IModelRepository modelRepository, IModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelDTO createModel(ModelDTO modelDTO) {
        return save(modelMapper.toEntity(modelDTO));
    }

    @Override
    public ModelDTO updateModel(UUID modelId, ModelDTO modelDTO) {
        if(!modelRepository.isDeleted ( modelId )) {
            throw new RuntimeException ("model not found");
        }
        Model model = findModelById(modelId);
        updateModelFields(model, modelDTO);
        return save(model);
    }

    @Override
    public void deleteModel(UUID modelId) {
        if (!modelRepository.existsById(modelId)) {
            throw new RuntimeException("Model not found with ID: " + modelId);
        }
        modelRepository.softDelete(modelId);

    }

    @Override
    public ModelDTO getModelById(UUID modelId) {
        if(!modelRepository.isDeleted ( modelId )) {
            throw new RuntimeException ("model not found");
        }
        return modelMapper.toDTO(findModelById(modelId));
    }

    @Override
    public List<ModelDTO> getAllModels() {
        return modelRepository.findAllActive ()
                .stream()
                .map(modelMapper::toDTO)
                .collect(Collectors.toList());
    }


    private Model findModelById(UUID modelId) {
        return modelRepository.findById(modelId)
                .orElseThrow(() -> new RuntimeException("Model not found with ID: " + modelId));
    }

    private void updateModelFields(Model model, ModelDTO modelDTO) {
        model.setKey(modelDTO.getKey());
        model.setValue(modelDTO.getValue());
        model.setUpdatedAt ( LocalDateTime.from ( java.time.Instant.now () ) );
    }

    private ModelDTO save(Model model) {
        return modelMapper.toDTO(modelRepository.save(model));
    }

}
