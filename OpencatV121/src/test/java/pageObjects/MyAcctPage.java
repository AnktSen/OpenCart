package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAcctPage extends BasePage {

	public MyAcctPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@id='content']//h2[text()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[@class='list-group-item'][normalize-space()='Logout']")
	WebElement logOut;
	
	public boolean isMyAccountPageExists() {
		try {
		return (myAccount.isDisplayed());
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void clickLogout() {
		logOut.click();
	}

}
