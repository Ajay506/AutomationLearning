package customlisteners;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import Testcases.TestBase;




public class Listeners extends TestBase implements ITestListener{
		
	

	public void onTestStart(ITestResult result) {
		
		System.out.println("Regression started for :"+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
	}

	public void onTestFailure(ITestResult result) {
		
		String methodname = result.getName();
		
		Date d = new Date();

		String name = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {
			
			

			FileUtils.copyFile(source, new File("C:\\Ajay\\Selenium\\TestNGLearning\\screenshots"+"\\"+methodname+""+name));

		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
		
	}
		

	public void onTestSkipped(ITestResult result) {
		// FIXME Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// FIXME Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// FIXME Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// FIXME Auto-generated method stub
		
	}
	
	
}