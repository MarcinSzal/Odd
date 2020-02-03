package pl.com.aay.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.com.aay.seleniumEngine.AdvancedSeleniumEngine;
import pl.com.aay.testData.dataReaders.TestDataReader;
import pl.com.aay.testData.dataReaders.TestDataToLog;
import pl.com.aay.test_data.model.Registration;
import pl.com.aay.test_data.model.Registration2;


public class PageObjectFlightReserv extends AdvancedSeleniumEngine { // dotyczy procesu rezerwacji lotu - BOOK A FLIGHT

    private final static TestDataReading reader = new TestDataReading();
    private static Registration2 re = new Registration2();
    private static final int TIME_OUT = 5;

    public PageObjectFlightReserv(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='passFirst0']")
    WebElement firsTName;

    @FindBy(xpath = "//input[@name = 'pastLast0']")
    WebElement lasTName;

    @FindBy(xpath = "//select[@name ='pass.0.meal'] [value = '1']")     // zmiana
    WebElement mealSelect;

    @FindBy(xpath = "//select[@name='creditCard'][value = '1']")            // zmina
    WebElement cardTypeSelect;

    @FindBy(xpath = "//input[@type = 'text']")
    WebElement number;

    @FindBy(xpath ="select[@name ='cc_exp_dt_mn'][option ='1']")        //analogicznie
    WebElement expiration1Select;

    @FindBy(xpath ="//select[@name ='cc_exp_dt_yr'][option ='1']")          // analogiczne
    WebElement expiration1Select2;

    @FindBy(xpath ="//input[@name ='cc_mid_name']")
    WebElement middleNameCard;

    @FindBy(xpath = "//input[@name='cc_last_name']")
    WebElement lastNameCard;

    @FindBy(xpath ="//input[@type='checkbox']")
    WebElement ticketLessCheckBox;

    @FindBy(xpath = "//input[@name='billAddress1']")
    WebElement billingAddress;

    @FindBy(xpath ="//input[@name='billCity']")
    WebElement  billingCity;

    @FindBy(xpath = "//input[@name='billCity']")
    WebElement billingState;

    @FindBy(xpath = "//input[@name='billZip']")
    WebElement billingPostalCode;

    @FindBy(xpath = "//select[@name='billCountry']/[1]")            // nie wiem czy dobra zmiana
    WebElement billingCountrySelect;

    @FindBy(xpath = "input[@value ='checkbox']")
    WebElement sameAsBillingAddressCheckBox;

    @FindBy(xpath = "//input[@src ='/images/forms/purchase.gif']")
    WebElement securePurchaseImg;

    public void passangersName() {
        re = reader.readDataFromExcel();
        wait.waitForElementToBeVisible(driver,firsTName,TIME_OUT);
        firsTName.sendKeys(re.firstName);
        wait.waitForElementToBeVisible(driver,lasTName,TIME_OUT);
        lasTName.sendKeys(re.lastName);
    }
    public void mealSelCheck() {
        wait.waitForElementToBeClickable(driver,mealSelect,TIME_OUT);
        Select select = new Select(mealSelect);
        select.selectByVisibleText(new TestDataToLog().selectWord);         // .....
    }
    public void creditCardSelect() {
        wait.waitForElementToBeClickable(driver,cardTypeSelect,TIME_OUT);
        Select select = new Select(cardTypeSelect);
        select.selectByVisibleText(new TestDataToLog().selectVisa);             //...
    }
    public void numberCheck() {
        wait.waitForElementToBeVisible(driver,number,TIME_OUT);
        number.sendKeys("90090900909000");
    }
    public void expirationSelects() {
        wait.waitForElementToBeClickable(driver,expiration1Select,TIME_OUT);
        Select select = new Select(expiration1Select);
        select.deselectByIndex(2);

        wait.waitForElementToBeClickable(driver,expiration1Select2,TIME_OUT);
        Select select1 = new Select(expiration1Select2);
        select1.selectByIndex(new TestDataToLog().indexNumber);             //........
    }
    public void firstNameCheck() {
        wait.waitForElementToBeVisible(driver,expiration1Select2,TIME_OUT);
        expiration1Select2.sendKeys(re.firstName);
    }

    public void middleNameCheck() {
        wait.waitForElementToBeVisible(driver,middleNameCard,TIME_OUT);
        middleNameCard.sendKeys(re.firstName);
    }

    public void lastNameCheck() {
        wait.waitForElementToBeVisible(driver,lastNameCard,TIME_OUT);
        lastNameCard.sendKeys(re.lastName);
    }

    public void ticketLessCheckBox() {
        wait.waitForElementToBeVisibleAndClick(driver,ticketLessCheckBox,TIME_OUT);
    }

    public void addressCheck() {
        wait.waitForElementToBeVisible(driver,billingAddress,TIME_OUT);
        billingAddress.sendKeys(new DataFromJson().Address);    // .....
    }

    public void cityCheck() {
        wait.waitForElementToBeVisible(driver,billingCity,TIME_OUT);
        billingCity.sendKeys(new DataFromJson().City);          //......
    }

    public void stateCheck(){
        wait.waitForElementToBeVisible(driver,billingState,TIME_OUT);
        billingState.sendKeys(new DataFromJson().City);     //......
    }

    public void postalCodecheck(){
        wait.waitForElementToBeVisible(driver,billingPostalCode,TIME_OUT);
        billingPostalCode.sendKeys(new DataFromJson().PostalCode);      //..........
    }

    public void countrySelectCheck() {

        wait.waitForElementToBeClickable(driver,billingCountrySelect,TIME_OUT);
        Select select = new Select(billingCountrySelect);
        select.selectByValue(new TestDataToLog().CountryName);    // dane z klasy TestData...
    }

    public void sameAsBilling() {
        wait.waitForElementToBeVisibleAndClick(driver,sameAsBillingAddressCheckBox,TIME_OUT);
    }

    public void securePurchase(){
        wait.waitForElementToBeVisibleAndClick(driver,securePurchaseImg,TIME_OUT);
    }


}
