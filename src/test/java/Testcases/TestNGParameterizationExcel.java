package Testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGParameterizationExcel {

	
	@Test (dataProvider = "getData")
	
	public void testData(String username, String password, String is_correct) {
		
		
		System.out.println(username+"----"+password+"-----"+is_correct);
			
		
	}

	@DataProvider
	
	public static Object[][] getData() {
		
		
		Object[][] object = new Object[2][3];
		
		object[0][0]= "Ajay";
		object[0][1]= "kumar";
		object[0][2]= "Suraaga";
		
		
		return object;
		
		
	}
}


