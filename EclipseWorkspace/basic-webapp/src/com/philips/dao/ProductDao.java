package com.philips.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import training.entity.Product;
import training.utils.HibernateUtil;

public class ProductDao {

	// CRUD operations

	// QUERIES
	public List<Product> getAllProducts() {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Query<Product> qry = session.createQuery("from Product", Product.class);
		List<Product> list = qry.getResultList();
		session.close();
		return list;
	}

	public List<Product> getProductsByPriceRange(double min, double max) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Query<Product> qry = session.createQuery(
				"from Product where unitPrice between :MIN and :MAX order by unitPrice desc", 
				Product.class);
		qry.setParameter("MIN", min);
		qry.setParameter("MAX", max);

		List<Product> list = qry.getResultList();
		session.close();
		return list;
	}

}
