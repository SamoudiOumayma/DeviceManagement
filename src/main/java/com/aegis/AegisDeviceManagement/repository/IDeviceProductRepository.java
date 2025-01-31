package com.aegis.AegisDeviceManagement.repository;

import com.aegis.AegisDeviceManagement.domain.DeviceProduct;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IDeviceProductRepository extends IBaseRepository< DeviceProduct, UUID> {
}
