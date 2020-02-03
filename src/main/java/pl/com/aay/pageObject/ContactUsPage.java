package pl.com.aay.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pl.com.aay.seleniumEngine.SeleniumEngine;

public class ContactUsPage {
	
	SeleniumEngine selenium=null;
	
	private By subjectLocator = By.id("id_contact");
    private By emailLocator = By.id("email");
    private By messegesLocator = By.id("message");
    private By sendLocator = By.xpath("//button[@type='submit']");
    
    public ContactUsPage (WebDriver driver){
		selenium = new SeleniumEngine (driver);
	}
    
    public void sendEmailToContact (){
    	WebElement subject = selenium.findBy(subjectLocator);
    	WebElement email = selenium.findBy(emailLocator);
    	WebElement messeges = selenium.findBy(messegesLocator);
    	WebElement send = selenium.findBy(sendLocator);
    	
    	selenium.wait.waitForElementToBeClickable(selenium.getWebDriver(), subject, 5);
    	selenium.selectByValue(subject, "1");
    	email.sendKeys("test@test.pl");
    	messeges.sendKeys("Proszê o kontakt");
    	send.click();
    }
    
}
