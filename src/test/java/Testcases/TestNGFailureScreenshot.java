package Testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestNGFailureScreenshot extends TestBase {

		
	
	@Test
	
	public void login() {
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("bajaykumar.ak@gmail.com");
	
		driver.findElement(By.xpath("//span[text()='Next']")).click();
		
		//TakesScreenshot screenshot = (TakesScreenshot) driver;
		
		
 		
	}

}
