package tests;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
	public static String url = "https://the-internet.herokuapp.com/login";
	
	@Test
	public void validLogin() {
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
		String msg = driver.findElement(By.id("flash")).getText();
		assert msg.contains("You logged into a secure area");
		
	}
	
	@Test
	public void invalidLogin() {
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys("tomsmith");
		driver.findElement(By.id("password")).sendKeys("invalid!");
		driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
		String msg = driver.findElement(By.id("flash")).getText();
		assert msg.contains("Your password is invalid!");
	}

}
