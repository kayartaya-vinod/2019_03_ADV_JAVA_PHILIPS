package training.programs.ex02;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import training.cfg.AppConfig4;
import training.dao.DaoException;
import training.dao.ProductDao;
import training.entity.Product;

public class Main {

	public static void main(String[] args) throws DaoException {
		AnnotationConfigApplicationContext ctx;
		ctx = new AnnotationConfigApplicationContext(AppConfig4.class);

		ProductDao dao = ctx.getBean("htDao", ProductDao.class);
		System.out.println("dao is an insrtanceof " + dao.getClass());
		
		Product p1 = dao.getProduct(1);
		System.out.println("p1.price = $" + p1.getUnitPrice());
		p1.setUnitPrice(p1.getUnitPrice() + 1);
		
		dao.updateProduct(p1);
		
		p1 = dao.getProduct(1);
		System.out.println("After updating, p1.price = $" + p1.getUnitPrice());
		
		double min = 50.0, max = 200.0;
		List<Product> list = dao.getProductsByPriceRange(min, max);
		System.out.println("There are " + list.size() 
			+ " products priced between " + min + " and " + max);

		ctx.close();
	}

}
