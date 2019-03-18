package training.programs.ex01;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import training.entity.Category;
import training.utils.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Category c1 = new Category();
		c1.setCategoryName("Beverages");
		c1.setDescription("Soft drinks, coffee, tea etc");
		
		try {
			session.save(c1);
			tx.commit();			// actual INSERT is sent to the DB here.
		} catch (Exception e) {
			tx.rollback();
		}
		
		session.close();
		factory.close();
		
	}

}
