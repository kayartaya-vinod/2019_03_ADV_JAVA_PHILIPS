package training.utils;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import training.entity.Category;
import training.entity.Product;

public final class HibernateUtil {
	private HibernateUtil() {
	}

	// generally should be a singleton (for 2-level cache)
	private static SessionFactory factory;

	public static SessionFactory getSessionFactory() {

		if (factory == null) {

			// contains DB and ORM configuration
			Configuration cfg = new Configuration();
			
			Properties props = new Properties();
			props.setProperty("hibernate.connection.driver", "org.h2.Driver");
			props.setProperty("hibernate.connection.url", "jdbc:h2:tcp://localhost/~/2019_03_ADV_JAVA_PHILIPS");
			props.setProperty("hibernate.connection.username", "sa");
			props.setProperty("hibernate.connection.password", "");
			props.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			props.setProperty("hibernate.show_sql", "false");
			props.setProperty("hibernate.format_sql", "true");
			props.setProperty("hibernate.hbm2ddl.auto", "update");
			
			ServiceRegistry registry = new StandardServiceRegistryBuilder()
				.applySettings(props)
				.build();
			
			cfg.addAnnotatedClass(Category.class);
			cfg.addAnnotatedClass(Product.class);
			
			factory = cfg.buildSessionFactory(registry);
			
		}

		return factory;
	}
}
