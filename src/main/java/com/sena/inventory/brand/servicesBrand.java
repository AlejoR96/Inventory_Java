package com.sena.inventory.brand;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class servicesBrand {
	
	private final  brandRepository brandRepository;
	
	@Autowired
	public servicesBrand(brandRepository brandRepository ) {
		this.brandRepository = brandRepository;
	}
	//-------------------------------------------------------///
	
	//Metodo o servicio generado por GetMapping
	public List<Brand> getBrands() {
		
		return brandRepository.findAll();
	}
	
	//-------------------------------------------------------///
	
   //Metodo o servicio generado por PostMapping
	public Brand createBrand(Brand brand) {
		
		return brandRepository.save(brand);
	}
	
	//-------------------------------------------------------///

	//Metodo o servicio generado por PutMapping
	public Brand updateBrand(Brand brand) {
		// TODO Auto-generated method stub
		return brandRepository.save(brand);
	}
	
	//-------------------------------------------------------///

	//Metodo o servicio generado por DeleteMapping
	public Optional<Brand> getByid(int id) {
		
		   Optional<Brand> optionalGetbyId = brandRepository.findById(id);
		   if (!optionalGetbyId.isPresent()) {
			   throw new IllegalStateException("La marca no existe");
		      }
		      return optionalGetbyId;	   	
	}
	
	//Metodo o servicio para validar que id brand no existe
	public boolean validateByid(int id){
		boolean idBrand = brandRepository.existsById(id);
		if (!idBrand) {
			
			throw new IllegalStateException("Error el codigo"+ id +" de la marca no existe.");
		}
		brandRepository.deleteById(id);
		return idBrand;
	}
	
	//-------------------------------------------------------///
	
	
    
	
	
	
	
	

}
