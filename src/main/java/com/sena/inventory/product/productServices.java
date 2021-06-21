package com.sena.inventory.product;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

@Service
public class productServices {
	
	private final productRepository productRepository;
	
	@Autowired
	public productServices(productRepository productRepository) {
		
		this.productRepository = productRepository;
	}
	
	// Aqui va la logica de negocio del proyecto//

	public List<Product> getProducts(){
		return productRepository.findAll();
	}
	
	public boolean validateDelete(int id){
		boolean idProduct = productRepository.existsById(id);
		
		if (!idProduct) {
			
			throw new IllegalStateException("Error el id "+ id +" del producto no existe.");
		} 
		productRepository.deleteById(id);
		return idProduct;	
	}
	
	public Optional<Product> ObtenerPorId(int id){
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (!optionalProduct.isPresent()) {
			 throw new IllegalStateException("El producto no existe");
		}
		return optionalProduct;
	}

	// falta crear el services
	
	

}
	 
	
	

