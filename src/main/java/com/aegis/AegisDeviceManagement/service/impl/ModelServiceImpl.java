package com.aegis.AegisDeviceManagement.service.impl;

import com.aegis.AegisDeviceManagement.service.IModelService;
import com.aegis.AegisDeviceManagement.service.dto.ModelDTO;
import com.aegis.AegisDeviceManagement.repository.ModelRepository;
import com.aegis.AegisDeviceManagement.service.mapper.IModelMapper;
import com.aegis.AegisDeviceManagement.domain.Model;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ModelServiceImpl implements IModelService {

private final ModelRepository modelRepository;
private final IModelMapper modelMapper;

public ModelServiceImpl(ModelRepository modelRepository, IModelMapper modelMapper) {
	this.modelRepository = modelRepository;
	this.modelMapper = modelMapper;
}

@Override
public ModelDTO createModel(ModelDTO modelDTO) {
	return save(modelMapper.toEntity(modelDTO));
}

@Override
public ModelDTO updateModel(UUID modelId, ModelDTO modelDTO) {
	Model model = findModelById(modelId);
	updateModelFields(model, modelDTO);
	return save(model);
}

@Override
public void deleteModel(UUID modelId) {
	if (!modelRepository.existsById(modelId)) {
		throw new RuntimeException("Model not found with ID: " + modelId);
	}
	modelRepository.deleteById(modelId);
}

@Override
public ModelDTO getModelById(UUID modelId) {
	return modelMapper.toDTO(findModelById(modelId));
}

@Override
public List<ModelDTO> getAllModels() {
	return modelRepository.findAll()
			       .stream()
			       .map(modelMapper::toDTO)
			       .collect(Collectors.toList());
}

// 🔹 Méthodes privées pour éviter la duplication de code

private Model findModelById(UUID modelId) {
	return modelRepository.findById(modelId)
			       .orElseThrow(() -> new RuntimeException("Model not found with ID: " + modelId));
}

private void updateModelFields(Model model, ModelDTO modelDTO) {
	model.setModelKey(modelDTO.getModelKey());
	model.setModelValue(modelDTO.getModelValue());
}

private ModelDTO save(Model model) {
	return modelMapper.toDTO(modelRepository.save(model));
}
}
