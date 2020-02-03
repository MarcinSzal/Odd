package pl.com.aay.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pl.com.aay.seleniumEngine.SeleniumEngine;

public class CartPage {
	
	SeleniumEngine selenium=null;
	
	private By alertLocator = By.xpath("//p[@class='alert alert-warning']");
	
	public CartPage (WebDriver driver){
		selenium = new SeleniumEngine (driver);
	}
	
	public void checkAllertCart (){
		WebElement alert = selenium.findBy(alertLocator);
		selenium.wait.waitForElementToBeVisible(selenium.getWebDriver(), alert, 5);
		System.out.println("ALERT TEXT: "+alert.getText());
	}

}
