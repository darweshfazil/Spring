package model;

public class Students implements School{
	
	private String name;
	private int age;
	private char gender;
	private int height;
	private int weight;
	private String phone;
	private String email;
	private String address;
	
	public Students() {
		
	}
	
	public Students(String name, int age, char gender, int height, int weight, String phone, String email, String address) {
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

//	@Override
//	public void insertRecord() {
//		System.out.println("Hi");
//	}
//
//	@Override
//	public void deleteRecord() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void updateRecord() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void displayRecord() {
//		// TODO Auto-generated method stub
//		
//	}
}
