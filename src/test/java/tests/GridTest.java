package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridTest {
	
	public static void main(String[] args) throws MalformedURLException {
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		WebDriver driver;
		driver = new RemoteWebDriver(new URL("http://localhost:5566/wd/hub"),cap);
		driver.get("https://www.google.co.in");
		
	}

}
