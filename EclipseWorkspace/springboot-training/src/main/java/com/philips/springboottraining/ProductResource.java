package com.philips.springboottraining;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RequestMapping(path = "/api/products", produces = "application/json")
@RestController
public class ProductResource {

	@Autowired
	ProductRepository repo;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Iterable<Product>> getAll() {
		return ResponseEntity.ok(repo.findAll());
	}

	@RequestMapping(path = "/by-price", method = RequestMethod.GET)
	public ResponseEntity<Iterable<Product>> getByPriceRange(
			@RequestParam Double min,
			@RequestParam Double max
			) {
		return ResponseEntity.ok(repo.getProductsByPriceRange(min, max));
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> getOne(@PathVariable Integer id) {
		return ResponseEntity.ok(repo.findById(id).get());
	}

	@RequestMapping("/info")
	public ResponseEntity<Map<String, Object>> info() {
		Map<String, Object> data = new HashMap<>();
		data.put("author", "Vinod");
		data.put("email", "vinod@viod.co");

		return ResponseEntity.ok(data);
	}
}
