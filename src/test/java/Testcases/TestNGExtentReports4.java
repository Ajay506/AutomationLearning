package Testcases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestNGExtentReports4 {

	public ExtentSparkReporter htmlReporter; // HTMLExtentReporter is deprecated extentsparkreportes is replaced with
												// that

	public ExtentReports extent;

	public ExtentTest test;

	@BeforeTest

	public void setReport() {

		htmlReporter = new ExtentSparkReporter("./reports/extent.html");

		htmlReporter.config().setEncoding("utf-8");

		htmlReporter.config().setDocumentTitle("Automation Reports");

		htmlReporter.config().setReportName("Automation test results");

		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Automation Tester", "Ajay Kumar");

		extent.setSystemInfo("Organization", "Telus Health");

		extent.setSystemInfo("Project", "BOSE");

	}

	@AfterTest

	public void closeReport() {

		extent.flush();

	}

	@Test

	public void doLogin() {

		test = extent.createTest("Login Test");

		System.out.println("Executing Login Test");

	}

	@Test

	public void doUserReg() {

		test = extent.createTest("User Reg Test");

		Assert.fail("Failing the test case");
		
		System.out.println("Executing User Reg Test");

	}

	@Test

	public void isSkip() {

		test = extent.createTest("Skip Test");

		throw new SkipException("Skipping the test case");

	}

	@AfterMethod

	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			String methodname = result.getMethod().getMethodName();

			String logText = "<b>" + "TEST CASE: -  " + methodname.toUpperCase() + "   FAILED" + "</b>";

			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);

			test.fail(m);

		} else if (result.getStatus() == ITestResult.SKIP) {

			String methodname = result.getMethod().getMethodName();

			String logText = "<b>" + "TEST CASE: -  " + methodname.toUpperCase() + "   SKIPPED" + "</b>";

			Markup m = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);

			test.skip(m);

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			String methodname = result.getMethod().getMethodName();

			String logText = "<b>" + "TEST CASE: -  " + methodname.toUpperCase() + "   PASSED" + "</b>";

			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);

			test.pass(m);

		}

	}

}
