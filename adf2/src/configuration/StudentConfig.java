package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import model.Students;
import operations.Database;
import operations.StudentOperations;
import operations.GetRollNo;
import operations.Person;
import operations.StudentClass;

@Configuration
public class StudentConfig {
	
	public Students student;
	
	// define bean for Operations
	@Bean
	public StudentOperations getRollNo() {
		return new GetRollNo();
	}
	
	@Bean
	public Person studentOperation() {
		return new StudentClass(getRollNo());
	}
	
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
