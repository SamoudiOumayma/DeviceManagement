package com.aegis.AegisDeviceManagement.service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class MarqueDTO {

    private UUID marqueId;
    private String marqueName;
    private String description;
    private String logo;
}
