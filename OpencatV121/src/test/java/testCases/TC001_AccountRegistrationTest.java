package testCases;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegestrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression", "Master"})
	public void verift_account_registration() throws InterruptedException
	{
		logger.info("##################  TC001AccountRegistrationTest  ####################### ");
		
		try {
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicking on MyAcct link...");
		hp.clickRegister();
		logger.info("Clicking on Register link...");
		
		AccountRegestrationPage regpage = new AccountRegestrationPage(driver);
	
		logger.info("Providing Customer details.....");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		
		regpage.setEmail(randomeString()+"@gmail.com");
		regpage.setPassword(randomeAlphaNumeric());
		
		
		scroll();
		wait01();
		
		regpage.setPolicyBtn();
		regpage.setContinueBtn();
		
		String confmsg = regpage.getConfirmationMsg();
		
		if(confmsg.equals("Your Account Has Been Created!")) {
			Assert.assertTrue(true);
		}
		else {
			logger.error("Test Failed......");
			logger.debug("Debug logs...");
			Assert.assertTrue(false);
		}

		}
		catch(Exception e) {
			
			Assert.fail();
		}
		
		logger.info("##################  Finished TC001AccountRegistrationTest  ####################### ");
	}
	
	
	
	
}
