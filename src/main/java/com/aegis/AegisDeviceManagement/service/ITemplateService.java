package com.aegis.AegisDeviceManagement.service;

import com.aegis.AegisDeviceManagement.service.dto.TemplateDTO;

import java.util.List;
import java.util.UUID;

public interface ITemplateService {

TemplateDTO create( TemplateDTO templateDTO);
TemplateDTO update(UUID templateId, TemplateDTO templateDTO);
void delete(UUID templateId);
TemplateDTO getById(UUID templateId);
List<TemplateDTO> getAll();
}
