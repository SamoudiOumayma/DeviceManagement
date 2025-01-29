package com.aegis.AegisDeviceManagement.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID modelId;

    @OneToMany(mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Device> devices = new ArrayList<>();

    @Column(nullable = false)
    private String modelKey;

    @Column(nullable = false)
    private String modelValue;

}
