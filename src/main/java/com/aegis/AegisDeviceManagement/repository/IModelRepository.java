package com.aegis.AegisDeviceManagement.repository;

import com.aegis.AegisDeviceManagement.domain.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IModelRepository extends IBaseRepository<Model, UUID> {

}
