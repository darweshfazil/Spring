package model;

public class Academy{

	private String regno;
	private String school;
	private int marks;
	private String remarks;
	private String skills;
	private int year;
	
	public Academy() {
		
	}
	
	public Academy(String regno, String school, int marks, String remarks, String skills, int year) {
		this.regno = regno;
		this.school = school;
		this.marks = marks;
		this.remarks = remarks;
		this.skills = skills;
		this.year = year;
	}
	
	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	public String getRegno() {
		return regno;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}
}
