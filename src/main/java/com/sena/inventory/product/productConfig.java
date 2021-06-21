package com.sena.inventory.product;

import org.springframework.context.annotation.Configuration;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@Configuration
public class productConfig {
	@Bean
	CommandLineRunner commandLineRunner(productRepository repository){
        return args -> {
            Product teclado = new Product("Teclado",50000.00,20000.00,1);
            Product mouse = new Product("Raton",20000.00,10000.00,1);
            Product pantalla = new Product("Pantalla",30000.00,20000.00,3);
            repository.saveAll(List.of(teclado,mouse,pantalla));
           
        };
	};

}
