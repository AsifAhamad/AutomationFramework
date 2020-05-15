package getSimpl.testScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import getSimpl.base.Base;
import pageObjects.LoginPage;

public class LoginPageValidation extends Base {	
	
	public LoginPage lp;
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void LoginPageUIValidation() throws IOException {
		// Verifying the login page UI
		lp = new LoginPage(driver);
		Assert.assertEquals(lp.getLogin().getText(), "LOGIN");
		Assert.assertTrue(lp.getLoginForm().isDisplayed());
		Assert.assertTrue(lp.getLoginSubmit().isDisplayed());
		Assert.assertTrue(lp.getOTP_in().isDisplayed());
	}

	@AfterTest
	public void teardown() {
		driver.quit();
	}

}