package com.sena.inventory.product;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/products")
public class controllerProduct {
	
	private final productServices productServices;
	@Autowired
	public controllerProduct(productServices productServices) {
		
		this.productServices = productServices;
	}
	@GetMapping
	public List<Product> getProducts(){
		return this.productServices.getProducts();
	}
	
	// Para crear datos y guardarlos en la base de datos 
    @PostMapping
    public Product add(@RequestBody Product product) {
    	
    	return this.productServices.createProduct(product);
    }
	
	
	
	//localhost:8080/api/products/id=2
	@DeleteMapping(path = "/{id}")
	@ResponseBody
	public Optional<Product> Delete(@PathVariable int id) {
		
		Optional<Product> miProducto = productServices.ObtenerPorId(id);
		productServices.validateDelete(id);
		
		return miProducto;
		
	}
	
}
