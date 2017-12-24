package br.com.softincloud.crmapi.services.product;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.softincloud.crmapi.domain.product.Product;
import br.com.softincloud.crmapi.repositories.product.ProductRepository;

@Service
public class ProductService {

	private ProductRepository repo;

	public ProductService(ProductRepository repo) {
		this.repo = repo;
	}
	
	public Product findById(Long id) {
		Product obj = this.repo.findOne(id);
		return obj;
	}
	
	public Product findByGtin(String gtin) {
		Product obj = this.repo.findByGtinContaining(gtin);
		return obj;
	}
	
	public List<Product> findbyName(String name) {
		List<Product> list = this.repo.findByNameContaining(name);		
		return list;
	}

}
