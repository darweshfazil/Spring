package model;

import org.springframework.beans.factory.annotation.Autowired;

public class Academy implements School {

	private int id;
	private String school;
	private int marks;
	private String remarks;
	private String skills;
	private int year;
	
	public Academy() {
		
	}
	
	public Academy(int id, String school, int marks, String remarks, String skills, int year) {
		this.id = id;
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	@Override
//	public void insertRecord() {
//		// TODO Auto-generated method stub
//		
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
