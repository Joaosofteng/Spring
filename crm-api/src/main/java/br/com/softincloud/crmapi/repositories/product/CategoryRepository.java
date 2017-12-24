package br.com.softincloud.crmapi.repositories.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.softincloud.crmapi.domain.product.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
	List<Category> findByNameContaining(String name);

}
