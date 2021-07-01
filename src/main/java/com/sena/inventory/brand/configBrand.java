package com.sena.inventory.brand;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import org.springframework.boot.CommandLineRunner;

@Configuration
public class configBrand {

	@Bean
	CommandLineRunner commandLineRunner (brandRepository repository, brandRepository brandRepository){
		return args ->{
			
			Brand lenovo = new Brand("lenovo");
		    repository.saveAll(List.of(lenovo));

		};

	};
	
}
