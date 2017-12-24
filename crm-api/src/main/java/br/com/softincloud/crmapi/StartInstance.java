package br.com.softincloud.crmapi;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.com.softincloud.crmapi.domain.product.Category;
import br.com.softincloud.crmapi.domain.product.Product;
import br.com.softincloud.crmapi.repositories.product.CategoryRepository;
import br.com.softincloud.crmapi.repositories.product.ProductRepository;

@Component
public class StartInstance implements CommandLineRunner {

	private CategoryRepository categoryRepository;
	private ProductRepository produtoRepository;

	public StartInstance(CategoryRepository categoryRepository, ProductRepository produtoRepository) {
		this.categoryRepository = categoryRepository;
		this.produtoRepository = produtoRepository;
	}

	@Override
	public void run(String... arg0) throws Exception {

		// Category
		Category c1 = new Category(null, "Informática");
		Category c2 = new Category(null, "Escritório");
		Category c3 = new Category(null, "Acessórios");

		// drop all category
		this.categoryRepository.deleteAll();
		// save category
		this.categoryRepository.save(Arrays.asList(c1, c2, c3));

		Product p1 = new Product(null, "00121", "Computador", BigDecimal.valueOf(1500), c1);
		Product p2 = new Product(null, "11215", "Impressora", BigDecimal.valueOf(450), c1);
		Product p3 = new Product(null, "54532", "Mesa Escritório", BigDecimal.valueOf(620), c2);
		// Drop all Product
		this.produtoRepository.deleteAll();
		// Save Product
		this.produtoRepository.save(Arrays.asList(p1, p2, p3));
	}

}
