package tests;


import org.testng.annotations.Test;

import pages.LoginPage;
import util.Util;

public class LoginTest extends BaseTest{
	
	
	@Test
	public void validLogin() {
		logger = extent.createTest("Verify login using valid credentials");
		Util.navigateLoginPage();
		logger.info("Navigated to login page");
		LoginPage page = new LoginPage(driver);
		page.loginApplication("tomsmith", "SuperSecretPassword!");
		logger.info("Valid User credentials added and clicked on login button");
		String msg = page.getFlashMsg();
		logger.info("Flash message extracted");
		assert msg.contains("You logged into a secure area");
		
	}
	
	@Test
	public void invalidLogin() {
		logger = extent.createTest("Verify login using invalid credentials");
		Util.navigateLoginPage();
		logger.info("Navigated to login page");
		LoginPage page = new LoginPage(driver);
		page.loginApplication("tomsmith", "invalid");
		logger.info("Invalid User credentials added and clicked on login button");
		String msg = page.getFlashMsg();
		logger.info("Flash message extracted");
		assert msg.contains("Your password is invalid!");
	}

}
