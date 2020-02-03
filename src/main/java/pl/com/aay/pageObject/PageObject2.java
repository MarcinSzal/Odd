package pl.com.aay.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pl.com.aay.seleniumEngine.AdvancedSeleniumEngine;
import pl.com.aay.testData.dataReaders.TestDataToLog;

import static org.junit.Assert.assertTrue;
import static pl.com.aay.pageObject.WaitPrep.waitFor;

public class PageObject2 extends AdvancedSeleniumEngine {       // dotyczly procesu logowania

    public static final int TIME_OUT = 5;           // .....

    public PageObject2(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@name ='userName']")
    WebElement userNameField;

    @FindBy(xpath = "//input[@name ='password']")
    WebElement passwordField;

    @FindBy(xpath = "//input[@name ='login']")
    WebElement submit;

    @FindBy(name = "b")                         // poprawa
    WebElement passwordtext;

    public void userName() {
        wait.waitForElementToBeVisible(driver,userNameField,TIME_OUT);
        userNameField.sendKeys(new TestDataToLog().userName);    // dane do logowania z klasy  TestDataToLog
    }
    public void passWord() {
        wait.waitForElementToBeVisible(driver,passwordField,TIME_OUT);
        passwordField.sendKeys(new TestDataToLog().password);   // analogicznie
    }

    public void setUserNameTextCheck() {   // dotyczy tekstu UserName               // dodano asercje
        wait.waitForElementToBeVisible(driver,userNameField,TIME_OUT);
        boolean b = userNameField.isDisplayed();
        assertTrue(b);
    }

    public void setPasswordCheck() { // dotyczy tekstu Password , metoda waitFor wykorzystuje Fluent wait z klasy WaitPrep
        try{
            WebElement element = waitFor(driver).until(ExpectedConditions.visibilityOf(passwordtext));
            System.out.println(element.getText());
        }
        catch(Exception e){ e.printStackTrace();}
    }

    public void checkImg(){ // dotyczy obrazka , analogicznie powinny byc zrobione pozosta³e z tagName 'img'
        wait.waitForElementAttachDOM(driver,"/html/body/div/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/p[1]/img",TIME_OUT);
    }

    public void submitButton() {
        wait.waitForElementToBeVisibleAndClick(driver,submit,TIME_OUT);
    }
    }



