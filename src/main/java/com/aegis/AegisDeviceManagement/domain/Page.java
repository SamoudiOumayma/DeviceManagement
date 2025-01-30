package com.aegis.AegisDeviceManagement.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Page implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String condition;

    @Column(columnDefinition = "TEXT")
    private String canvas;

    @ManyToOne
    @JoinColumn(name = "template_id", nullable = false)
    private Template template;

    @OneToMany(mappedBy = "page", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Layer> layers;
}
