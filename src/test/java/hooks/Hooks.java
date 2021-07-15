package hooks;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import util.Util;

public class Hooks extends Util {
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", projectDir + "\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
