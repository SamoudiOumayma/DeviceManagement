package com.aegis.AegisDeviceManagement.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModelTemplate implements Serializable {

    @EmbeddedId
    private MTId id;

    @ManyToOne
    @MapsId("modelId")
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @ManyToOne
    @MapsId("templateId")
    @JoinColumn(name = "template_id", nullable = false)
    private Template template;
}
