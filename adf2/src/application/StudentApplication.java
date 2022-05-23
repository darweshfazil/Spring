package application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import beans.StudentConfig;

import java.sql.SQLException;

import database.Database;
//import model.Academy;
//import model.Parents;
//import model.Payment;
import model.Students;

public class StudentApplication {

	public static void main(String[] args) throws SQLException {
		
		// read spring config file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
		
		// get the bean from spring container
		Students stud = (Students)context.getBean("student", "hi", 12, 'M', 124, 56,"9876543210","a@a.com","erode");
		//Database db = context.getBean("database", Database.class);
		
		// call a method on the bean
		System.out.println(stud.getName());
		//db.insertStudent(stud);
		
		// call method to get the daily fortune
//		System.out.println(theCoach.getDailyFortune());
		
		// call the method defined with external properties
//		System.out.println(theCoach.getRandomFortune());
		
		// close the context
		context.close();
		
//		Students stud = new Students("hi", 12, 'M', 124, 56,"9876543210","a@a.com","erode");
//		Parents parent = new Parents(4,"ram","seetha",56,45,"plumber","housemaker","9876543210","a@a.com","erode");
//		Academy academy = new Academy(4, "saratha", 99, "good", "java", 2022);
//		Payment payment = new Payment(4,"Raju","9876543211","IOB",10000,"10-05-2022",0,"NIL");
//		Database db = new Database();
//		db.deleteStudent(4);
//		db.insertParent(parent);
//		db.insertStudent(stud);
//		db.deleteStudent(1);
	}

}
