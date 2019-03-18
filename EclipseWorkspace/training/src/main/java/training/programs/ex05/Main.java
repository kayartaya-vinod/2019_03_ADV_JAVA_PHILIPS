package training.programs.ex05;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import training.entity.Category;
import training.entity.Product;
import training.utils.HibernateUtil;

public class Main {

	private static Session session;

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();

		// printAllCategories();
		// printProductsByPriceRange(50.0, 200.0);
		printCategorywiseProductSummary();

		session.close();
		factory.close();
	}

	static void printCategorywiseProductSummary() {
		String hql = "select p.category.categoryName, count(p), avg(p.unitPrice) "
				+ "from Product p group by p.category.categoryName";
		Query<Object[]> qry = session.createQuery(hql, Object[].class);
		List<Object[]> list = qry.getResultList();
		
		for(Object[] data: list) {
			System.out.printf("%-30s %5d %10.2f\n", data[0], data[1], data[2]);
		}
	}

	static void printProductsByPriceRange(double min, double max) {
		String hql = "from Product where unitPrice between :MIN and :MAX order by unitPrice desc";
		Query<Product> qry = session.createQuery(hql, Product.class);
		qry.setParameter("MIN", min);
		qry.setParameter("MAX", max);
		List<Product> list = qry.getResultList();
		for (Product p : list) {
			System.out.println(p.getProductName() + " --> $" + p.getUnitPrice());
		}
	}

	static void printAllCategories() {
		String hql = "from Category";
		Query<Category> qry = session.createQuery(hql, Category.class);
		List<Category> list = qry.list();
		for (Category c : list) {
			System.out.println(c.getCategoryName());
		}
	}

}
