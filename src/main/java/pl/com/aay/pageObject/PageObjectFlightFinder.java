package pl.com.aay.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.com.aay.seleniumEngine.AdvancedSeleniumEngine;
import pl.com.aay.testData.dataReaders.TestDataToLog;

public class PageObjectFlightFinder extends AdvancedSeleniumEngine { // dotyczy wyszukiwania lotu - strona po zalogowaniu do serwisu - Flight Finder

    private static final int TIME_OUT = 5;       // zmienna do time out'a

    public PageObjectFlightFinder(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@name = 'tripType']")
    WebElement roundTripCheckBox;

    @FindBy(xpath = "//input[text() = 'one way']")
    WebElement oneWayCheckBox;

    @FindBy(xpath = "//select[@name ='passCount']/[1}")    // nie wiem czy dobrze
    WebElement passangersSelect;

    @FindBy(xpath = "//select[@value = '1']")        // nie wiem czy dobrze
    WebElement departingSelect;

    @FindBy(xpath ="//nput[@name = 'findFlights']")
    WebElement continueButton;

    public void clickRoundTrip(){
        wait.waitForElementToBeClickable(driver,roundTripCheckBox,TIME_OUT);
        roundTripCheckBox.click();
    }
    public void clickOneWayCheckBox(){
        wait.waitForElementToBeClickable(driver,oneWayCheckBox,TIME_OUT);
        oneWayCheckBox.click();
    }

    public void  passangerSelectClick(){
        wait.waitForElementToBeVisibleAndClickable(driver,passangersSelect,TIME_OUT);
        selectByIndex(passangersSelect,new TestDataToLog().indexNumber);              // select z AdvancedSelenium, dana z klasy TestData
    }

    public void departingSelectClick(){
        wait.waitForElementToBeClickable(driver,departingSelect,TIME_OUT);
        selectByValue(departingSelect,new DataFromJson().SelectValue);     // analogicznie, wartoœæ pobrana z Json
    }

    public void continueButtonClick(){
        wait.waitForElementToBeVisibleAndClick(driver,continueButton,TIME_OUT);
    }
}
