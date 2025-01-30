package com.aegis.AegisDeviceManagement.repository;

import com.aegis.AegisDeviceManagement.domain.DeviceTemplateProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeviceTemplateProductRepository extends JpaRepository<DeviceTemplateProduct, UUID> {
}
