package com.aegis.AegisDeviceManagement.repository;

import com.aegis.AegisDeviceManagement.domain.Layer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LayerRepository extends JpaRepository < Layer, UUID > {
}
