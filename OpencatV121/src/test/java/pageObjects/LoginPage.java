package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement emailId;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement pswd;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement loginBtn;
	
	public void setEmail(String email) {
		emailId.sendKeys(email);
	}
	
	public void setPassword(String password) {
		pswd.sendKeys(password);
	}
	
	public void clickLogin() {
		loginBtn.click();
	}
	

}
