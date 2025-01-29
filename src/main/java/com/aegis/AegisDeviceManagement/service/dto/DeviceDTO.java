package com.aegis.AegisDeviceManagement.service.dto;

import com.aegis.AegisDeviceManagement.domain.enumeration.DeviceType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class DeviceDTO {

    private UUID deviceId;
    private String deviceName;
    private String deviceTag;
    private DeviceType deviceType;
    private String status;
    private Float xCoordinate;
    private Float yCoordinate;
    private LocalDateTime lastSeen;
    private LocalDateTime createdAt;
    private Integer updateFrequency;
    private UUID marqueId;
    private UUID modelId;
}
