package cities.chooser;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:application.properties")
public class Configurator {
	@Value("${app.datasource.driverClassName}")
	String driverClassName;
	@Value("${app.datasource.url}")
	String url;
	@Value("${app.datasource.username}")
	String username;
	@Value("${app.datasource.password}")
	String password;

	public DataSource dataSource() {
		return DataSourceBuilder
                .create()
                .username(username)
                .password(password)
                .url(url)
                .driverClassName(driverClassName)
                .build();
	}
}
