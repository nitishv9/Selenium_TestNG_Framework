package tests;

import java.io.IOException;

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
		browserSetUp();
	}
	
	@BeforeMethod
	public void setUp() {

	}
	
	@AfterMethod
	public static void endReport(ITestResult result) throws IOException {
			if(ITestResult.FAILURE!=result.getStatus()) {
				log.info("TEST CASE PASSED:" +  result.getMethod().getMethodName());
				logger.log(Status.PASS,  "Test Case Passed");
				log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			}
			else {
				log.info("TEST CASE FAILED:" +  result.getMethod().getMethodName());
				logger.log(Status.FAIL, "Test Case Failed");
				String screenshotPath = Util.getScreenShot(driver, result.getName());
				logger.fail("Test case is failed Screenshot is attached below " + logger.addScreenCaptureFromPath(screenshotPath));
				log.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			}
		}
	
	@AfterSuite
	public void endTest() {
		extent.flush();
		driver.quit();
	}

}
