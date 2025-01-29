package com.aegis.AegisDeviceManagement.domain;

import com.aegis.AegisDeviceManagement.domain.enumeration.DeviceErrorType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeviceError {

@Id
@GeneratedValue (strategy = GenerationType.AUTO)
private UUID errorId;

@Column (nullable = false)
private String referenced;

@Enumerated(EnumType.STRING)
@Column(nullable = false)
private DeviceErrorType errorType;

private String errorMessage;

private int retryCount;

@Column(nullable = false)
private String referenceType;

private String errorCode;

private String supplierStatus;

private LocalDateTime attemptAt;

@ManyToOne
@JoinColumn(name = "device_id", nullable = false)
private Device device;
}
