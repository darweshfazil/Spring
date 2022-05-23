package model;

import org.springframework.beans.factory.annotation.Autowired;

public class Payment implements School {
	
	private int id;
	private String recipient;
	private String phone;
	private String bank;
	private int amount;
	private String paid_on;
	private int due;
	private String due_on;
	
	public Payment() {
		
	}
	
	public Payment(int id, String recipient, String phone, String bank, int amount, String paid_on, int due, String due_on) {
		this.id = id;
		this.recipient = recipient;
		this.phone = phone;
		this.bank = bank;
		this.amount = amount;
		this.paid_on = paid_on;
		this.due = due;
		this.due_on = due_on;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getPaid_on() {
		return paid_on;
	}

	public void setPaid_on(String paid_on) {
		this.paid_on = paid_on;
	}

	public int getDue() {
		return due;
	}

	public void setDue(int due) {
		this.due = due;
	}

	public String getDue_on() {
		return due_on;
	}

	public void setDue_on(String due_on) {
		this.due_on = due_on;
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
