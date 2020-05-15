package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OTPVerificationSuccess {

	public WebDriver driver;

	By success_msg = By.xpath("//*[@class='notification__text']");
	By success_notif = By.xpath("//*[@class='notification notification--success']");
	By success_icon = By.xpath("//*[@class='notification__icon']");

	public OTPVerificationSuccess(WebDriver driver)
	{
		this.driver =driver;
	}

	public WebElement getSuccessNotification() {
		return driver.findElement(success_notif);
	}

	public WebElement getSuccessIcon() {
		return driver.findElement(success_icon);
	}
	
	public WebElement getSuccessMsg() {
		return driver.findElement(success_msg);
	}
}
