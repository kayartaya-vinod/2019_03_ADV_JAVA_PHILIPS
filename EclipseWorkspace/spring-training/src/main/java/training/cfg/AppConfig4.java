package training.cfg;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import training.entity.Category;
import training.entity.Product;

@Configuration
@ComponentScan(basePackages = { "training.dao" })
public class AppConfig4 {

	@Bean
	public LocalSessionFactoryBean factory() {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();

		Properties props = new Properties();
		props.setProperty("hibernate.connection.driver", "org.h2.Driver");
		props.setProperty("hibernate.connection.url", "jdbc:h2:tcp://localhost/~/2019_03_ADV_JAVA_PHILIPS");
		props.setProperty("hibernate.connection.username", "sa");
		props.setProperty("hibernate.connection.password", "");
		props.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		props.setProperty("hibernate.show_sql", "false");
		props.setProperty("hibernate.format_sql", "true");
		props.setProperty("hibernate.hbm2ddl.auto", "update");

		sf.setHibernateProperties(props);
		sf.setAnnotatedClasses(Product.class, Category.class);

		return sf;
	}

	@Bean
	public HibernateTemplate template(SessionFactory factory) {
		return new HibernateTemplate(factory);
	}
}
