package training.programs.ex03;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import training.cfg.AppConfig5;
import training.dao.DaoException;
import training.dao.ProductDao;
import training.entity.Product;

public class Main {

	public static void main(String[] args) throws DaoException {
		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig5.class);

		ProductDao dao = ctx.getBean("htDao", ProductDao.class);
		System.out.println("dao is an instanceof " + dao.getClass());


		Product p1 = dao.getProduct(1);
		try {
			dao.updateProduct(p1);
		} catch (DaoException e) {
			System.out.println("Couldn't update the product");
		}
		
		int c = dao.count();
		System.out.println("there are " + c + " products");

		double min = 50, max = 200;
		c = dao.getProductsByPriceRange(min, max).size();
		System.out.println("there are " + c + " products between $" + min +" and $" + max);
		
		

		ctx.close();
	}

}



