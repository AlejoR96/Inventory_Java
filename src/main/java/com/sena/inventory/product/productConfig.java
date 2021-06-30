package com.sena.inventory.product;

import org.springframework.context.annotation.Configuration;

import com.sena.inventory.brand.Brand;
import com.sena.inventory.brand.brandRepository;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Configuration
public class productConfig {
	@Bean
	CommandLineRunner commandLineRunner(productRepository repository, brandRepository brandRepository ){
        return args -> {
        	Brand logitech = new Brand ("logitect");
        	Brand genius = new Brand ("genius");
        	brandRepository.saveAll(List.of(logitech,genius));
        	Product teclado = new Product("Teclado",50000.00,20000.00,new Brand(1,""),true);
            Product mouse = new Product("Raton",20000.00,10000.00,new Brand(2,""),true);
            Product pantalla = new Product("Pantalla",30000.00,20000.00,new Brand(3,""),true);
            repository.saveAll(List.of(teclado,mouse,pantalla));
           
        };
	};

}
