package com.aegis.AegisDeviceManagement.service;

import com.aegis.AegisDeviceManagement.service.dto.TemplateDTO;

import java.util.List;
import java.util.UUID;

public interface ITemplateService {

    TemplateDTO createTemplate(TemplateDTO templateDTO);

    TemplateDTO updateTemplate(UUID templateId, TemplateDTO templateDTO);

    void deleteTemplate(UUID templateId);

    TemplateDTO getTemplateById(UUID templateId);

    List<TemplateDTO> getAllTemplates();
}
