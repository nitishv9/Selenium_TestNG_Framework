package tests;


import org.testng.annotations.Test;

import pages.LoginPage;
import util.Util;

public class LoginTest extends BaseTest{
	
	
	@Test
	public void validLogin() {
		initializeTest("Verify login using valid credentials");
		Util.navigateLoginPage();
		write_log("Navigated to login page");
		LoginPage page = new LoginPage(driver);
		page.loginApplication("tomsmith", "SuperSecretPassword!");
		write_log("Valid User credentials added and clicked on login button");
		String msg = page.getFlashMsg();
		write_log("Flash message extracted");
		assert msg.contains("You logged into a secure area");
		
	}
	

	
	@Test
	public void invalidLogin() {
		initializeTest("Verify login using invalid credentials");
		Util.navigateLoginPage();
		write_log("Navigated to login page");
		LoginPage page = new LoginPage(driver);
		page.loginApplication("tomsmith", "invalid");
		write_log("Invalid User credentials added and clicked on login button");
		String msg = page.getFlashMsg();
		write_log("Flash message extracted");
		assert msg.contains("Your password is invalid!!");
	}

}
