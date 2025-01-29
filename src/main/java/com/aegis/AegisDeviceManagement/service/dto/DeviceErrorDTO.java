package com.aegis.AegisDeviceManagement.service.dto;

import com.aegis.AegisDeviceManagement.domain.enumeration.DeviceErrorType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class DeviceErrorDTO {

private UUID errorId;
private String referenced;
private DeviceErrorType errorType;
private String errorMessage;
private int retryCount;
private String referenceType;
private String errorCode;
private String supplierStatus;
private LocalDateTime attemptAt;
private UUID deviceId;
}
