package br.com.softincloud.crmapi.repositories.product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.softincloud.crmapi.domain.product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	Product findByGtinContaining(String gtin);
	List<Product> findByNameContaining(String name);
	

}
