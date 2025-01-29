package com.aegis.AegisDeviceManagement.repository;

import com.aegis.AegisDeviceManagement.domain.MT;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MTRepository extends JpaRepository<MT, UUID> {
}
