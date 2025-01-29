package com.aegis.AegisDeviceManagement.service.dto;

import lombok.Data;
import java.util.Map;
import java.util.UUID;

@Data
public class ProductDTO {

    private UUID productId;
    private String name;
    private UUID originalId;
    private Map<String, String> data;
}
