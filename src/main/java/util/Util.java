package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Util {
	
	public static String projectDir= System.getProperty("user.dir");
	public static WebDriver driver;
	public static String configPropFile = "./src/main/resources/config.properties";
	public static ExtentReports extent;
    public static String reportFileName = "Test-Automaton-Report"+".html";
    public static String fileSeperator = System.getProperty("file.separator");
    public static String reportFilepath = System.getProperty("user.dir") +fileSeperator+ "TestReport";
    public static String reportFileLocation =  reportFilepath +fileSeperator+ reportFileName;
    public static ExtentTest logger;
    protected static Logger log = LogManager.getLogger(Util.class);
    
    public static void browserSetUp() {
    	System.setProperty("webdriver.chrome.driver", projectDir + "\\drivers\\chromedriver.exe");
    	if(getProp("headless").toLowerCase().equals("true")) {
    		ChromeOptions options = new ChromeOptions();
    		options.addArguments("--headless");
    		driver = new ChromeDriver(options);
    	}
    	else {
    		driver = new ChromeDriver();
    	}
    	driver.manage().window().maximize();
    }
    
	public static void navigateLoginPage() {
		driver.get(getProp("loginUrl"));
	}
	
	public static void navigateStatusCodePage() {
		driver.get(getProp("statusCodeUrl"));
	}
	
	
	public void initializeTest(String msg) {
		logger = extent.createTest(msg);
		log.info("Test Execution started: " + msg);
	}
	
	public void write_log(String msg) {
		log.info(msg);
		logger.info(msg);
	}
	
	public static String getScreenShot(WebDriver driver,String screenshotName) throws IOException {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = projectDir + "/Current Screenshots/" + screenshotName + "_" + dateName + ".png";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}
	
	public static String getProp(String propertyName){
		try{
		Properties prop= new Properties();
		FileInputStream file=new FileInputStream(configPropFile);
		prop.load(file);
		return prop.getProperty(propertyName);
	}
		catch(Exception e){
			System.out.println("Config File not found");
			return null;
		}
	}
}
