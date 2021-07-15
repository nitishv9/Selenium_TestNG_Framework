package util;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Util {
	
	public static String projectDir= System.getProperty("user.dir");
	public static WebDriver driver;
	public static String url = "https://the-internet.herokuapp.com/login";
	public static ExtentReports extent;
    public static String reportFileName = "Test-Automaton-Report"+".html";
    public static String fileSeperator = System.getProperty("file.separator");
    public static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport";
    public static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
    public static ExtentTest logger;
    
    
	public static void navigateLoginPage() {
		driver.get(url);
	}
	

}
