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
		
		List<Product> list = dao.getProductsByPriceRange(10.0, 20.0);
		for(Product p: list) {
			System.out.println(p.getProductName() + " --> $" + p.getUnitPrice());
		}
		
		ctx.close();
	}

}
