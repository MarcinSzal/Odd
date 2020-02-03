package pl.com.aay.pageObject;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.com.aay.seleniumEngine.AdvancedSeleniumEngine;
import pl.com.aay.testData.dataReaders.TestDataToLog;
import pl.com.aay.test_data.model.Login;
import pl.com.aay.test_data.model.Registration2;

import static pl.com.aay.pageObject.WaitPrep.waitFor;

public class PageObject1 extends AdvancedSeleniumEngine { // dotyczy g³ównej strony - górnego i bocznego menu,logowania oraz zalogowania


    public static final int TIME_OUT = 5;           // zmienna do okreslenia czasu wait'a

    @FindBy(xpath = "//a[@href='mercurysignon.php']")
    WebElement signON;

    @FindBy(xpath = "//a[@href='mercuryregister.php']")
    WebElement register;

    @FindBy(xpath = "//a[@href ='mercuryunderconst.php']")
    WebElement support;

    @FindBy(xpath = "//a[@href='mercuryunderconst.php']")
    WebElement contact;

    @FindBy(xpath = "//img[@src ='/images/banner2.gif']")
    WebElement banner;

    @FindBy(name ="username")   // poprawa
    WebElement userLogin;

    @FindBy(name = "password")  // poprawa
    WebElement password;

    @FindBy(xpath = "//input[@src='/images/btn_signin.gif']")
    WebElement signIn;

    @FindBy(xpath = "//a[@href='mercurywelcome.php']")
    WebElement homeLeftMenu;

    @FindBy(xpath = "//a[@href ='mercuryreservation.php']")
    WebElement flightsLeftMenu;

    @FindBy(xpath = "//a[@href='mercuryunderconst.php']")
    WebElement hotelsLeftMenu;

    @FindBy(xpath = "//a[@href='mercuryunderconst.php']")
    WebElement carRentalsLeftMenu;

    @FindBy(xpath = "//a[text() = 'Cruises']")
    WebElement cruisesLeftMenu;

    @FindBy(xpath = "//a[@href = 'mercuryunderconst.php']")
    WebElement destinationsLeftMenu;

    @FindBy(xpath = "//a[@href='mercuryunderconst.php']")
    WebElement vacationsLeftMenu;

    @FindBy(xpath = "//img[@src='/images/featured destination.gif']")
    WebElement arubaImage;


    public PageObject1(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public WebElement useDataPlogin (){
        wait.waitForElementToBeVisible(driver,userLogin,TIME_OUT);
        return userLogin;
    }

    public void logIn() {
        wait.waitForElementToBeVisible(driver, userLogin, TIME_OUT);
        userLogin.sendKeys(new TestDataToLog().userName);  // dane z klasy TestDataLog
    }

    public WebElement useDataPpassword(){
        wait.waitForElementToBeVisible(driver,password,TIME_OUT);
        return password;
    }

    public void logIn2() {
        wait.waitForElementToBeVisibleAndClickable(driver, password, TIME_OUT);
        password.sendKeys(new TestDataToLog().password);   // dane z klasy TestDataLog
    }
    public void signIn(){
        wait.waitForElementToBeClickable(driver,signIn,TIME_OUT);
        signIn.click();
    }

    public void logWithLogin(){

        wait.waitForElementToBeVisibleAndClickable(driver,userLogin,TIME_OUT);
        userLogin.sendKeys(new TestDataReading().readProperty().getLogin()); // odczyt z obiektu klasy TestDataReading, który odczytuje dane z pliku properties

        wait.waitForElementToBeVisibleAndClickable(driver,password,TIME_OUT);
        password.sendKeys(new TestDataReading().readProperty().getPassword());

        wait.waitForElementToBeVisibleAndClickable(driver,signIn,TIME_OUT);
        signIn.click();
    }
    public void logWithDataFromFile(){
        TestDataReading reader = new TestDataReading(); // obiekt klasy TestReading
        Registration2 regi = reader.readDataFromExcel(); // obiekt klasy Registartion2 sub klase Registration , usuniêto z niej niepotrzebny konstruktor
        Login login = new Login();

        login.setLogin(regi.userName);
        login.setPassword(regi.password);

        wait.waitForElementToBeVisible(driver,userLogin,TIME_OUT);
        userLogin.sendKeys(login.getLogin());

        wait.waitForElementToBeVisible(driver,password,TIME_OUT);
        password.sendKeys(login.getPassword());
    }
    public void upperMenu() {
        wait.waitForElementToBeVisibleAndClickable(driver, signON, TIME_OUT);
        signON.click();
    }
    public void upperMenu2() {
        wait.waitForElementToBeVisibleAndClickable(driver,register,TIME_OUT);
        register.click();
    }
    public void upperMenu3() {
        wait.waitForElementToBeVisibleAndClickable(driver,support,TIME_OUT);
        support.click();
    }
    public void upperMenu4() {
        wait.waitForElementToBeVisibleAndClickable(driver, contact, TIME_OUT);
        contact.click();
    }
    public void leftMenu() {
        wait.waitForElementToBeVisibleAndClickable(driver, homeLeftMenu, TIME_OUT);
        homeLeftMenu.click();
    }
    public void leftMenu2() {
        wait.waitForElementToBeVisibleAndClickable(driver, flightsLeftMenu, TIME_OUT);
        flightsLeftMenu.click();
    }
    public void leftMenu3() {
        wait.waitForElementToBeVisibleAndClickable(driver, hotelsLeftMenu, TIME_OUT);
        hotelsLeftMenu.click();
    }
    public void leftMenu4() {
        wait.waitForElementToBeVisibleAndClickable(driver, carRentalsLeftMenu, TIME_OUT);
        carRentalsLeftMenu.click();
    }
    public void leftMeny5() {
        wait.waitForElementToBeVisibleAndClickable(driver, cruisesLeftMenu, TIME_OUT);
        cruisesLeftMenu.click();
    }
    public void leftMenu6() {
        wait.waitForElementToBeVisibleAndClickable(driver, destinationsLeftMenu, TIME_OUT);
        destinationsLeftMenu.click();
    }
    public void leftMenu7() {
        wait.waitForElementToBeVisibleAndClickable(driver,vacationsLeftMenu,TIME_OUT);
        vacationsLeftMenu.click();
    }
    public void bannerCheck() {
        try {
            WebElement element = waitFor(driver).until(ExpectedConditions.visibilityOf(banner));
            System.out.println(element.isDisplayed());
        }
        catch (ElementNotVisibleException e){
            System.out.println("Element niewidoczny" + e.toString());
        }
    }

    public void imageArubaCheck() throws ElementNotVisibleException {
        WebElement element =waitFor(driver).until(ExpectedConditions.visibilityOf(arubaImage));
        System.out.println(element.isDisplayed());  // dodano
    }
}
