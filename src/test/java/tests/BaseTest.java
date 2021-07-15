package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

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
	public void tearDown() {
		driver.quit();
	}
	
	@AfterSuite
	public void endTest() {
		extent.flush();
	}

}
