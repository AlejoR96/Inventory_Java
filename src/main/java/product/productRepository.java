package product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//clase de interface 
@Repository
public interface productRepository extends JpaRepository<Product, Integer> {
	//No va nigun codigo y todo lo hereda desde el repositorio//
}
