package product;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
}
