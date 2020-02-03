package pl.com.aay.pageObject;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pl.com.aay.seleniumEngine.AdvancedSeleniumEngine;
import pl.com.aay.testData.dataReaders.TestDataReader;
import pl.com.aay.test_data.model.Registration;

public class PageObject3Register extends AdvancedSeleniumEngine { // dotyczy fomularza rejestracji do serwisu - zak³adka Register


    private static final int TIME_OUT = 5;

    public PageObject3Register(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement firstNameField;

    @FindBy(xpath = "//input[@name='firstName']")
    WebElement lastNameField;

    @FindBy(xpath = "//input[@name='phone']")
    WebElement phoneField;

    @FindBy(xpath = "//input[@name='userName']")
    WebElement emailField;

    @FindBy(xpath = "//input[@name='address1']")
    WebElement addressField;

    @FindBy(xpath = "//input[@name='city']")
    WebElement cityField;

    @FindBy(xpath = "//input[@name='state']")
    WebElement stateProvinceField;

    @FindBy(xpath = "//input[@name='postalCode']")
    WebElement postalCodeField;

    @FindBy(xpath = "//input[@name='email']")
    WebElement userNameField;

    @FindBy(xpath = "//input[@name='password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@name='confirmPassword']")
    WebElement confirmPasswordField;

    @FindBy(xpath = "//input[@name='register']")
    WebElement submitButton;

    @FindBy(name = "select")     // poprawa na "name
    WebElement countryField;

    @FindBy(xpath = "//img[@src='/images/masts/mast_register.gif']")
    WebElement registerImg;


    public void registerImgVisible() {
        wait.waitForElementToBeVisible(driver,registerImg,TIME_OUT);
        boolean b = registerImg.isDisplayed();
        System.out.println(b);
        }

    public void registerToFlight() {
        DataFromJson registration = new DataFromJson();

        wait.waitForElementToBeVisible(driver,firstNameField,TIME_OUT);
        firstNameField.sendKeys(registration.FirstName);

        wait.waitForElementToBeVisible(driver,firstNameField,TIME_OUT);
        firstNameField.sendKeys(registration.LastName);

        wait.waitForElementToBeVisible(driver,phoneField,TIME_OUT);
        phoneField.sendKeys(registration.Phone);

        wait.waitForElementToBeVisible(driver,emailField,TIME_OUT);
        emailField.sendKeys(registration.Email);

        wait.waitForElementToBeVisible(driver,addressField,TIME_OUT);
        addressField.sendKeys(registration.Address);

        wait.waitForElementToBeVisible(driver,cityField,TIME_OUT);
        cityField.sendKeys(registration.City);

        wait.waitForElementToBeVisible(driver,stateProvinceField,TIME_OUT);
        stateProvinceField.sendKeys(registration.StateProvince);

        wait.waitForElementToBeVisible(driver,postalCodeField,TIME_OUT);
        postalCodeField.sendKeys(registration.PostalCode);

        wait.waitForElementToBeVisibleAndClickable(driver,countryField,TIME_OUT);
        selectByValue(countryField,registration.SelectValue);

        wait.waitForElementToBeVisible(driver,userNameField,TIME_OUT);
        userNameField.sendKeys(registration.UserName);

        wait.waitForElementToBeVisible(driver,passwordField,TIME_OUT);
        passwordField.sendKeys(registration.Password);

        wait.waitForElementToBeVisible(driver,confirmPasswordField,TIME_OUT);
        confirmPasswordField.sendKeys(registration.ConfirmP);

        wait.waitForElementToBeVisibleAndClick(driver,submitButton,TIME_OUT);
    }
}

