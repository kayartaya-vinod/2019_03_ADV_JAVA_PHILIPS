package training.cfg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;

import training.dao.JdbcProductDao;
import training.dao.ProductDao;

public class AppConfig2 {

	@Bean(autowire = Autowire.BY_TYPE)
	public ProductDao jdbcDao() {
		return new JdbcProductDao();
	}

	@Bean
	public Connection conn() throws ClassNotFoundException, SQLException {
		String driver = "org.h2.Driver";
		String url = "jdbc:h2:tcp://localhost/~/2019_03_ADV_JAVA_PHILIPS";
		String username = "sa", password = "";
		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}
}
