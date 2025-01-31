package com.aegis.AegisDeviceManagement.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Model extends BaseEntity implements Serializable {

private static final long serialVersionUID = 31434368940132169L;

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private UUID id;

@OneToMany(mappedBy = "model", cascade = CascadeType.ALL, orphanRemoval = true)
private List<Device> devices = new ArrayList<>();

@Column(nullable = false)
private String key;

@Column(nullable = false)
private String value;

@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Model other)) return false;
    return Objects.equals(id, other.id) &&
                   Objects.equals(key, other.key) &&
                   Objects.equals(value, other.value);
}

@Override
public int hashCode() {
    return Objects.hash(id, key, value);
}

@Override
public String toString() {
    return "Model{" +
                   "id=" + id +
                   ", key='" + key + '\'' +
                   ", value='" + value + '\'' +
                   ", createdAt=" + getCreatedAt() +
                   ", updatedAt=" + getUpdatedAt() +
                   ", deleted=" + isDeleted() +
                   ", createdBy=" + getCreatedBy ( ) +
                   ", devicesCount=" + (devices != null ? devices.size() : 0) +
                   '}';
}
}
