package Testcases;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestScreenshot {

	public static WebDriver driver;

	public void getScreenshot() {

		Date d = new Date();

		String name = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		try {

			FileUtils.copyFile(source, new File(".//screenshot" + name));

		} catch (IOException e) {

			e.printStackTrace();
		}
		
		
	}
	
	public void login() {

	WebDriverManager.chromedriver().setup();
	
	driver.get("https://google.com");
	
	driver.manage().window().maximize();
	
	getScreenshot();
}

}