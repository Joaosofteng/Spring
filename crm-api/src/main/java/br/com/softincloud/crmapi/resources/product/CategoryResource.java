package br.com.softincloud.crmapi.resources.product;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.softincloud.crmapi.domain.product.Category;
import br.com.softincloud.crmapi.services.product.CategoryService;

@RestController
@RequestMapping("/categories")
public class CategoryResource {

	private CategoryService service;

	public CategoryResource(CategoryService service) {
		this.service = service;
	}

	@GetMapping
	public List<Category> findByName(String name) {
		List<Category> list = this.service.findByName(name);
		
		return list;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findById(@PathVariable Long id) {
		Category obj = this.service.findById(id);		
		return ResponseEntity.ok().body(obj);
	} 

}
