package training.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import training.entity.Product;

@Transactional(readOnly = true, rollbackFor = { DaoException.class })
public interface ProductDao {
	// CRUD operations

	@Transactional(readOnly = false)
	public void addNewProduct(Product product) throws DaoException;

	public Product getProduct(Integer productId) throws DaoException;

	@Transactional(readOnly = false)
	public void updateProduct(Product product) throws DaoException;

	@Transactional(readOnly = false)
	public void deleteProduct(Integer productId) throws DaoException;

	// Queries
	public List<Product> getAllProducts() throws DaoException;

	public List<Product> getProductsByPriceRange(Double min, Double max) throws DaoException;

	public int count() throws DaoException;
}
