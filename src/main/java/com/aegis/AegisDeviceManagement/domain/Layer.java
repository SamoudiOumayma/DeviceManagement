package com.aegis.AegisDeviceManagement.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Layer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "page_id", nullable = false)
    private Page page;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String condition;

    @Column(columnDefinition = "TEXT")
    private String elements;

}
