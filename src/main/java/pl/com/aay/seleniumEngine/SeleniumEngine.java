package pl.com.aay.seleniumEngine;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class SeleniumEngine {
	
	public WebDriver driver;
	public Actions actions;
	public WaitForElement wait;
	
	public SeleniumEngine (WebDriver driver){
		this.driver=driver;
		actions = new Actions(driver);
		wait = new WaitForElement ();
	}
	
	//Metody z modu³u PageObject 
	
	public WebElement findBy (By by){
		return driver.findElement(by);
	}
	
	public void selectByText (WebElement element, String text){
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void selectByIndex(WebElement element, Integer index){
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectByValue(WebElement element, String value){
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
	
	
	/*
	 * 
	 * Metody z modu³u 1 i 2
	 * 
	 * 
	 */
	
	//metody webdrivera
	
	public WebDriver getWebDriver (){
		return driver; 
	}
	
	public WaitForElement getWaitForElement (){
		return wait;
	}
	
	public void driverQuit (){
		driver.quit();
	}
	
	public void openWebSite (String url){
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	public String getUrl (){
		return driver.getCurrentUrl();
	}
	
	public void refresh (){
		driver.navigate().refresh(); 
	}
	
	public void back (){
		driver.navigate().back(); 
	}
	
	public void forward (){
		driver.navigate().forward();
	}

	
	// metody znajdujace element
	public WebElement findElement (String lokatorName, String lokatorString){
		WebElement element = null;
		
		switch (lokatorName) {
			case "id":
				element = driver.findElement(By.id(lokatorString));
				break;
			case "name":
				element = driver.findElement(By.name(lokatorString));
				break;
			case "tagName":
				element = driver.findElement(By.tagName(lokatorString));
				break;
			case "linkText":
				element = driver.findElement(By.linkText(lokatorString));
				break;
			case "partialLinkText":
				element = driver.findElement(By.partialLinkText(lokatorString));
				break;
			case "className ":
				element = driver.findElement(By.className (lokatorString));
				break;
	        case "xpath":
	        	element = driver.findElement(By.xpath(lokatorString));
	            break;
	        case "cssSelector":
	        	element = driver.findElement(By.cssSelector(lokatorString));
	            break;
	        default:
	            System.out.println("Z³y lokator");
		}
		
		return element;
	}
	
	public List<WebElement> findElements(String lokatorName, String lokatorString){
		List<WebElement> elementList = null;
		
		switch (lokatorName) {
			case "id":
				elementList = driver.findElements(By.id(lokatorString));
				break;
			case "name":
				elementList = driver.findElements(By.name(lokatorString));
				break;
			case "tagName":
				elementList = driver.findElements(By.tagName(lokatorString));
				break;
			case "linkText":
				elementList = driver.findElements(By.linkText(lokatorString));
				break;
			case "partialLinkText":
				elementList = driver.findElements(By.partialLinkText(lokatorString));
				break;
			case "className ":
				elementList = driver.findElements(By.className (lokatorString));
				break;
	        case "xpath":
	        	elementList = driver.findElements(By.xpath(lokatorString));
	            break;
	        case "cssSelector":
	        	elementList = driver.findElements(By.cssSelector(lokatorString));
	            break;
	        default:
	            System.out.println("Z³y lokator");
		}
		
		return elementList;
	}
	
	// metody klasy webelement
	
	public void checkElementClick(String lokatorName, String lokatorString){
		WebElement element = findElement ( lokatorName,  lokatorString);
		element.click();
	}
	
	public void checkElementClear(String lokatorName, String lokatorString){
		WebElement element = findElement ( lokatorName,  lokatorString);
		element.clear();
	}
	
	public String checkElementText(String lokatorName, String lokatorString){
		WebElement element = findElement ( lokatorName,  lokatorString);
		return element.getText();
	}
	
	public String checkElementAttribute(String lokatorName, String lokatorString,String attribute){
		WebElement element = findElement ( lokatorName,  lokatorString);
		return element.getAttribute(attribute);
	}
	
	public void checkElementSendKey (String lokatorName, String lokatorString,String text){
		WebElement element = findElement ( lokatorName,  lokatorString);
		element.sendKeys(text);
	}
	
	// metody klasy Action
	
	//http://the-internet.herokuapp.com/context_menu
	public void checkContentClick (String lokatorName, String lokatorString){
		WebElement element = findElement ( lokatorName,  lokatorString);
		actions.contextClick(element).perform();
	}
	
	public void checkDoubleClick (String lokatorName, String lokatorString){
		WebElement element = findElement ( lokatorName,  lokatorString);
		actions.doubleClick(element).perform();
	}
	
	public void checkClickAndHold (String lokatorName, String lokatorString){
		WebElement element = findElement ( lokatorName,  lokatorString);
		actions.clickAndHold(element).perform();
	}
	
	public void checkMoveTo (String lokatorName, String lokatorString){
		WebElement element = findElement ( lokatorName,  lokatorString);
		actions.moveToElement(element).perform();
	}
	
	public void moveTo (WebElement element){
		actions.moveToElement(element).perform();
	}
	
	//http://the-internet.herokuapp.com/drag_and_drop
	public void checkDragAndDrop (WebElement elementSource, WebElement elementTarget){
		actions.dragAndDrop(elementSource, elementTarget).build().perform();
	}
	
	public void dragAndDrop (WebElement element){
		actions.dragAndDropBy(element, 30, 0).build().perform();		
	}
	
	public void dragAndDrop (WebElement element, int x, int y){
		actions.dragAndDropBy(element, x, y).build().perform();		
	}
	
	// metody klasy select
	
	public void selectByText (String lokatorName, String lokatorString, String text){
		WebElement element = findElement ( lokatorName,  lokatorString);
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
	
	public void selectByIndex(String lokatorName, String lokatorString, Integer index){
		WebElement element = findElement ( lokatorName,  lokatorString);
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	
	public void selectByValue(String lokatorName, String lokatorString, String value){
		WebElement element = findElement ( lokatorName,  lokatorString);
		Select select = new Select(element);
		select.selectByValue(value);
	}
	
}
