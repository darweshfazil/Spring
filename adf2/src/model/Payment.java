package model;

public class Payment{
	
	private String transactionId;
	private String regno;
	private String recipient;
	private String phone;
	private String bank;
	private int amount;
	private String paid_on;
	private int due;
	private String due_on;
	
	public Payment() {
		
	}
	
	public Payment(String transactionId, String regno, String recipient, String phone, String bank, int amount, String paid_on, int due, String due_on) {
		this.transactionId = transactionId;
		this.regno = regno;
		this.recipient = recipient;
		this.phone = phone;
		this.bank = bank;
		this.amount = amount;
		this.paid_on = paid_on;
		this.due = due;
		this.due_on = due_on;
	}
	
	
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public void setRegno(String regno) {
		this.regno = regno;
	}

	public String getRegno() {
		return regno;
	}

	public void setId(String regno) {
		this.regno = regno;
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
}
