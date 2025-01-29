package com.aegis.AegisDeviceManagement.service.impl;

import com.aegis.AegisDeviceManagement.domain.Template;
import com.aegis.AegisDeviceManagement.repository.TemplateRepository;
import com.aegis.AegisDeviceManagement.service.ITemplateService;
import com.aegis.AegisDeviceManagement.service.dto.TemplateDTO;
import com.aegis.AegisDeviceManagement.service.mapper.ITemplateMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TemplateServiceImpl implements ITemplateService {

private final TemplateRepository templateRepository;
private final ITemplateMapper templateMapper;

public TemplateServiceImpl(TemplateRepository templateRepository, ITemplateMapper templateMapper) {
	this.templateRepository = templateRepository;
	this.templateMapper = templateMapper;
}

@Override
public TemplateDTO create( TemplateDTO templateDTO) {
	return saveTemplate(templateMapper.toEntity(templateDTO));
}

@Override
public TemplateDTO update(UUID templateId, TemplateDTO templateDTO) {
	Template template = getTemplate(templateId);
	template.setTemplateName(templateDTO.getTemplateName());
	template.setDescription(templateDTO.getDescription());
	template.setOrder(templateDTO.getOrder());
	template.setCondition(templateDTO.getCondition());
	return saveTemplate(template);
}

@Override
public void delete(UUID templateId) {
	if (!templateRepository.existsById(templateId)) {
		throw new RuntimeException("Template not found with ID: " + templateId);
	}
	templateRepository.deleteById(templateId);
}

@Override
public TemplateDTO getById(UUID templateId) {
	return templateMapper.toDTO(getTemplate(templateId));
}

@Override
public List<TemplateDTO> getAll() {
	return templateRepository.findAll()
			       .stream()
			       .map(templateMapper::toDTO)
			       .collect(Collectors.toList());
}


private Template getTemplate(UUID templateId) {
	return templateRepository.findById(templateId)
			       .orElseThrow(() -> new RuntimeException("Template not found with ID: " + templateId));
}

private TemplateDTO saveTemplate(Template template) {
	return templateMapper.toDTO(templateRepository.save(template));
}
}
