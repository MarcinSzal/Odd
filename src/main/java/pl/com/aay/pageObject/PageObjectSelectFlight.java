package pl.com.aay.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.com.aay.seleniumEngine.AdvancedSeleniumEngine;

public class PageObjectSelectFlight extends AdvancedSeleniumEngine {

    private static final int TIME_OUT = 5;          // ...

    public PageObjectSelectFlight(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "inFlight")              // ...... zmiana z xpath na name
    WebElement selectCheckBox1;

    @FindBy(name = "inoutFlight")           // ...... analogicznie
    WebElement getSelectCheckBox2;

    @FindBy(xpath = "//input[@type ='image']")
    WebElement continueClick;

    public void clickSelectCheckBox1() {
        wait.waitForElementToBeVisible(driver,selectCheckBox1,TIME_OUT);
        selectCheckBox1.click();
    }

    public void clickSelectCheckBox2(){
        wait.waitForElementToBeVisible(driver,getSelectCheckBox2,TIME_OUT);
        getSelectCheckBox2.click();
    }

    public void clickContinueClick(){
        wait.waitForElementToBeVisibleAndClick(driver,continueClick,TIME_OUT);
    }
}

