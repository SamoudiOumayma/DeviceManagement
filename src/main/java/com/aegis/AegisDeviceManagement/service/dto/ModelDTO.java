package com.aegis.AegisDeviceManagement.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class ModelDTO extends BaseEntityDTO implements Serializable {

    private UUID id;
    private String key;
    private String value;
}
