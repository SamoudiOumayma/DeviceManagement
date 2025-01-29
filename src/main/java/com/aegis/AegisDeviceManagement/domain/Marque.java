package com.aegis.AegisDeviceManagement.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Marque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID marqueId;

    @Column(nullable = false)
    private String marqueName;

    private String description;

    @Column(columnDefinition = "TEXT")
    private String logo;

    @OneToMany(mappedBy = "marque", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Device> devices = new ArrayList<>();
}
