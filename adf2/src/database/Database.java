package database;

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
	
	private static final String INSERT_STUDENT_SQL = "INSERT INTO StudentPersonalDetails" + "(name,age,gender,height,weight,phone,email,address) VALUES" + "(?,?,?,?,?,?,?,?);";
	private static final String INSERT_PARENT_SQL = "INSERT INTO ParentsPersonalDetails" + "(id,father_name,mother_name, father_age, mother_age, father_occupation, mother_occupation,phone,email,address) VALUES" + "(?,?,?,?,?,?,?,?,?,?);";
	private static final String INSERT_ACADEMY_SQL = "INSERT INTO AcademyDetails" + "(sid,school,marks,remarks,skills,year) VALUES" + "(?,?,?,?,?,?);";
	private static final String INSERT_PAYMENT_SQL = "INSERT INTO PaymentDetails" + "(id,recipient,phone,bank,amount,paid_on,due,due_on) VALUES" + "(?,?,?,?,?,?,?,?);";
	
	private static final String SELECT_STUDENT = "select id,name,age,gender,height,weight,phone,email,address from StudentPersonalDetails where id =?;";
	private static final String SELECT_STUDENTS = "select * from StudentPersonalDetails;";
	private static final String SELECT_PARENT = "select id,father_name,mother_name, father_age, mother_age, father_occupation, mother_occupation,phone,email,address from ParentsPersonalDetails where id =?;";
	private static final String SELECT_PARENTS = "select * from ParentsPersonalDetails;";
	private static final String SELECT_ACADEMY = "select sid,school,marks,remarks,skills,year from AcademyDetails where sid =?;";
	private static final String SELECT_ACADEMY_RECORDS = "select * from AcademyDetails;";
	private static final String SELECT_PAYMENT = "select id,recipient,phone,bank,amount,paid_on,due,due_on from PaymentDetails where id =?;";
	private static final String SELECT_PAYMENTS = "select * from PaymentDetails;";
	
	private static final String UPDATE_STUDENT_SQL = "update StudentPersonalDetails set name = ?, age=?, gender=?, height=?, weight=?, phone=?, email=?, address=? where id = ?;";
	private static final String UPDATE_PARENTS_SQL = "update ParentsPersonalDetails set id =? ,father_name = ?, mother_name = ?, father_age = ?, mother_age = ?, father_occupation = ?, mother_occupation = ?,phone = ?,email = ?,address = ? where id = ?;";
	private static final String UPDATE_ACADEMY_SQL = "update AcademyDetails set sid = ?,school = ?,marks = ?,remarks = ?,skills = ?, year = ? where sid = ?;";
	private static final String UPDATE_PAYMENT_SQL = "update PaymentDetails set id = ?,recipient = ?,phone = ?,bank = ?,amount = ?,paid_on = ?,due = ?,due = ? where id = ?;";
	
	private static final String DELETE_STUDENT_SQL = "delete from StudentPersonalDetails where id=?;";
	
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
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, String.valueOf(student.getGender()));
			preparedStatement.setInt(4, student.getHeight());
			preparedStatement.setInt(5, student.getWeight());
			preparedStatement.setString(6, student.getPhone());
			preparedStatement.setString(7, student.getEmail());
			preparedStatement.setString(8, student.getAddress());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Create or insert Parent
	public void insertParent(Parents parent) throws SQLException{
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PARENT_SQL);
			preparedStatement.setInt(1, parent.getId());
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
			preparedStatement.setInt(1, academy.getId());
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
			preparedStatement.setInt(1, payment.getId());
			preparedStatement.setString(2, payment.getRecipient());
			preparedStatement.setString(3, payment.getPhone());
			preparedStatement.setString(4, payment.getBank());
			preparedStatement.setInt(5, payment.getAmount());
			preparedStatement.setString(6, payment.getPaid_on());
			preparedStatement.setInt(7, payment.getDue());
			preparedStatement.setString(8, payment.getDue_on());
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// SELECT RECORDS FROM DATABASE
	// select student from database using id
	public Students selectStudent(int id) throws SQLException {
		Students student = null;
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_STUDENT);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				char gender = rs.getString("gender").charAt(0);
				int height = rs.getInt("height");
				int weight = rs.getInt("weight");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				student = new Students(name, age, gender, height, weight, phone, email, address);
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
				String name = rs.getString("name");
				int age = rs.getInt("age");
				char gender = rs.getString("gender").charAt(0);
				int height = rs.getInt("height");
				int weight = rs.getInt("weight");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				students.add(new Students(name, age, gender, height, weight, phone, email, address));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return students;
	}
		
	// select parent from database using id
	public Parents selectParent(int id) throws SQLException {
		Parents parent = null;
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PARENT);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				int sid = rs.getInt("id");
				String father_name = rs.getString("father_name");
				String mother_name = rs.getString("mother_name");
				int father_age = rs.getInt("father_age");
				int mother_age = rs.getInt("mother_age");
				String father_occupation = rs.getString("father_occupation");
				String mother_occupation = rs.getString("mother_occupation");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				parent = new Parents(sid,father_name,mother_name, father_age, mother_age, father_occupation, mother_occupation,phone,email,address);
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
				int sid = rs.getInt("id");
				String father_name = rs.getString("father_name");
				String mother_name = rs.getString("mother_name");
				int father_age = rs.getInt("father_age");
				int mother_age = rs.getInt("mother_age");
				String father_occupation = rs.getString("father_occupation");
				String mother_occupation = rs.getString("mother_occupation");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				String address = rs.getString("address");
				parents.add(new Parents(sid,father_name,mother_name, father_age, mother_age, father_occupation, mother_occupation,phone,email,address));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return parents;
	}
		
	// select academy from database using id
	public Academy selectAcademy(int id) throws SQLException {
		Academy academy = null;
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ACADEMY);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String school = rs.getString("school");
				int marks = rs.getInt("marks");
				String remarks = rs.getString("remarks");
				String skills = rs.getString("skills");
				int year = rs.getInt("year");
				academy = new Academy(id,school,marks,remarks,skills,year);
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
				int id = rs.getInt("sid");
				String school = rs.getString("school");
				int marks = rs.getInt("marks");
				String remarks = rs.getString("remarks");
				String skills = rs.getString("skills");
				int year = rs.getInt("year");
				academy.add(new Academy(id,school,marks,remarks,skills,year));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return academy;
	}
	
	// select Payment detail with id
	public Payment selectPayment(int id) throws SQLException {
		Payment payment = null;
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PAYMENT);
			preparedStatement.setInt(1, id);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				String recipient = rs.getString("recipient");
				String phone = rs.getString("phone");
				String bank = rs.getString("bank");
				int amount = rs.getInt("amount");
				String paid_on = rs.getString("paid_on");
				int due = rs.getInt("due");
				String due_on = rs.getString("due_on");
				payment = new Payment(id,recipient, phone, bank, amount, paid_on, due, due_on);
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
				int id = rs.getInt("id");
				String recipient = rs.getString("recipient");
				String phone = rs.getString("phone");
				String bank = rs.getString("bank");
				int amount = rs.getInt("amount");
				String paid_on = rs.getString("paid_on");
				int due = rs.getInt("due");
				String due_on = rs.getString("due_on");
				payment.add(new Payment(id,recipient, phone, bank, amount, paid_on, due, due_on));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return payment;
	}
	
	// select name with given id
	public int getStudentId(String name) throws SQLException {
		int id=0;
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement("select id from StudentPersonalDetails where name = ?;");
			preparedStatement.setString(1, name);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()) {
				id = rs.getInt("id");
			}
		}
		return id;
	}
	
	// UPDATE DATA OF RECORDS IN DATABASE
	// update the data of student
	public boolean updateStudent(int id, Students student) throws SQLException{
		boolean rowUpdated;
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT_SQL);
			preparedStatement.setString(1, student.getName());
			preparedStatement.setInt(2, student.getAge());
			preparedStatement.setString(3, String.valueOf(student.getGender()));
			preparedStatement.setInt(4, student.getHeight());
			preparedStatement.setInt(5, student.getWeight());
			preparedStatement.setString(6, student.getPhone());
			preparedStatement.setString(7, student.getEmail());
			preparedStatement.setString(8, student.getAddress());
			preparedStatement.setInt(9, id);
			
			rowUpdated = preparedStatement.executeUpdate()>0;
		}
		return rowUpdated;
	}
	
	// update the data of parent
	public boolean updateParent(Parents parent) throws SQLException{
		boolean rowUpdated;
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PARENTS_SQL);
			preparedStatement.setInt(1, parent.getId());
			preparedStatement.setString(2, parent.getFather_name());
			preparedStatement.setString(3, parent.getMother_name());
			preparedStatement.setInt(4, parent.getFather_age());
			preparedStatement.setInt(5, parent.getMother_age());
			preparedStatement.setString(6, parent.getFather_occupation());
			preparedStatement.setString(7, parent.getMother_occupation());
			preparedStatement.setString(8, parent.getPhone());
			preparedStatement.setString(9, parent.getEmail());
			preparedStatement.setString(10, parent.getAddress());
			preparedStatement.setInt(11, parent.getId());
			
			rowUpdated = preparedStatement.executeUpdate()>0;
		}
		return rowUpdated;
	}
	
	// update the data of academy
	public boolean updateAcademy(Academy academy) throws SQLException{
		boolean rowUpdated;
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ACADEMY_SQL);
			preparedStatement.setInt(1, academy.getId());
			preparedStatement.setString(2, academy.getSchool());
			preparedStatement.setInt(3, academy.getMarks());
			preparedStatement.setString(4, academy.getRemarks());
			preparedStatement.setString(5, academy.getSkills());
			preparedStatement.setInt(6, academy.getYear());
			preparedStatement.setInt(7, academy.getId());
			
			rowUpdated = preparedStatement.executeUpdate()>0;
		}
		return rowUpdated;
	}
	
	// update the data of Payment
	public boolean updatePayment(Payment payment) throws SQLException{
		boolean rowUpdated;
		try(Connection connection = getConnection()){
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PAYMENT_SQL);
			preparedStatement.setInt(1, payment.getId());
			preparedStatement.setString(2, payment.getRecipient());
			preparedStatement.setString(3, payment.getPhone());
			preparedStatement.setString(4, payment.getBank());
			preparedStatement.setInt(5, payment.getAmount());
			preparedStatement.setString(6, payment.getPaid_on());
			preparedStatement.setInt(7, payment.getDue());
			preparedStatement.setString(8, payment.getDue_on());
			preparedStatement.setInt(9, payment.getId());
			
			rowUpdated = preparedStatement.executeUpdate()>0;
		}
		return rowUpdated;
	}
	
	// DELETE DETAILS FROM THE DATABASE
	// Delete entire Student record
	public boolean deleteStudent(int id) throws SQLException{
		boolean rowDeleted;
		try(Connection connection = getConnection()){
			PreparedStatement statement = connection.prepareStatement(DELETE_STUDENT_SQL);
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate()>0;
		}
		return rowDeleted;
	}
}
