package training.programs.ex03;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import training.entity.Category;
import training.utils.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		try(
			SessionFactory factory = HibernateUtil.getSessionFactory();
			Session session = factory.openSession();
		){
			Transaction tx = session.beginTransaction();
			Category c1 = session.get(Category.class, 1);
			// changes to c1's members will be updated to the db
			// during the tx.commit(), conditionally
			c1.setCategoryName("Soft beverages");
			tx.commit();
			// While tx.commit(),
			// all 'dirty' objects result in SQL UPDATE statements
			// all 'new' objects result in SQL INSERT statements
			// all 'removed' objects result in SQL DELETE statements
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
