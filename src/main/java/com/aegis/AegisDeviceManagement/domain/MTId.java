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
public class MTId implements Serializable {

private UUID modelId;
private UUID templateId;

}
