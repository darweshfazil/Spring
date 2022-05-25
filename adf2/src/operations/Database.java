package operations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Academy;
import model.Parents;
import model.Payment;
import model.Students;

public class Database {
	
	// Database Credentials
	
	private String jdbcURL= "jdbc:mysql://localhost:3306/Student";
	private String jdbcUsername = "root";
	private String jdbcPassword = "root";
	
	// SQL Queries stored as final Strings
	
	private static final String INSERT_STUDENT_SQL = "INSERT INTO StudentPersonalDetails" + "(regno,name,age,std, sec, gender,height,weight,phone,email,address) VALUES" + "(?,?,?,?,?,?,?,?,?,?,?);";
	private static final String INSERT_PARENT_SQL = "INSERT INTO ParentsPersonalDetails" + "(regno,father_name,mother_name, father_age, mother_age, father_occupation, mother_occupation,phone,email,address) VALUES" + "(?,?,?,?,?,?,?,?,?,?);";
	private static final String INSERT_ACADEMY_SQL = "INSERT INTO AcademyDetails" + "(regno,school,marks,remarks,skills,year) VALUES" + "(?,?,?,?,?,?);";
	private static final String INSERT_PAYMENT_SQL = "INSERT INTO PaymentDetails" + "(transid,regno,recipient,phone,bank,amount,paid_on,due,due_on) VALUES" + "(?,?,?,?,?,?,?,?,?);";
	
	private static final String SELECT_STUDENT = "select regno,name,std,sec,age,gender,height,weight,phone,email,address from StudentPersonalDetails where regno =?;";
	private static final String SELECT_STUDENTS = "select * from StudentPersonalDetails;";
	private static final String SELECT_PARENT = "select reg,father_name,mother_name, father_age, mother_age, father_occupation, mother_occupation,phone,email,address from ParentsPersonalDetails where regno =?;";
	private static final String SELECT_PARENTS = "select * from ParentsPersonalDetails;";
	private static final String SELECT_ACADEMY = "select regno,school,marks,remarks,skills,year from AcademyDetails where regno =?;";
	private static final String SELECT_ACADEMY_RECORDS = "select * from AcademyDetails;";
	private static final String SELECT_PAYMENT = "select transid,regno,recipient,phone,bank,amount,paid_on,due,due_on from PaymentDetails where regno =?;";
	private static final String SELECT_PAYMENTS = "select * from PaymentDetails;";
	private static final String SELECT_CLASS = "select regno, name from StudentPersonalDetails where std=? and sec=?;";
	
	private static final String UPDATE_STUDENT_SQL = "update StudentPersonalDetails set name = ?, age=?, std=?, sec=?, gender=?, height=?, weight=?, phone=?, email=?, address=? where regno = ?;";
	private static final String UPDATE_PARENTS_SQL = "update ParentsPersonalDetails set father_name = ?, father_age = ?, father_occupation = ?,mother_name = ?, mother_age = ?, mother_occupation = ?, phone = ?,email = ?,address = ? where regno = ?;";
	private static final String UPDATE_ACADEMY_SQL = "update AcademyDetails set school = ?,marks = ?,remarks = ?,skills = ?, year = ? where regno = ?;";
	private static final String UPDATE_PAYMENT_SQL = "update PaymentDetails set recipient = ?,phone = ?,bank = ?,amount = ?,paid_on = ?,due = ?,due = ? where regno = ? and transid = ?;";
	
