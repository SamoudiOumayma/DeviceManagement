package com.aegis.AegisDeviceManagement.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public abstract class BaseEntityDTO implements Serializable {

private UUID id;
private LocalDateTime createdAt;
private LocalDateTime updatedAt;
private LocalDateTime createdBy;
private boolean deleted;
}
