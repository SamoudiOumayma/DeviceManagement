package com.aegis.AegisDeviceManagement.repository;

import com.aegis.AegisDeviceManagement.domain.Error;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ErrorRepository extends JpaRepository<Error, UUID> {

}
