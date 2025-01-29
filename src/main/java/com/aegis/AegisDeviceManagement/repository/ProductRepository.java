package com.aegis.AegisDeviceManagement.repository;

import com.aegis.AegisDeviceManagement.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository< Product, UUID > {
}
