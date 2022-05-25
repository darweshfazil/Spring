package application;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import configuration.StudentConfig;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import model.Academy;
import model.Parents;
import model.Payment;
import model.Students;
import operations.Database;
import operations.StudentClass;

public class StudentApplication {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException {
		
		// Initializing Scanner class
		Scanner sc = new Scanner(System.in);
		
		// read spring configuration file
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);
		
		// get the bean from spring container
		Database db = context.getBean("database", Database.class);
		StudentClass stud = context.getBean("studentOperation", StudentClass.class);
		
		int choice = 0;
		while(choice!=6) {
			System.out.print("\n----------STUDENT MANAGEMENT----------\n\n"
					+ "1) Create Records\n"
					+ "2) Update Records\n"
					+ "3) Display Records\n"
					+ "4) Delete Records\n"
					+ "5) Insert Records\n"
					+ "6) Exit\n"
					+ "\n"
					+ "Enter your choice: ");
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					System.out.print("\nEnter Student Name: ");
					String name = sc.next();
					System.out.print("Enter Student Age: ");
					int age = sc.nextInt();
					System.out.print("Enter Student's Class: ");
					String std = sc.next();
					System.out.print("Enter Student Section: ");
					char section = sc.next().charAt(0);
					System.out.print("Enter Student Gender: ");
					char gender = sc.next().charAt(0);
					System.out.print("Enter Student Height in cms: ");
					int height = sc.nextInt();
					System.out.print("Enter Student Weight in kgs: ");
					int weight = sc.nextInt();
					System.out.print("Enter Student's Email: ");
					String email = sc.next();
					System.out.print("Enter Student's Phone: ");
					String phone = sc.next();
					System.out.print("Enter Student's Address: ");
					String address = sc.next();
					Students student = new Students(name, age, std, section,gender, height, weight, phone, email, address);
					String regno = stud.getRollNo(student);
					Students student1 = new Students(regno, name, age, std, section,gender, height, weight, phone, email, address);
					db.insertStudent(student1);
					System.out.print("\nStudent Record Successfully created!\n"
							+ "\nGenerated Register Number: "+regno+"\n");
					
					
					System.out.print("\nEnter Parents' details");
					System.out.print("\nEnter Father Name: ");
					String fname = sc.next();
					System.out.print("Enter Father Age: ");
					int fage = sc.nextInt();
					System.out.print("Enter Father Occupation: ");
					String focc = sc.next();
					System.out.print("Enter Mother Name: ");
					String mname = sc.next();
					System.out.print("Enter Mother Age: ");
					int mage = sc.nextInt();
					System.out.print("Enter Mother Occupation: ");
					String mocc = sc.next();
					System.out.print("Enter Email id: ");
					email = sc.next();
					System.out.print("Enter Phone Number: ");
					phone = sc.next();
					System.out.print("Enter Permanent Address: ");
					address = sc.next();
					Parents parent = new Parents(regno,fname,mname,fage,mage,focc,mocc,phone, email,address);
					db.insertParent(parent);
					
					System.out.print("\nEnter Previous Academy details");
					System.out.print("\nEnter School Name: ");
					String school = sc.next();
					System.out.print("Enter Previous Academic marks: ");
					int marks = sc.nextInt();
					System.out.print("Enter Remarks (if any): ");
					String remarks = sc.next();
					System.out.print("Enter Skills (if any): ");
					String skills = sc.next();
					System.out.print("Enter the Academic Year: ");
					int year = sc.nextInt();
					Academy academy = new Academy(regno,school,marks,remarks,skills,year);
					db.insertAcademy(academy);
					
					System.out.print("\nAdditional Records Successfully created!\n");
					break;
				
				case 2:
					System.out.print("\nEnter Class: ");
					std = sc.next();
					System.out.print("Enter Section: ");
					section = sc.next().charAt(0);
					List<Students> li = db.selectClass(std,section);
					System.out.print("\nRegNo\t|\tName\t\t\n"
							+ "------------------------------");
					for(Students i:li) {
						System.out.print("\n"+i.getRegno()+"\t|\t"+i.getName());
					}
					System.out.print("\n\nEnter the Register Number to update: ");
					regno = sc.next();
					System.out.print("\n1) Student Record\n"
							+ "2) Parents Record\n"
							+ "3) Academy Record\n"
							+ "4) Payment Record\n");
					System.out.print("\nEnter your choice: ");
					int choice1 = sc.nextInt();
					switch(choice1) {
						case 1:
							System.out.print("\nEnter Student's details");
							System.out.print("\nEnter Student Name: ");
							name = sc.next();
							System.out.print("Enter Student Age: ");
							age = sc.nextInt();
							System.out.print("Enter Student's Class: ");
							std = sc.next();
							System.out.print("Enter Student Section: ");
							section = sc.next().charAt(0);
							System.out.print("Enter Student Gender: ");
							gender = sc.next().charAt(0);
							System.out.print("Enter Student Height in cms: ");
							height = sc.nextInt();
							System.out.print("Enter Student Weight in kgs: ");
							weight = sc.nextInt();
							System.out.print("Enter Student's Email: ");
							email = sc.next();
							System.out.print("Enter Student's Phone: ");
							phone = sc.next();
							System.out.print("Enter Student's Address: ");
							address = sc.next();
							student = new Students(regno,name, age, std, section, gender, height, weight, phone, email, address);
							System.out.print("\nRecord Successfully Updated!\n");
							break;
							
						case 2:
							System.out.print("\nEnter Parents' details");
							System.out.print("\nEnter Father Name: ");
							fname = sc.next();
							System.out.print("Enter Father Age: ");
							fage = sc.nextInt();
							System.out.print("Enter Father Occupation: ");
							focc = sc.next();
							System.out.print("Enter Mother Name: ");
							mname = sc.next();
							System.out.print("Enter Mother Age: ");
							mage = sc.nextInt();
							System.out.print("Enter Mother Occupation: ");
							mocc = sc.next();
							System.out.print("Enter Email id: ");
							email = sc.next();
							System.out.print("Enter Phone number: ");
							phone = sc.next();
							System.out.print("Enter Address: ");
							address = sc.next();
							parent = new Parents(regno,fname,mname,fage,mage,focc,mocc,phone, email,address);
							System.out.print("\nRecord Successfully Updated!\n");
							break;
						
						case 3:
							System.out.print("\nEnter Academy details");
							System.out.print("\nEnter School Name: ");
							school = sc.next();
							System.out.print("Enter Previous Academic marks: ");
							marks = sc.nextInt();
							System.out.print("Enter Remarks (if any): ");
							remarks = sc.next();
							System.out.print("Enter Skills (if any): ");
							skills = sc.next();
							System.out.print("Enter the Academic Year: ");
							year = sc.nextInt();
							academy = new Academy(regno,school,marks,remarks,skills,year);
							System.out.print("\nRecord Successfully Updated!\n");
							break;
						
						case 4:
							System.out.print("\nEnter Payment details");
							System.out.print("\nEnter Transaction ID: ");
							String transaction = sc.next();
							System.out.print("Enter Recipient Name: ");
							String recipient = sc.next();
							System.out.print("Enter Phone Number: ");
							phone = sc.next();
							System.out.print("Enter Bank Name: ");
							String bank = sc.next();
							System.out.print("Enter Amount paid: ");
							int amount = sc.nextInt();
							System.out.print("Enter the date paid on: ");
							String paid_on = sc.next();
							System.out.print("Enter Amount due: ");
							int due = sc.nextInt();
							System.out.print("Enter the date due on: ");
							String due_on = sc.next();
							Payment payment = new Payment(transaction, regno,recipient,phone,bank,amount,paid_on,due,due_on);
							System.out.print("\nRecord Successfully Updated!\n");
							break;
							
						default:
							System.out.println("Invalid Input\n");
					}
					break;
				
				case 3:
					regno="";
					System.out.print("\n1) Particular Record\n"
							+ "2) Complete Record\n");
					System.out.print("\nEnter your choice: ");
					int choice2 = sc.nextInt();
					if(choice2==1) {
						System.out.print("\nEnter the Register Number: ");
						regno = sc.next();
					}
					System.out.print("\n1) Student Record\n"
							+ "2) Parents Record\n"
							+ "3) Payment Record\n"
							+ "4) Academy Record\n");
					System.out.print("\nEnter your choice: ");
					choice1 = sc.nextInt();
					
					if(choice1==1&&choice2==1) { 
						student=db.selectStudent(regno);
						System.out.print("\nRegNo: "+student.getRegno()
						+"\nName: "+student.getName()
						+"\nAge: "+student.getAge()
						+"\nStd: "+student.getStd()
						+"\nSec: "+student.getSection()
						+"\nHeight: "+student.getHeight()
						+"\nWeight: "+student.getWeight()
						+"\nPhone: "+student.getPhone()
						+"\nEmail: "+student.getEmail()
						+"\nAddress: "+student.getAddress()+"\n");
					}
					else if(choice1==1&&choice2==2) {
						List<Students> list = db.selectStudents();
						for(Students students:list) {
							System.out.print("\nRegNo: "+students.getRegno()
							+"\nName: "+students.getName()
							+"\nAge: "+students.getAge()
							+"\nStd: "+students.getStd()
							+"\nSec: "+students.getSection()
							+"\nGender: "+students.getGender()
							+"\nHeight: "+students.getHeight()
							+"\nWeight: "+students.getWeight()
							+"\nPhone: "+students.getPhone()
							+"\nEmail: "+students.getEmail()
							+"\nAddress: "+students.getAddress()+"\n");
						}
					}
					else if(choice1==2&&choice2==1) {
						parent=db.selectParent(regno);
						System.out.print("\nRegNo: "+parent.getRegno()
						+"\nFather Name: "+parent.getFather_name()
						+"\nMother Name: "+parent.getMother_name()
						+"\nFather Age: "+parent.getFather_age()
						+"\nMother Age: "+parent.getMother_age()
						+"\nFather Occupation: "+parent.getFather_occupation()
						+"\nMother Occupation: "+parent.getMother_occupation()
						+"\nPhone: "+parent.getPhone()
						+"\nEmail: "+parent.getEmail()
						+"\nAddress: "+parent.getAddress()+"\n");
					}
					else if(choice1==2&&choice2==2) {
						List<Parents> list = db.selectParents();
						for(Parents parents:list) {
							System.out.print("\nRegNo: "+parents.getRegno()
							+"\nFather Name: "+parents.getFather_name()
							+"\nMother Name: "+parents.getMother_name()
							+"\nFather Age: "+parents.getFather_age()
							+"\nMother Age: "+parents.getMother_age()
							+"\nFather Occupation: "+parents.getFather_occupation()
							+"\nMother Occupation: "+parents.getMother_occupation()
							+"\nPhone: "+parents.getPhone()
							+"\nEmail: "+parents.getEmail()
							+"\nAddress: "+parents.getAddress()+"\n");
						}
					}
					else if(choice1==4&&choice2==1) {
						academy=db.selectAcademy(regno);
						System.out.print("\nRegNo: "+academy.getRegno()
						+"\nSchool Name: "+academy.getSchool()
						+"\nMarks: "+academy.getMarks()
						+"\nSkills: "+academy.getSkills()
						+"\nRemarks: "+academy.getRemarks()
						+"\nAcademic Year: "+academy.getYear()+"\n");
					}
					else if(choice1==4&&choice2==2) {
						List<Academy> list = db.selectAcademies();
						for(Academy acad:list) {
							System.out.print("\nRegNo: "+acad.getRegno()
							+"\nSchool Name: "+acad.getSchool()
							+"\nMarks: "+acad.getMarks()
							+"\nSkills: "+acad.getSkills()
							+"\nRemarks: "+acad.getRemarks()
							+"\nAcademic Year: "+acad.getYear()+"\n");
						}
					}
					else if(choice1==3&&choice2==1) {
						Payment payment=db.selectPayment(regno);
						System.out.print("\nTransID: "+payment.getTransactionId()
						+ "\nRegNo: "+payment.getRegno()
						+"\nRecipient Name: "+payment.getRecipient()
						+"\nPhone: "+payment.getPhone()
						+"\nBank: "+payment.getBank()
						+"\nAmount: "+payment.getAmount()
						+"\nPaid On: "+payment.getPaid_on()
						+"\nDue: "+payment.getDue()
						+"\nDue On: "+payment.getDue_on()+"\n");
					}
					else if(choice1==3&&choice2==2) {
						List<Payment> list = db.selectPayments();
						for(Payment payments:list) {
							System.out.print("\nTransID: "+payments.getTransactionId()
							+ "\nRegNo: "+payments.getRegno()
							+"\nRecipient Name: "+payments.getRecipient()
							+"\nPhone: "+payments.getPhone()
							+"\nBank: "+payments.getBank()
							+"\nAmount: "+payments.getAmount()
							+"\nPaid On: "+payments.getPaid_on()
							+"\nDue: "+payments.getDue()
							+"\nDue On: "+payments.getDue_on()+"\n");
						}
					}
					break;
					
				case 4:
					System.out.print("\nEnter the Register number: ");
					regno = sc.next();
					db.deleteStudent(regno);
					System.out.print("\nRecord Successfully deleted!\n");
					break;
					
				case 5:
					System.out.print("\nEnter Class: ");
					std = sc.next();
					System.out.print("Enter Section: ");
					section = sc.next().charAt(0);
					li = db.selectClass(std,section);
					System.out.print("\nRegNo\t\t|\tName\t\t\n"
							+ "------------------------------");
					for(Students i:li) {
						System.out.print("\n"+i.getRegno()+"\t\t|\t"+i.getName());
					}
					System.out.print("\n\nEnter the Register number: ");
					regno = sc.next();
					System.out.print("\n1) Academy Record\n"
							+ "2) Payment Record\n");
					System.out.print("\nEnter your choice: ");
					choice1 = sc.nextInt();
					if(choice1==1) {
						System.out.print("\nEnter Academy details");
						System.out.print("\nEnter School Name: ");
						school = sc.next();
						System.out.print("Enter Previous Academic marks: ");
						marks = sc.nextInt();
						System.out.print("Enter Remarks (if any): ");
						remarks = sc.next();
						System.out.print("Enter Skills (if any): ");
						skills = sc.next();
						System.out.print("Enter the Academic Year: ");
						year = sc.nextInt();
						academy = new Academy(regno,school,marks,remarks,skills,year);
						db.insertAcademy(academy);
					}
					else {
						System.out.print("\nEnter Payment details");
						System.out.print("\nEnter Transaction Id: ");
						String transaction = sc.next();
						System.out.print("Enter Recipient Name: ");
						String recipient = sc.next();
						System.out.print("Enter Phone Number: ");
						phone = sc.next();
						System.out.print("Enter Bank Name: ");
						String bank = sc.next();
						System.out.print("Enter Amount paid: ");
						int amount = sc.nextInt();
						System.out.print("Enter the date paid on: ");
						String paid_on = sc.next();
						System.out.print("Enter Amount due: ");
						int due = sc.nextInt();
						System.out.print("Enter the date due on: ");
						String due_on = sc.next();
						Payment payment = new Payment(transaction, regno,recipient,phone,bank,amount,paid_on,due,due_on);
						db.insertPayment(payment);
					}
					System.out.print("\nRecord inserted Successfully!\n");
					break;
					
				case 6:
					break;
				
				default:
					System.out.println("The input is invalid, Try once again!\n\n");
			}
		}
		
		System.out.println("\nThanks! for accessing our Service");
		
		// close Scanner
		sc.close();
		
		// close the context
		context.close();
	}

}
