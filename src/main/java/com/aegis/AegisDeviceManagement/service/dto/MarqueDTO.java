package com.aegis.AegisDeviceManagement.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class MarqueDTO extends BaseEntityDTO implements  Serializable {

    private UUID id;
    private String name;
    private String description;
    private String logo;
}
