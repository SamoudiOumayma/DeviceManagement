package com.aegis.AegisDeviceManagement.domain;

import com.aegis.AegisDeviceManagement.domain.enumeration.DeviceType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID deviceId;

    @Column(nullable = false)
    private String deviceName;

    private String deviceTag;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeviceType deviceType;

    private String status;

    private Float xCoordinate;

    private Float yCoordinate;

    private LocalDateTime lastSeen;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private UUID hardwareId;

    private Integer updateFrequency;

    @ManyToOne
    @JoinColumn(name = "marque_id", nullable = false)
    private Marque marque;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @OneToMany(mappedBy = "device", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DeviceError> deviceErrors;

}
