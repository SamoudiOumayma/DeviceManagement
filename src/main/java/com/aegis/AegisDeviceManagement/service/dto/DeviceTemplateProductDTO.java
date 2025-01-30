package com.aegis.AegisDeviceManagement.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
public class DeviceTemplateProductDTO implements Serializable {

    private UUID templateId;
    private UUID deviceId;
    private UUID productId;
}
