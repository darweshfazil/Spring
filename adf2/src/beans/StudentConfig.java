package beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import database.Database;
import model.Students;

@Configuration
public class StudentConfig {
	
	// define bean for Students
	@Bean
	public Students student() {
		return new Students();
	}
	
	// define bean for 
	@Bean
	public Database database() {
		return new Database();
	}
}
