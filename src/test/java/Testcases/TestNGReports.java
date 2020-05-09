package Testcases;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNGReports {

	public static WebDriver driver;

	@BeforeClass

	public void login() throws Exception {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.naukri.com/");
		driver.manage().window().maximize();
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Handling Multiple pop up tabs at the begining

		String originalHandle = driver.getWindowHandle();

		for (String handle : driver.getWindowHandles()) {

			if (!handle.equals(originalHandle)) {

				driver.switchTo().window(handle);
				driver.close();
			}
		}

		driver.switchTo().window(originalHandle);

	}

	@Test

	public void websiteTesting() throws Exception {

		Actions action = new Actions(driver);

		WebElement link = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/ul[1]/li[1]/a"));

		action.moveToElement(link).perform();

		driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/ul[1]/li[1]/div/ul[2]/li[1]/a")).click();

		// JavascriptExecutor js = (JavascriptExecutor) driver;

		// js.executeScript(script, args)

		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().defaultContent();

		System.out.println(tabs2.size());

		driver.switchTo().window(tabs2.get(1));

		driver.findElement(By.linkText("Jobs in Hyderabad")).click();

		// driver.findElement(By.xpath("//*[@id=\"emailId\"]")).sendKeys("bajaykumar.ak@gmail.com");

		// driver.findElement(By.xpath("/html/body/div[3]/div[3]/div[1]/div[2]/ul/li[3]/a")).click();

		tabs2 = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().defaultContent();

		System.out.println(tabs2.size());

		driver.switchTo().window(tabs2.get(2));

		driver.findElement(By.xpath("//a[@data-label=\"Java\"]")).click();

		driver.findElement(By.xpath("//article[@class='jobTuple bgWhite br4 mb-8'][1]")).click();

		// List<WebElement> results =
		// driver.findElements(By.xpath("//*[@id=\"root\"]/div[3]/div[2]/section[2]/div[2]"));

		// driver.findElement(By.xpath("//article[@data-job-id=\"290319501794\"]")).click();

		tabs2 = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(tabs2.get(3));

		System.out.println(tabs2.size());

	}

	@AfterClass

	public void closeBrowser() throws Exception {

		driver.quit();

	}

}
