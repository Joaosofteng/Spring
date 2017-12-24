package br.com.softincloud.crmapi.services.product;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.softincloud.crmapi.domain.product.Category;
import br.com.softincloud.crmapi.repositories.product.CategoryRepository;

@Service
public class CategoryService {
	
	private CategoryRepository repo;
	
	public CategoryService(CategoryRepository repo) {
		this.repo = repo;
	}

	public Category findById(Long id) {
		Category obj = this.repo.findOne(id);
		return obj; 
	}
	
	public List<Category> findByName(String name) {
		if (name == null) {
			name = "%";
		}
		List<Category> list = this.repo.findByNameContaining(name);		
		
		return list;
	}

}
