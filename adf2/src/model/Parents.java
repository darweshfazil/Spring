package model;

//import org.springframework.beans.factory.annotation.Autowired;

public class Parents{
	
	private int id;
	private String father_name;
	private String mother_name;
	private int father_age;
	private int mother_age;
	private String father_occupation;
	private String mother_occupation;
	private String phone;
	private String email;
	private String address;
	
	
	public Parents() {
		
	}
	
	public Parents(int id,String father_name, String mother_name, int father_age, int mother_age, String father_occupation, String mother_occupation, String phone, String email, String address) {
		this.id = id;
		this.father_name = father_name;
		this.mother_name = mother_name;
		this.father_age = father_age;
		this.mother_age = mother_age;
		this.father_occupation = father_occupation;
		this.mother_occupation = mother_occupation;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	public String getFather_name() {
		return father_name;
	}

	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}

	public String getMother_name() {
		return mother_name;
	}

	public void setMother_name(String mother_name) {
		this.mother_name = mother_name;
	}

	public int getFather_age() {
		return father_age;
	}

	public void setFather_age(int father_age) {
		this.father_age = father_age;
	}

	public int getMother_age() {
		return mother_age;
	}

	public void setMother_age(int mother_age) {
		this.mother_age = mother_age;
	}

	public String getFather_occupation() {
		return father_occupation;
	}

	public void setFather_gender(String father_occupation) {
		this.father_occupation = father_occupation;
	}

	public String getMother_occupation() {
		return mother_occupation;
	}

	public void setMother_occupation(String mother_occupation) {
		this.mother_occupation = mother_occupation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
