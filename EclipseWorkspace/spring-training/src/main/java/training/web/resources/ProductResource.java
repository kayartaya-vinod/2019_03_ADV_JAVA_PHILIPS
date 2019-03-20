package training.web.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import training.dao.DaoException;
import training.dao.ProductDao;
import training.entity.Product;

@CrossOrigin(origins = "*", allowedHeaders = { "Content-Type", "Accept" }, 
	methods = { RequestMethod.GET, RequestMethod.POST })
@RestController
@RequestMapping("/api/products")
public class ProductResource {

	@Autowired
	@Qualifier("htDao")
	private ProductDao dao;

	@RequestMapping(method = RequestMethod.GET, produces = { "application/json" })
	public List<Product> getAll() throws DaoException {
		return dao.getAllProducts();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
	public Product getById(@PathVariable Integer id) throws DaoException {
		return dao.getProduct(id);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { "application/json", "application/xml" }, produces = {
			"application/json", "application/xml" })
	public ResponseEntity<Product> addNew(@RequestBody Product product) throws DaoException {

		dao.addNewProduct(product);
		return ResponseEntity.ok(product);
	}
}
