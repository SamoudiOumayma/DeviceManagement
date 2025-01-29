package com.aegis.AegisDeviceManagement.service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class LayerDTO {

    private UUID layerId;
    private String layerName;
    private String condition;
    private String elements;
    private UUID pageId;
}
