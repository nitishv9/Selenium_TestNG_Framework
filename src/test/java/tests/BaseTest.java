package tests;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.Status;

import util.ExtentManager;
import util.Util;

public class BaseTest extends Util {
	
	@BeforeSuite
	public void startTest() {
		ExtentManager.createInstance();
	}
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", projectDir + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterMethod
	public static void endReport(ITestResult result) throws IOException {
		driver.quit();
			if(ITestResult.FAILURE!=result.getStatus()) {
				log.info("TEST CASE PASSED:" +  result.getMethod().getMethodName());
				logger.log(Status.PASS,  "Test Case Passed");
				log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			}
			else {
				log.info("TEST CASE FAILED:" +  result.getMethod().getMethodName());
				logger.log(Status.FAIL, "Test Case Failed");
				log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			}
		}
	
	@AfterSuite
	public void endTest() {
		extent.flush();
	}

}
