package training.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import training.entity.Product;

@Component("htDao")
@SuppressWarnings({ "unchecked", "deprecation" })
public class HibernateTemplateProductDao implements ProductDao {

	@Autowired
	private HibernateTemplate template;

	@Override
	public void addNewProduct(Product product) throws DaoException {
		template.persist(product);
	}

	@Override
	public Product getProduct(Integer productId) throws DaoException {
		return template.get(Product.class, productId);
	}

	@Override
	public void updateProduct(Product product) throws DaoException {
		template.merge(product);
	}

	@Override
	public void deleteProduct(Integer productId) throws DaoException {
		Product p = getProduct(productId);
		if (p == null)
			throw new DaoException("Invalid id for deletion");
		template.delete(p);
	}

	@Override
	public List<Product> getAllProducts() throws DaoException {
		return (List<Product>) template.find("from Product");
	}

	@Override
	public List<Product> getProductsByPriceRange(Double min, Double max) throws DaoException {
		DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
		dc.add(Restrictions.ge("unitPrice", min));
		dc.add(Restrictions.le("unitPrice", max));

		return (List<Product>) template.findByCriteria(dc);
	}

	@Override
	public int count() throws DaoException {
		DetachedCriteria dc = DetachedCriteria.forClass(Product.class);
		ProjectionList plist = Projections.projectionList().add(Projections.rowCount());

		dc.setProjection(plist);
		List<Object> list = (List<Object>) template.findByCriteria(dc);
		return new Integer(list.get(0).toString());
	}

}
