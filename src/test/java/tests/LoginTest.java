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
		page.setUsername("tomsmith");
		logger.info("Username added");
		page.setPassword("SuperSecretPassword!");
		logger.info("Password added");
		page.clickLoginBtn();
		logger.info("Clicked on login Button");
		String msg = page.getFlashMsg();
		assert msg.contains("You logged into a secure area");
		
	}
	
	@Test
	public void invalidLogin() {
		logger = extent.createTest("Verify login using invalid credentials");
		Util.navigateLoginPage();
		LoginPage page = new LoginPage(driver);
		page.setUsername("tomsmith");
		logger.info("Username added");
		page.setPassword("invalid");
		logger.info("Password added");
		page.clickLoginBtn();
		logger.info("Clicked on login Button");
		String msg = page.getFlashMsg();
		assert msg.contains("Your password is invalid!");
	}

}
