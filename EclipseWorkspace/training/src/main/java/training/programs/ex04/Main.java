package training.programs.ex04;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import training.entity.Product;
import training.utils.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		try(
				SessionFactory factory = HibernateUtil.getSessionFactory();
				Session session = factory.openSession();
			){
			
			Product p1 = session.get(Product.class, 1);
			System.out.println("Product name = " + p1.getProductName());
			System.out.println("Category     = " + p1.getCategory().getCategoryName());
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

}
