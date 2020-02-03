package pl.com.aay.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pl.com.aay.seleniumEngine.SeleniumEngine;

public class SignInPage {
	
	SeleniumEngine selenium=null;
	
	private By emailLocator = By.id("email_create");
	private By createAccountLocator = By.id("SubmitCreate");
	
	public SignInPage (WebDriver driver){
		selenium = new SeleniumEngine (driver);
	}
	
	public void createAccount (){
		WebElement email = selenium.findBy(emailLocator);
		selenium.wait.waitForElementToBeClickable(selenium.getWebDriver(), email, 5);
		email.sendKeys("test@test.pl");
		WebElement createAccount= selenium.findBy(createAccountLocator);
		createAccount.click();
	}

}
