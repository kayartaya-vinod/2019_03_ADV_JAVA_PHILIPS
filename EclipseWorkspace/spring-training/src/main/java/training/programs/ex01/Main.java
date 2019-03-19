package training.programs.ex01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import training.cfg.AppConfig3;
import training.dao.DaoException;
import training.dao.ProductDao;

public class Main {

	public static void main(String[] args) throws DaoException {
		// Spring container is represented by an object of 
		// class that implements ApplicationContext
		// For annotation based configurations, use the AnnotationConfigApplicationContext
	
		AnnotationConfigApplicationContext context;
		context = new AnnotationConfigApplicationContext(AppConfig3.class);
		
		ProductDao dao = context.getBean("jdbcDao", ProductDao.class);
		int pc = dao.count();
		System.out.println("There are " + pc + " products.");
		
		context.close();
	}
	
}
