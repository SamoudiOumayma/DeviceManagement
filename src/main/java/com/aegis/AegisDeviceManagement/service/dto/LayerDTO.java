package com.aegis.AegisDeviceManagement.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class LayerDTO implements Serializable {

    private UUID id;
    private String name;
    private String condition;
    private String elements;
    private UUID pageId;
}
