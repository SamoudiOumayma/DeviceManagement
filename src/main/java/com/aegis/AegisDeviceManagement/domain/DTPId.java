package com.aegis.AegisDeviceManagement.domain;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class DTPId implements Serializable {

private UUID templateId;
private UUID deviceId;
private UUID productId;

}
