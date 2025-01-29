package com.aegis.AegisDeviceManagement.repository;

import com.aegis.AegisDeviceManagement.domain.MarqueConfig;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MarqueConfigRepository extends JpaRepository < MarqueConfig, UUID > {
}
