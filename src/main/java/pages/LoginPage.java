package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(id="password")
	private WebElement password;
	
	@FindBy(xpath="//i[contains(text(),'Login')]")
	private WebElement loginBtn;
	
	@FindBy(id="flash")
	private WebElement flashMsg;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUsername(String value) {
		username.sendKeys(value);
	}
	
	public void setPassword(String value) {
		password.sendKeys(value);
	}
	
	public void clickLoginBtn() {
		loginBtn.click();
	}
	
	public String getFlashMsg() {
		return flashMsg.getText();
	}
	
	public void loginApplication(String username,String password) {
		setUsername(username);
		setPassword(password);
		clickLoginBtn();
	}

}
