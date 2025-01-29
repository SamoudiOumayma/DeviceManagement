package com.aegis.AegisDeviceManagement.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Layer {

@Id
@GeneratedValue (strategy = GenerationType.AUTO)
private UUID layerId;

@Column (nullable = false)
private String layerName;

@Column(columnDefinition = "TEXT")
private String condition;

@Column(columnDefinition = "TEXT")
private String elements;

@ManyToOne
@JoinColumn(name = "page_id", nullable = false)
private Page page;
}
