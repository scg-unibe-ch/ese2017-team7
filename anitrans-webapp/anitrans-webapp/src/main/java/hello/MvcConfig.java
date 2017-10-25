package hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

  @Bean(name = "dataSource")
  	public DriverManagerDataSource dataSource() {
	  DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
	  driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
	  driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/ese_team7");
	  driverManagerDataSource.setUsername("root");
	  driverManagerDataSource.setPassword("");
	  return driverManagerDataSource;
  }
 
  @Bean
  public InternalResourceViewResolver viewResolver() {
	  InternalResourceViewResolver resolver = new InternalResourceViewResolver();
	  resolver.setPrefix("/WEB-INF/jsp/");
	  resolver.setSuffix(".jsp");
	  return resolver;
  }   
}