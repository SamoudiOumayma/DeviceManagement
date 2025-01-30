package com.aegis.AegisDeviceManagement.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MarqueConfigDTO implements Serializable {

    private UUID id;
    private String name;
    private String endpointUrl;
    private String authMethod;
    private String authCredentials;
    private LocalDateTime lastConnectionAttempt;
    private String connectionStatus;
    private LocalDateTime createdAt;
    private UUID marqueId;
}
