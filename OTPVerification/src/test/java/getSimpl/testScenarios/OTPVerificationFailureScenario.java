package getSimpl.testScenarios;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import getSimpl.base.Base;
import getSimpl.webServices.OTPGenerationAPI;
import pageObjects.LoginPage;
import pageObjects.OTPVerificationFailure;

public class OTPVerificationFailureScenario extends Base {

	@BeforeTest
	public void intialize() throws IOException
	{
		// Instantiating a driver and accessing the URL
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test(priority = 0)
	public void OTPFailVerification() throws IOException, InterruptedException {

		// Creating an object for LoginPage to access the token
		LoginPage lp = new LoginPage(driver);

		String tok = lp.getToken(driver);

		// Sending the token to OTP generation API to get the OTP
		OTPGenerationAPI otpAPI = new OTPGenerationAPI();
		String otp = otpAPI.OTPGeneration(tok);

		// Invalid OTP entered for Failed message verification
		lp.getOTP_in().sendKeys(otp+"A");

		// OTP Submitted
		lp.getLoginSubmit().click();

		//Message Validation
		OTPVerificationFailure vs = new OTPVerificationFailure(driver);
		Assert.assertEquals(vs.getFailMsg().getText(), "Verification Failed!");
		Assert.assertTrue(vs.getFailNotification().isDisplayed());
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}

}
