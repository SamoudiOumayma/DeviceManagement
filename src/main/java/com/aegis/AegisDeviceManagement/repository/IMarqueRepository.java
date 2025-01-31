package com.aegis.AegisDeviceManagement.repository;

import com.aegis.AegisDeviceManagement.domain.Marque;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IMarqueRepository extends IBaseRepository<Marque, UUID> {

}
