package com.sena.inventory.brand;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface brandRepository extends JpaRepository<Brand,Integer>  {
	
	

}
