package training.cfg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "training.dao" })
public class AppConfig3 {

	@Bean
	public Connection conn() throws ClassNotFoundException, SQLException {
		String driver = "org.h2.Driver";
		String url = "jdbc:h2:tcp://localhost/~/2019_03_ADV_JAVA_PHILIPS";
		String username = "sa", password = "";
		Class.forName(driver);
		return DriverManager.getConnection(url, username, password);
	}
}
