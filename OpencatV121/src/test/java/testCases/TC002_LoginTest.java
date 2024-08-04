package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAcctPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

	@Test(groups={"Sanity","Master"})
	public void verify_login() {
		
		logger.info("##################  TC002_AccountRegistrationTest  ####################### ");
		
		//Home page
		try {
		logger.info("Clicked on Home Page");
		HomePage hp = new HomePage(driver);	
		hp.clickMyAccount();
		hp.clickLogin();
		
		
		//Login
		logger.info("On Login Page");
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogin();
		
		//MyAcct
		wait01();
		scroll();
		wait01();
		MyAcctPage myAcc = new MyAcctPage(driver);
		boolean targetPage =myAcc.isMyAccountPageExists();
//		Assert.assertEquals(targetPage, true, "Login Failed...");
		Assert.assertTrue(targetPage);
		
		myAcc.clickLogout();
		}
		catch(Exception e) {
			Assert.fail();
		}
		
		
		logger.info("##################  Finished TC002_AccountRegistrationTest  ####################### ");
	}
}
