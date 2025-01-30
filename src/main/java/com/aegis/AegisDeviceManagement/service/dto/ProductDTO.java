package com.aegis.AegisDeviceManagement.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;
import java.util.UUID;

@Data
public class ProductDTO implements Serializable {

    private UUID id;
    private String name;
    private UUID originalId;
    private Map<String, String> data;
}
