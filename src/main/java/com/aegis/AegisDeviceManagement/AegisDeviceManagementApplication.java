package com.aegis.AegisDeviceManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
public class AegisDeviceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(AegisDeviceManagementApplication.class, args);
	}

}
