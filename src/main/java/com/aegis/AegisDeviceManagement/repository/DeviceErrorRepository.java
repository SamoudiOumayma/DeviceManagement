package com.aegis.AegisDeviceManagement.repository;

import com.aegis.AegisDeviceManagement.domain.DeviceError;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeviceErrorRepository extends JpaRepository<DeviceError, UUID> {
}
