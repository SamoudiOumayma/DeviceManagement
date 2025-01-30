package com.aegis.AegisDeviceManagement.service.dto;

import com.aegis.AegisDeviceManagement.domain.enumeration.DeviceErrorType;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class ErrorDTO implements Serializable {

    private UUID id;
    private String referenced;
    private DeviceErrorType type;
    private String message;
    private int retryCount;
    private String referenceType;
    private String errorCode;
    private String supplierStatus;
    private LocalDateTime attemptAt;
    private UUID deviceId;
}
