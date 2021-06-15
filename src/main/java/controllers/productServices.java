package controllers;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class productServices {
	public List<Product> getProducts(){
		return List.of(
				new Product(
						1,
						"Teclado",
						10000.00,
						50000.00,
						1
						)
				
				);
		
	}

}
