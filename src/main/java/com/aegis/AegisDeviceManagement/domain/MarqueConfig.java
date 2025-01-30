package com.aegis.AegisDeviceManagement.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarqueConfig implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String endpointUrl;

    private String authMethod;

    @Column(columnDefinition = "TEXT")
    private String authCredentials;

    private LocalDateTime lastConnectionAttempt;

    private String connectionStatus;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "marque_id", nullable = false)
    private Marque marque;
}
