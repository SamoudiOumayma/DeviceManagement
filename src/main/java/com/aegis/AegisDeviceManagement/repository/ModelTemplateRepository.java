package com.aegis.AegisDeviceManagement.repository;

import com.aegis.AegisDeviceManagement.domain.ModelTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModelTemplateRepository extends JpaRepository<ModelTemplate, UUID> {

}
