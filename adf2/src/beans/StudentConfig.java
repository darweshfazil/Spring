package beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import database.Database;
import model.Students;

@Configuration
public class StudentConfig {
	
	// define bean for Students
	@Bean
	public Students student(String name, int age, char gender, int height, int weight, String phone, String email, String address) {
		return new Students(name, age, gender, height, weight, phone, email, address);
	}
	
	// define bean for 
	@Bean
	public Database database() {
		return new Database();
	}
}
