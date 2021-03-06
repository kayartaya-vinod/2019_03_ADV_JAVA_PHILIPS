package training.programs.ex02;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import training.entity.Category;
import training.entity.Product;
import training.utils.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		// c1 is called as "persistent" entity
		Category c1 = session.get(Category.class, 1);
				
		System.out.println("Name = " + c1.getCategoryName());
		System.out.println("Desc = " + c1.getDescription());
		
		
		System.out.println("Products in this category: ");
		for(Product p: c1.getProducts()) {
			System.out.println(p.getProductName() + " --> $" + p.getUnitPrice());
		}

		
		session.close();
		factory.close();

		// at this time, c1 is called "detached" entity

	}
}