	private static final String DELETE_STUDENT_SQL = "delete from StudentPersonalDetails where regno=?;";
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL,jdbcUsername,jdbcPassword);
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	//CREATE OR INSERT USER DETAILS INTO DATABASE
	//Create or insert Student
	public void insertStudent(Students student) throws SQLException{
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT_SQL);
			preparedStatement.setString(1, student.getRegno());
			preparedStatement.setString(2, student.getName());
			preparedStatement.setInt(3, student.getAge());
			preparedStatement.setString(4, student.getStd());
			preparedStatement.setString(5, String.valueOf(student.getSection()));
			preparedStatement.setString(6, String.valueOf(student.getGender()));
			preparedStatement.setInt(7, student.getHeight());
			preparedStatement.setInt(8, student.getWeight());
			preparedStatement.setString(9, student.getPhone());
			preparedStatement.setString(10, student.getEmail());
			preparedStatement.setString(11, student.getAddress());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Create or insert Parent
	public void insertParent(Parents parent) throws SQLException{
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PARENT_SQL);
			preparedStatement.setString(1, parent.getRegno());
			preparedStatement.setString(2, parent.getFather_name());
			preparedStatement.setString(3, parent.getMother_name());
			preparedStatement.setInt(4, parent.getFather_age());
			preparedStatement.setInt(5, parent.getMother_age());
			preparedStatement.setString(6, parent.getFather_occupation());
			preparedStatement.setString(7, parent.getMother_occupation());
			preparedStatement.setString(8, parent.getPhone());
			preparedStatement.setString(9, parent.getEmail());
			preparedStatement.setString(10, parent.getAddress());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Create or insert Academy
	public void insertAcademy(Academy academy) throws SQLException{
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ACADEMY_SQL);
			preparedStatement.setString(1, academy.getRegno());
			preparedStatement.setString(2, academy.getSchool());
			preparedStatement.setInt(3, academy.getMarks());
			preparedStatement.setString(4, academy.getRemarks());
			preparedStatement.setString(5, academy.getSkills());
			preparedStatement.setInt(6, academy.getYear());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	//Create or insert Payment
	public void insertPayment(Payment payment) throws SQLException{
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PAYMENT_SQL);
			preparedStatement.setString(1, payment.getTransactionId());
			preparedStatement.setString(2, payment.getRegno());
			preparedStatement.setString(3, payment.getRecipient());
			preparedStatement.setString(4, payment.getPhone());
			preparedStatement.setString(5, payment.getBank());
			preparedStatement.setInt(6, payment.getAmount());
			preparedStatement.setString(7, payment.getPaid_on());
			preparedStatement.setInt(8, payment.getDue());
			preparedStatement.setString(9, payment.getDue_on());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// SELECT RECORDS FROM DATABASE
	// select student from database using id
	public Students selectStudent(String regno) throws SQLException {
		Students student = null;
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT);
			preparedStatement.setString(1, regno);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String std = rs.getString("std");
				char sec = rs.getString("sec").charAt(0);
				char gender = rs.getString("gender").charAt(0);
				int height = rs.getInt("height");
				int weight = rs.getInt("weight");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				student = new Students(name, age, std, sec, gender, height, weight, phone, email, address);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	// select all students record from database
	public List<Students> selectStudents() throws SQLException {
		List<Students> students = new ArrayList<>();
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENTS);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String regno = rs.getString("regno");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String std = rs.getString("std");
				char sec = rs.getString("sec").charAt(0);
				char gender = rs.getString("gender").charAt(0);
				int height = rs.getInt("height");
				int weight = rs.getInt("weight");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				students.add(new Students(regno, name, age, std, sec, gender, height, weight, phone, email, address));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
	
	public List<Students> selectClass(String std, char sec) throws SQLException {
		List<Students> students = new ArrayList<>();
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CLASS);
			preparedStatement.setString(1, std);
			preparedStatement.setString(2, String.valueOf(sec));
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String regno = rs.getString("regno");
				String name = rs.getString("name");
				students.add(new Students(regno, name));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
		
	// select parent from database using id
	public Parents selectParent(String regno) throws SQLException {
		Parents parent = null;
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PARENT);
			preparedStatement.setString(1, regno);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String father_name = rs.getString("father_name");
				int father_age = rs.getInt("father_age");
				String father_occupation = rs.getString("father_occupation");
				String mother_name = rs.getString("mother_name");
				int mother_age = rs.getInt("mother_age");
				String mother_occupation = rs.getString("mother_occupation");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				parent = new Parents(regno,father_name,mother_name, father_age, mother_age, father_occupation, mother_occupation,phone,email,address);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return parent;
	}
		
	// select all parents record
	public List<Parents> selectParents() throws SQLException {
		List<Parents> parents = new ArrayList<>();
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PARENTS);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String regno = rs.getString("regno");
				String father_name = rs.getString("father_name");
				int father_age = rs.getInt("father_age");
				String father_occupation = rs.getString("father_occupation");
				String mother_name = rs.getString("mother_name");
				int mother_age = rs.getInt("mother_age");
				String mother_occupation = rs.getString("mother_occupation");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				parents.add(new Parents(regno,father_name,mother_name, father_age, mother_age, father_occupation, mother_occupation,phone,email,address));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return parents;
	}
		
	// select academy from database using id
	public Academy selectAcademy(String regno) throws SQLException {
		Academy academy = null;
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACADEMY);
			preparedStatement.setString(1, regno);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String school = rs.getString("school");
				int marks = rs.getInt("marks");
				String remarks = rs.getString("remarks");
				String skills = rs.getString("skills");
				int year = rs.getInt("year");
				academy = new Academy(regno,school,marks,remarks,skills,year);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return academy;
	}
				
	// select all academy record
	public List<Academy> selectAcademies() throws SQLException {
		List<Academy> academy = new ArrayList<>();
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACADEMY_RECORDS);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String regno = rs.getString("regno");
				String school = rs.getString("school");
				int marks = rs.getInt("marks");
				String remarks = rs.getString("remarks");
				String skills = rs.getString("skills");
				int year = rs.getInt("year");
				academy.add(new Academy(regno,school,marks,remarks,skills,year));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return academy;
	}
	
	// select Payment detail with id
	public Payment selectPayment(String regno) throws SQLException {
		Payment payment = null;
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PAYMENT);
			preparedStatement.setString(1, regno);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String transaction = rs.getString("transid");
				String recipient = rs.getString("recipient");
				String phone = rs.getString("phone");
				String bank = rs.getString("bank");
				int amount = rs.getInt("amount");
				String paid_on = rs.getString("paid_on");
				int due = rs.getInt("due");
				String due_on = rs.getString("due_on");
				payment = new Payment(transaction,regno,recipient, phone, bank, amount, paid_on, due, due_on);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return payment;
	}
	
	// select all payment records
	public List<Payment> selectPayments() throws SQLException {
		List<Payment> payment = new ArrayList<>();
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PAYMENTS);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String transaction = rs.getString("transid");
				String regno = rs.getString("regno");
				String recipient = rs.getString("recipient");
				String phone = rs.getString("phone");
				String bank = rs.getString("bank");
				int amount = rs.getInt("amount");
				String paid_on = rs.getString("paid_on");
				int due = rs.getInt("due");
				String due_on = rs.getString("due_on");
				payment.add(new Payment(transaction, regno,recipient, phone, bank, amount, paid_on, due, due_on));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return payment;
	}
	
	// UPDATE DATA OF RECORDS IN DATABASE
	// update the data of student
	public boolean updateStudent(Students student) throws SQLException{
		boolean rowUpdated;
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, student.getStd());
			preparedStatement.setString(4, String.valueOf(student.getSection()));
			preparedStatement.setString(5, String.valueOf(student.getGender()));
			preparedStatement.setInt(6, student.getHeight());
			preparedStatement.setInt(7, student.getWeight());
			preparedStatement.setString(8, student.getPhone());
			preparedStatement.setString(9, student.getEmail());
			preparedStatement.setString(10, student.getAddress());
			preparedStatement.setString(11, student.getRegno());
			
			rowUpdated = preparedStatement.executeUpdate()>0;
		}
		return rowUpdated;
	}
	
	// update the data of parent
	public boolean updateParent(Parents parent) throws SQLException{
		boolean rowUpdated;
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PARENTS_SQL);
			preparedStatement.setString(1, parent.getFather_name());
			preparedStatement.setInt(2, parent.getFather_age());
			preparedStatement.setString(3, parent.getFather_occupation());
			preparedStatement.setString(4, parent.getMother_name());
			preparedStatement.setInt(5, parent.getMother_age());
			preparedStatement.setString(6, parent.getMother_occupation());
			preparedStatement.setString(7, parent.getPhone());
			preparedStatement.setString(8, parent.getEmail());
			preparedStatement.setString(9, parent.getAddress());
			preparedStatement.setString(10, parent.getRegno());
			
			rowUpdated = preparedStatement.executeUpdate()>0;
		}
		return rowUpdated;
	}
	
	// update the data of academy
	public boolean updateAcademy(Academy academy) throws SQLException{
		boolean rowUpdated;
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACADEMY_SQL);
			preparedStatement.setString(1, academy.getSchool());
			preparedStatement.setInt(2, academy.getMarks());
			preparedStatement.setString(3, academy.getRemarks());
			preparedStatement.setString(4, academy.getSkills());
			preparedStatement.setInt(5, academy.getYear());
			preparedStatement.setString(6, academy.getRegno());
			
			rowUpdated = preparedStatement.executeUpdate()>0;
		}
		return rowUpdated;
	}
	
	// update the data of Payment
	public boolean updatePayment(Payment payment) throws SQLException{
		boolean rowUpdated;
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PAYMENT_SQL);
			preparedStatement.setString(1, payment.getRecipient());
			preparedStatement.setString(2, payment.getPhone());
			preparedStatement.setString(3, payment.getBank());
			preparedStatement.setInt(4, payment.getAmount());
			preparedStatement.setString(5, payment.getPaid_on());
			preparedStatement.setInt(6, payment.getDue());
			preparedStatement.setString(7, payment.getDue_on());
			preparedStatement.setString(8, payment.getRegno());
			preparedStatement.setString(9, payment.getTransactionId());
			
			rowUpdated = preparedStatement.executeUpdate()>0;
		}
		return rowUpdated;
	}
	
	// DELETE DETAILS FROM THE DATABASE
	// Delete entire Student record
	public boolean deleteStudent(String regno) throws SQLException{
		boolean rowDeleted;
		try(Connection connection = getConnection()){
			PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_SQL);
			statement.setString(1, regno);
			rowDeleted = statement.executeUpdate()>0;
		}
		return rowDeleted;
	}
}
