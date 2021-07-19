package tests;

import org.testng.annotations.Test;

import pages.StatusCodePage;

public class StatusCodeTest extends BaseTest {
	
	
	@Test
	public void statusCodeAs200() {
		initializeTest("Verify user should get 200 status code after clicking 200");
		navigateStatusCodePage();
		write_log("Navigated to Status Code page");
		StatusCodePage page = new StatusCodePage(driver);
		page.clickStatusCode("200");
		write_log("Clicked on 200 Button");
		String msg = page.getMsg();
		write_log("Output message extracted");
		assert msg.contains("200");	
	}
	
	@Test
	public void statusCodeAs404() {
		initializeTest("Verify user should get 404 status code after clicking 404");
		navigateStatusCodePage();
		write_log("Navigated to Status Code page");
		StatusCodePage page = new StatusCodePage(driver);
		page.clickStatusCode("404");
		write_log("Clicked on 404 Button");
		String msg = page.getMsg();
		write_log("Output message extracted");
		assert msg.contains("404");	
	}
	
	@Test
	public void statusCodeAs301() {
		initializeTest("Verify user should get 301 status code after clicking 301");
		navigateStatusCodePage();
		write_log("Navigated to Status Code page");
		StatusCodePage page = new StatusCodePage(driver);
		page.clickStatusCode("301");
		write_log("Clicked on 301 Button");
		String msg = page.getMsg();
		write_log("Output message extracted");
		assert msg.contains("301");	
	}
	
	@Test
	public void statusCodeAs500() {
		initializeTest("Verify user should get 500 status code after clicking 500");
		navigateStatusCodePage();
		write_log("Navigated to Status Code page");
		StatusCodePage page = new StatusCodePage(driver);
		page.clickStatusCode("500");
		write_log("Clicked on 500 Button");
		String msg = page.getMsg();
		write_log("Output message extracted");
		assert msg.contains("500");	
	}

}
