package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By login = By.xpath("//*[@class='button button--blue button--header js-analytics-click']");
	By loginForm = By.xpath("//*[@id='form-login']");
	By token = By.xpath("//*[@name='secret_token']");
	By otp_in = By.xpath("//*[@id='otp_input']");
	By login_submit = By.xpath("//*[@name='commit' and @type='submit']");
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver =driver;
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	public WebElement getLoginForm()
	{
		return driver.findElement(loginForm);
	}
	
	public WebElement token()
	{
		return driver.findElement(token);
	}
	
	public WebElement getOTP_in()
	{
		return driver.findElement(otp_in);
	}
	
	public WebElement getLoginSubmit()
	{
		return driver.findElement(login_submit);
	}
	
	public String getToken(WebDriver driver){
		String token = null;
		try {
			token = token().getAttribute("value");
		} catch (Exception e) {
			System.out.println("Token not displayed");
		}
		return token;
	}

}
