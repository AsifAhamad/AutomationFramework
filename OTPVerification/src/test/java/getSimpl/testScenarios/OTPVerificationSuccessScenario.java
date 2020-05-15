package getSimpl.testScenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import getSimpl.base.Base;
import getSimpl.webServices.OTPGenerationAPI;
import pageObjects.LoginPage;
import pageObjects.OTPVerificationSuccess;

public class OTPVerificationSuccessScenario extends Base {

	@BeforeTest
	public void intialize() throws IOException
	{
		// Instantiating a driver and accessing the URL
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test(priority = 0)
	public void OTPSuccessVerification() throws IOException, InterruptedException {

		// Creating an object for LoginPage to access the token
		LoginPage lp = new LoginPage(driver);
		
		String tok = lp.getToken(driver);

		// Sending the token to OTP generation API to get the OTP
		OTPGenerationAPI otpAPI = new OTPGenerationAPI();
		String otp = otpAPI.OTPGeneration(tok);

		// OTP entered
		lp.getOTP_in().sendKeys(otp);

		// OTP Submitted
		lp.getLoginSubmit().click();

		// OTP Verification or Authentication
		OTPVerificationSuccess vs = new OTPVerificationSuccess(driver);
		Assert.assertEquals(vs.getSuccessMsg().getText(), "Verification Succeeded!");
		Assert.assertTrue(vs.getSuccessNotification().isDisplayed());
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
