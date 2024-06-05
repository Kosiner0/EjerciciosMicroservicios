package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.curso.model")
@EnableJpaRepositories(basePackages = "com.curso.dao")
@SpringBootApplication(scanBasePackages= {"com.curso.services.cliente","com.curso.services.vehiculo","com.curso.controller"})
public class VehiculosClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(VehiculosClientesApplication.class, args);
	}

}
