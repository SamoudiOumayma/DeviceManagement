package com.aegis.AegisDeviceManagement.repository;

import com.aegis.AegisDeviceManagement.domain.DTP;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DTPRepository extends JpaRepository<DTP, UUID> {
}
