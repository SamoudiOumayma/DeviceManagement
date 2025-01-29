package com.aegis.AegisDeviceManagement.web;

import com.aegis.AegisDeviceManagement.service.ITemplateService;
import com.aegis.AegisDeviceManagement.service.dto.TemplateDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/device")
public class TemplateController {
    private final ITemplateService templateService;

    public TemplateController(ITemplateService templateService) {
        this.templateService = templateService;
    }

    @PostMapping("createTemplate")
    public TemplateDTO createTemplate(@RequestBody TemplateDTO templateDTO) {
        return templateService.createTemplate(templateDTO);
    }

    @GetMapping("getTemplate/{id}")
    public TemplateDTO getTemplateById(@PathVariable UUID id) {
        return templateService.getTemplateById(id);
    }

    @GetMapping("getAllTemplates")
    public List<TemplateDTO> getAllTemplates() {
        return templateService.getAllTemplates();
    }

    @PutMapping("updateTemplate/{id}")
    public TemplateDTO updateTemplate(@PathVariable UUID id, @RequestBody TemplateDTO templateDTO) {
        return templateService.updateTemplate(id, templateDTO);
    }

    @DeleteMapping("deleteTemplate/{id}")
    public void deleteTemplate(@PathVariable UUID id) {
        templateService.deleteTemplate(id);
    }
}

