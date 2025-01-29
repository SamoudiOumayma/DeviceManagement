package com.aegis.AegisDeviceManagement.service.dto;

import lombok.Data;

import java.util.UUID;

@Data
public class DTPDTO {

    private UUID dtpId;
    private UUID templateId;
    private UUID deviceId;
    private UUID productId;
}
