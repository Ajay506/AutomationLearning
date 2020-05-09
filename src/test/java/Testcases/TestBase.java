package Testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	public static WebDriver driver;
	
	
	@BeforeSuite
	
	public void setup() {
		
		
		if(driver==null) {
			
			
		WebDriverManager.chromedriver().setup();
			
		driver = new ChromeDriver();
		
		driver.get("https://gmail.com");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		}
	}

	
	@AfterSuite
	
	public void tearDown() {
		
		driver.close();
		
		
	}
	
	
}
