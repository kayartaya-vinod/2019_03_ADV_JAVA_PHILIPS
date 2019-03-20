package com.philips.springboottraining;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	@Query("from Product where unitPrice between ?1 and ?2")
	public Iterable<Product> getProductsByPriceRange(Double min, Double max);
}
