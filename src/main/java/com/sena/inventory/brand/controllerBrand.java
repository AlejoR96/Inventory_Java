package com.sena.inventory.brand;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping(path = "api/brands")
public class controllerBrand {
	
	private final servicesBrand servicesBrand;
	@Autowired
	public controllerBrand(servicesBrand servicesBrand ) {
		this.servicesBrand = servicesBrand;
	}
	
	//Mostrar todos los datos  
	@GetMapping
	public List<Brand> getBrand(){
		return this.servicesBrand.getBrands();
	}
	
	//Crear Datos nuevos 
	@PostMapping
	public Brand add(@RequestBody Brand brand) {
		return this.servicesBrand.createBrand(brand);
	}
	
	//Actualizar Datos ingresados
	@PutMapping
	public Brand UpdateBrand(@RequestBody Brand brand) {
		return servicesBrand.updateBrand(brand);
	}
	
	//Borrar Datos 
	@DeleteMapping(path = "/{id}")
	@ResponseBody
	public Optional<Brand> DeleteBrand(@PathVariable int id){
		Optional <Brand> DeletedBrand = servicesBrand.getByid(id);
		servicesBrand.validateByid(id);
		return DeletedBrand;
	}
	
	
	

}
