package model;

public class Students{
	
	private String regno;
	private String name;
	private int age;
	private String std;
	private char section;
	private char gender;
	private int height;
	private int weight;
	private String phone;
	private String email;
	private String address;
	
	public Students() {
		
	}

	public Students(String regno, String name) {
		this.name = name;
		this.regno = regno;
	}
	public Students(String name, int age, String std, char section, char gender, int height, int weight, String phone, String email, String address) {
		this.name = name;
		this.age = age;
		this.std = std;
		this.section = section;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public Students(String regno, String name, int age, String std, char section, char gender, int height, int weight, String phone, String email, String address) {
		this.regno = regno;
		this.name = name;
		this.age = age;
		this.std = std;
		this.section = section;
		this.gender = gender;
		this.height = height;
		this.weight = weight;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}
	
	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}
	
	public String getStd() {
		return std;
	}

	public void setStd(String std) {
		this.std = std;
	}

	public char getSection() {
		return section;
	}

	public void setSection(char section) {
		this.section = section;
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
}
