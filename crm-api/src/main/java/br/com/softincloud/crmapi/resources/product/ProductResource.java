package br.com.softincloud.crmapi.resources.product;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softincloud.crmapi.domain.product.Product;
import br.com.softincloud.crmapi.services.product.ProductService;

@RestController
@RequestMapping("/products")
public class ProductResource {

	private ProductService productService;

	public ProductResource(ProductService productService) {
		this.productService = productService;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> findById(@PathVariable Long id) {
		Product obj = this.productService.findById(id);		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	public ResponseEntity<List<Product>> findByName(String name) {
		if (name == null) {
			name = "%";
		}
		
		List<Product> list = this.productService.findbyName(name);		
		return ResponseEntity.ok().body(list);
	}

}
