package training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import training.entity.Product;

@Component("jdbcDao")
public class JdbcProductDao implements ProductDao {

	@Autowired(required = false)
	private Connection connection; // dependency

	public JdbcProductDao() {
	}

	public JdbcProductDao(Connection connection) {
		this.connection = connection;
	}

	// writable property / mutator called "connection"
	public void setConnection(Connection connection) {
		System.out.println("setConnection() called");
		this.connection = connection;
	}

	@Override
	public int count() throws DaoException {
		String sql = "select count(*) from products";

		try (PreparedStatement stmt = connection.prepareStatement(sql); ResultSet rs = stmt.executeQuery();) {
			rs.next();
			return rs.getInt(1);
		} catch (Exception ex) {
			throw new DaoException(ex);
		}
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
