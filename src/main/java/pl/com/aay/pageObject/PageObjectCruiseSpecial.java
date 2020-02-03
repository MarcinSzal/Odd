package pl.com.aay.pageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.com.aay.seleniumEngine.AdvancedSeleniumEngine;

public class PageObjectCruiseSpecial extends AdvancedSeleniumEngine {  // dotyczy strony po kliknieciu Cruise w lewym menu ;

    private static final int TIME_OUT = 5;          //.....

    @FindBy(xpath = "//img[@src='/images/nav/logo.gif']")
    WebElement  mercuryToursImg;

    @FindBy(xpath = "//img[@src='/images/alaskan_cruise.gif']")
    WebElement alaskaImg;

    @FindBy(xpath = "//img[@src ='/images/reservation_open.gif'] ")
    WebElement nowAcceptingReservationsImg;

    @FindBy(xpath = "//img[@src='/images/nav/boxad1.gif']")
    WebElement savingsImage;

    public PageObjectCruiseSpecial(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void setMercuryToursImgCheck(){
        wait.waitForElementToBeVisible(driver,mercuryToursImg,TIME_OUT);
        boolean b = mercuryToursImg.isDisplayed();
        if(!b) Assert.fail();                                       // dodano asercje
    }

    public void setAlaskaImg(){
        wait.waitForElementToBeVisible(driver,alaskaImg,TIME_OUT);
        boolean b = alaskaImg.isDisplayed();
        Assert.assertTrue(b);                           // analogicznie
    }

    public void setSavingsImage(){
        wait.waitForElementToBeVisible(driver,savingsImage,TIME_OUT);
        boolean b = savingsImage.isDisplayed();
        Assert.assertEquals(true,b);                        // analogiczne
    }

    public void setNowAcceptingReservationsImg(){
        wait.waitForElementToBeVisible(driver,nowAcceptingReservationsImg,TIME_OUT);
        boolean b = nowAcceptingReservationsImg.isDisplayed();
        Assert.assertTrue(b);                                   // analogicznie
    }

}
