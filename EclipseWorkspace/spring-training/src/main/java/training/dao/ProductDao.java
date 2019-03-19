package training.dao;

import java.util.List;

import training.entity.Product;

public interface ProductDao {
	// CRUD operations
	public void addNewProduct(Product product) throws DaoException;

	public Product getProduct(Integer productId) throws DaoException;

	public void updateProduct(Product product) throws DaoException;

	public void deleteProduct(Integer productId) throws DaoException;

	// Queries
	public List<Product> getAllProducts() throws DaoException;

	public List<Product> getProductsByPriceRange(Double min, Double max) throws DaoException;

	public int count() throws DaoException;
}


