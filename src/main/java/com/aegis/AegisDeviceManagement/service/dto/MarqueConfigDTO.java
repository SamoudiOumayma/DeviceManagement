package com.aegis.AegisDeviceManagement.service.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MarqueConfigDTO {

private UUID configId;
private String configName;
private String endpointUrl;
private String authMethod;
private String authCredentials;
private LocalDateTime lastConnectionAttempt;
private String connectionStatus;
private LocalDateTime createdAt;
private UUID marqueId;
}
