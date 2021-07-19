package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StatusCodePage {
	
	WebDriver driver;
	
	@FindBy(linkText="200")
	private WebElement status_code_200;
	
	@FindBy(linkText="301")
	private WebElement status_code_301;
	
	@FindBy(linkText="404")
	private WebElement status_code_404;
	
	@FindBy(linkText="500")
	private WebElement status_code_500;
	
	@FindBy(tagName = "p")
	private WebElement msg;
	
	public StatusCodePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickStatusCode(String value) {
		if(value == "200") {
			status_code_200.click();
		}
		else if(value == "301") {
			status_code_301.click();
		}
		else if(value == "404") {
			status_code_404.click();
		}
		else if(value == "500") {
			status_code_500.click();
		}
		else {
			System.out.println("Invalid status code. Cannot be clicked.");
		}
	}
	
	public String getMsg() {
		return msg.getText();
	}

}
