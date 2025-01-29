package com.aegis.AegisDeviceManagement.service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class ModelDTO {

    private UUID modelId;
    private String modelKey;
    private String modelValue;
}
