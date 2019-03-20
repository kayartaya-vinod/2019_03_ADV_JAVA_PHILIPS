package training.cfg;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import training.entity.Category;
import training.entity.Product;


@Configuration
@ComponentScan(basePackages = { "training.dao", "training.aop" })
public class AppConfig5 {

	// DataSource --> Connection pool
	@Bean
	public DataSource ds() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("org.h2.Driver");
		bds.setUrl("jdbc:h2:tcp://localhost/~/2019_03_ADV_JAVA_PHILIPS");
		bds.setUsername("sa");
		bds.setPassword("");
		
		bds.setMaxTotal(100);
		bds.setInitialSize(10);
		bds.setMaxIdle(50);
		
		return bds;
	}
	
	@Bean
	public LocalSessionFactoryBean factory(DataSource ds) {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(ds);
		
		Properties props = new Properties();
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
