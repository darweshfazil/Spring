package operations;

import model.Students;
import java.util.Random;

public class GetRollNo implements StudentOperations{

	private Random myRandom = new Random();
	
	@Override
	public String generateRollNo(Students student) {
		String middle="0"+student.getStd();
		int index = myRandom.nextInt(999);
		String rollNo = "22"+middle+"0"+index;
		return rollNo;
	}
}
