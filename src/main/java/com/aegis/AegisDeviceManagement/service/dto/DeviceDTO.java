package com.aegis.AegisDeviceManagement.service.dto;

import com.aegis.AegisDeviceManagement.domain.enumeration.DeviceType;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class DeviceDTO extends BaseEntityDTO implements Serializable {

    private UUID id;
    private String name;
    private String tag;
    private DeviceType type;
    private String status;
    private Float xCoordinate;
    private Float yCoordinate;
    private LocalDateTime lastSeen;
    private Integer updateFrequency;
    private UUID marqueId;
    private UUID marqueConfigId;
    private UUID modelId;
}
