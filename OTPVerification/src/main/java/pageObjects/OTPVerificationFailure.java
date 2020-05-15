package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OTPVerificationFailure {

	public WebDriver driver;
	
	By fail_msg = By.xpath("//*[@class='notification__text']");
	By fail_notif = By.xpath("//*[@class='notification notification--error']");
	By fail_icon = By.xpath("//*[@class='notification__icon']");
	
	public OTPVerificationFailure(WebDriver driver)
	{
		this.driver =driver;
	}
	
	public WebElement getFailMsg()
	{
		return driver.findElement(fail_msg);
	}
	
	public WebElement getFailNotification()
	{
		return driver.findElement(fail_notif);
	}
	
	public WebElement getFailIcon()
	{
		return driver.findElement(fail_icon);
	}
}
