package com.aegis.AegisDeviceManagement.repository;

import com.aegis.AegisDeviceManagement.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeviceRepository extends JpaRepository<Device, UUID> {
}
