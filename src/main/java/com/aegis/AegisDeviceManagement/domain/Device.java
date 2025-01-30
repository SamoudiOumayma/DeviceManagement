package com.aegis.AegisDeviceManagement.domain;

import com.aegis.AegisDeviceManagement.domain.enumeration.DeviceType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Device implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String tag;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DeviceType type;

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
    private List<Error> errors;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Device device)) return false;
        return Objects.equals(getId(), device.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Device{" +
                "deviceId=" + id +
                ", deviceName='" + name + '\'' +
                ", deviceTag='" + tag + '\'' +
                ", deviceType=" + type +
                ", status='" + status + '\'' +
                ", xCoordinate=" + xCoordinate +
                ", yCoordinate=" + yCoordinate +
                ", lastSeen=" + lastSeen +
                ", createdAt=" + createdAt +
                ", hardwareId=" + hardwareId +
                ", updateFrequency=" + updateFrequency +
                ", marque=" + marque +
                ", model=" + model +
                ", deviceErrors=" + errors +
                '}';
    }
}
