package com.aegis.AegisDeviceManagement.service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class TemplateDTO {

private UUID templateId;
private String templateName;
private String description;
private String requiredFiles;
private Integer order;
private String condition;
}
