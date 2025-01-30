package com.aegis.AegisDeviceManagement.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;

    private UUID originalId;

    @ElementCollection
    @CollectionTable(name = "product_data", joinColumns = @JoinColumn(name = "product_id"))
    @MapKeyColumn(name = "key")
    @Column(name = "value")
    private Map<String, String> data;
}
