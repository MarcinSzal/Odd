package pl.com.aay.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pl.com.aay.seleniumEngine.*;

public class MainPage {
	
	SeleniumEngine selenium=null;
	
	private By bannerLocator = By.xpath("//img[@class='img-responsive']");
    private By contactUsLocator = By.xpath("//a[text()='Contact us']");
    private By signInLocator = By.xpath("//a[contains(text(),'Sign in')]");
    private By searchInputLocator = By.id("search_query_top");
    private By searchButtonLocator = By.xpath("//button[@type='submit']");
    private By cartLocator = By.xpath("//b[text()='Cart']");
    private By womenLocator = By.xpath("//a[text()='Women']");
    private By dressesLocator = By.xpath("//a[text()='Dresses']");
    private By tshirtLocator = By.xpath("//a[text()='T-shirts']");
    private By emailInputLocator = By.id("newsletter-input");
    private By emailButtonLocator = By.xpath("//button[@name='submitNewsletter']");
    
    public MainPage (WebDriver driver){
		selenium = new SeleniumEngine (driver);
	}
    
    public void openMainPage (){
    	selenium.openWebSite("http://automationpractice.com");
    }
    
    public void clickBunner (){
    	WebElement banner = selenium.findBy(bannerLocator);
    	selenium.wait.waitForElementToBeClickable(selenium.getWebDriver(), banner, 5);
    	banner.click ();
    	
    	//selenium.findBy(bannerLocator).click();
    }
    
    public void searchObject (){
    	WebElement searchInput = selenium.findBy(searchInputLocator);
    	WebElement searchButton = selenium.findBy(searchButtonLocator);
    	selenium.wait.waitForElementToBeClickable(selenium.getWebDriver(), searchInput, 5);
    	selenium.wait.waitForElementToBeClickable(selenium.getWebDriver(), searchButton, 5);
    	searchInput.sendKeys("TEST");;
    	searchButton.click();
    }
    
    public void openContactUs (){
    	WebElement contactUs = selenium.findBy(contactUsLocator);
    	selenium.wait.waitForElementToBeClickable(selenium.getWebDriver(), contactUs, 5);
    	contactUs.click();
    }
    
    public void openSignIn (){
    	WebElement signIn = selenium.findBy(signInLocator);
    	selenium.wait.waitForElementToBeClickable(selenium.getWebDriver(), signIn, 5);
    	signIn.click();
    }
    
    public void openAllMenu () {
    	WebElement women = selenium.findBy(womenLocator);
    	selenium.wait.waitForElementToBeClickable(selenium.getWebDriver(), women, 5);
    	women.click();	
    }
    
    public void goToCart (){
    	WebElement cart = selenium.findBy(cartLocator);
    	selenium.wait.waitForElementToBeClickable(selenium.getWebDriver(), cart, 5);
    	cart.click();
    }
    
    public void sendEmailNewsletter(){
    	WebElement emailInput = selenium.findBy(emailInputLocator);
    	WebElement emailButtonInput = selenium.findBy(emailButtonLocator);
    	
    	selenium.wait.waitForElementToBeClickable(selenium.getWebDriver(), emailInput, 5);
    	emailInput.sendKeys("test@test.pl");
    	emailButtonInput.click();
    }

}
