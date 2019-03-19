package training.cfg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import training.dao.DummyProductDao;
import training.dao.JdbcProductDao;
import training.dao.ProductDao;

@Configuration
public class AppConfig1 {

	// this class defines bean configurations

	@Bean
	public Connection conn() throws ClassNotFoundException, SQLException {
		String driver = "org.h2.Driver";
		String url = "jdbc:h2:tcp://localhost/~/2019_03_ADV_JAVA_PHILIPS";
		String username = "sa", password = "";
		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}

	@Bean(name = { "jdbcDao", "jd" })
	public ProductDao jdbcDao(Connection conn) { // dependency injection
		return new JdbcProductDao(conn); // manual wiring
	}

	@Bean
	public ProductDao dummyDao() {
		return new DummyProductDao();
	}

}
