package com.aegis.AegisDeviceManagement.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DTP {

@EmbeddedId
private DTPId id;

@ManyToOne
@MapsId ("templateId")
@JoinColumn (name = "template_id", nullable = false)
private Template template;

@ManyToOne
@MapsId("deviceId")
@JoinColumn(name = "device_id", nullable = false)
private Device device;

@ManyToOne
@MapsId("productId")
@JoinColumn(name = "product_id", nullable = false)
private Product product;

}
