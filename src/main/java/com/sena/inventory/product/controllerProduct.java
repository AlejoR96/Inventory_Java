package com.sena.inventory.product;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Validated
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
    public Product add(@Valid @RequestBody Product product) {
    	
    	return this.productServices.createProduct(product);
    }
    
	
    @PutMapping
    public Product UpdateProduct(@Valid @RequestBody Product product){
    	 
    	if(product.getId() == null){
             throw new IllegalStateException("falta el id!");
         }
         return productServices.updateProduct(product);
    	
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class )
    public Map<String,String> ManejoExcepcionValidacion(MethodArgumentNotValidException exception){
    Map<String,String> errores = new HashMap<>();
    exception.getBindingResult().getAllErrors().forEach((error)->{
    	String NombreCampo = ((FieldError) error).getField();
    	String MensajeError = error.getDefaultMessage();
    	errores.put(NombreCampo, MensajeError);
	
    });
    
    return errores;
    }
    
	
	
	//localhost:8080/api/products/id=2
	@DeleteMapping(path = "/{id}")
	@ResponseBody
	public Optional<Product> Delete(@PathVariable int id) {
		
		Optional<Product> miProducto = productServices.ObtenerPorId(id);
		productServices.validateDelete(id);
		
		return miProducto;
		
	}
	
	
	@GetMapping(path = "/price/{precio}")
	public List<Product> getGreaterThan(@PathVariable double price){
		return productServices.findGreaterthan(price);
		
	}
	
	@GetMapping(path = "/brand/{brand}")
	public List<Product> getBybrand(@PathVariable Integer brand){
		return productServices.findByBrand(brand);
		
	}
	
	
	
	
}
