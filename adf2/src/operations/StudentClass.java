package operations;

import model.Students;

public class StudentClass implements Person {

	public model.Students student;
	public StudentOperations GetRollNo;
	
	public StudentClass(StudentOperations GetRollNo) {
		this.GetRollNo = GetRollNo;
	}
	
	@Override
	public String getRollNo(Students student) {
		return GetRollNo.generateRollNo(student);
	}
}
