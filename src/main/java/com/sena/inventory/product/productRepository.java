package com.sena.inventory.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//clase de interface 
@Repository
public interface productRepository extends JpaRepository<Product, Integer> {

	List<Product> findBystateTrue();

	List<Product> findByPriceGreaterThan(double price);

	List<Product> findByBrand(Integer brand);
	
}
