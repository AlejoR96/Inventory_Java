package product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class productServices {
	
	private final productRepository productRepository;
	
	@Autowired
	public productServices(productRepository productRepository) {
		
		this.productRepository = productRepository;
		
	}

	public List<Product> getProducts(){
		return productRepository.findAll();
	}

}
