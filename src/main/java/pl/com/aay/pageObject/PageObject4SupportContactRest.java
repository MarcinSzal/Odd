package pl.com.aay.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.com.aay.seleniumEngine.AdvancedSeleniumEngine;

public class PageObject4SupportContactRest extends AdvancedSeleniumEngine {

    private static final int TIME_OUT = 5;     // dodano zmienn¹

    @FindBy(xpath = "//tr[@valign ='top']")
    WebElement mainView;

    @FindBy(xpath ="//img[@src=/images/masts/mast_construction.gif']")
    WebElement underConstructionImg;

    @FindBy(xpath = "//img[src ='/images/forms/home.gif']")
    WebElement backToHomeButton;

    @FindBy(xpath ="//img[@src='/images/nav/boxad1.gif']")
    WebElement savingsImage;

    @FindBy(xpath = "//img[@src='/images/nav/html.gif']")
    WebElement htmlImage;

    public PageObject4SupportContactRest(WebDriver driver){  // dotyczy wszystkich zak³adek z bocznego menu, po kliknieciu przechodz na strone "Under Construction" i tej dotyczy ta klasa
        super(driver);
        PageFactory.initElements(driver,this);
    }

    public void backToHomeClick() { wait.waitForElementToBeVisibleAndClick(driver,backToHomeButton,TIME_OUT);
    }

    public void setUnderConstructionImgCheck(){
        wait.waitForElementToBeVisible(driver,underConstructionImg,TIME_OUT);
        boolean b = underConstructionImg.isDisplayed();     // dodano
        System.out.println(b);
    }

    public void setMainViewCheck() {
        wait.waitForElementToBeVisible(driver,mainView,TIME_OUT);   // dodano
        boolean b = mainView.isDisplayed();
        System.out.println(b);
    }

    public void setSavingsImageCheck() {
        wait.waitForElementToBeVisible(driver,savingsImage,TIME_OUT);   // dodano
        boolean b = savingsImage.isDisplayed();
        System.out.println(b);                                              // .........
    }

    public void setHtmlImageCheck(){
        wait.waitForElementToBeVisible(driver,htmlImage,TIME_OUT);  // dodano
        boolean b = htmlImage.isDisplayed();                        //,,,,
        System.out.println(b);
    }
}
