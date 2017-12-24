package br.com.softincloud.crmapi;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.softincloud.crmapi.domain.product.Category;
import br.com.softincloud.crmapi.repositories.product.CategoryRepository;

@Component
public class StartInstance implements CommandLineRunner {
	
	private CategoryRepository categoryRepository;
	
	public StartInstance(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public void run(String... arg0) throws Exception {

		// Category
		Category c1 = new Category(null, "Informática");
		Category c2 = new Category(null, "Escritório");
		Category c3 = new Category(null, "Acessórios");		
		//drop all category
		this.categoryRepository.deleteAll();
		//save category		
		this.categoryRepository.save(Arrays.asList(c1, c2, c3));

	}

}

