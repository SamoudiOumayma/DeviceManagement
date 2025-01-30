package com.aegis.AegisDeviceManagement.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class ModelTemplateDTO implements Serializable {

    private UUID modelId;
    private UUID templateId;
}
