package com.aegis.AegisDeviceManagement.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page {

@Id
@GeneratedValue (strategy = GenerationType.AUTO)
private UUID pageId;

@Column (nullable = false)
private String pageName;

@Column(columnDefinition = "TEXT")
private String condition;

@Column(columnDefinition = "TEXT")
private String canvas;

@OneToMany(mappedBy = "page", cascade = CascadeType.ALL, orphanRemoval = true)
private List< Layer > layers;
}
