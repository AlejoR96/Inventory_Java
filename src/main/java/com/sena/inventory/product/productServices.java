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
		return productRepository.findBystateTrue();
	}
	
	///VALIDACION PARA EL DELETE 
	public boolean validateDelete(int id){
		boolean idProduct = productRepository.existsById(id);
		
		if (!idProduct) {
			
			throw new IllegalStateException("Error el id "+ id +" del producto no existe.");
		} 
		productRepository.deleteById(id);
		return idProduct;	
	}
	
	///METODO DEL DELETE PARA OBTENER O MOSTRAR QUE EL PRODUCTO NO EXISTE 
	public Optional<Product> ObtenerPorId(int id){
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (!optionalProduct.isPresent()) {
			 throw new IllegalStateException("El producto no existe");
		}
		return optionalProduct;
	}

	//METODO PARA MOSTRAR Y GUARDAR LOS DATOS DEL PRODUCT
	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}
	
	public Product updateProduct (Product product) {
		
		return productRepository.save(product);
	}
	

	public List<Product> findGreaterthan(double price) {
		
		return productRepository.findByPriceGreaterThan(price);
	}

	public List<Product> findByBrand(Integer brand) {
		// TODO Auto-generated method stub
       return productRepository.findByBrand(brand);
	}



	


	


	
	

}
	 
	
	

