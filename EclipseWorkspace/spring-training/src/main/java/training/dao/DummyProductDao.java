package training.dao;

import java.util.List;

import training.entity.Product;

public class DummyProductDao implements ProductDao {

	@Override
	public int count() throws DaoException {
		return 1000;
	}

	@Override
	public void addNewProduct(Product product) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public Product getProduct(Integer productId) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public void updateProduct(Product product) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public void deleteProduct(Integer productId) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public List<Product> getAllProducts() throws DaoException {
		throw new DaoException("Method not implemented!");
	}

	@Override
	public List<Product> getProductsByPriceRange(Double min, Double max) throws DaoException {
		throw new DaoException("Method not implemented!");
	}

}
