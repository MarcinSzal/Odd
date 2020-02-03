package pl.com.aay;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import pl.com.aay.pageObject.PageObject1;
import pl.com.aay.seleniumEngine.AdvancedSeleniumEngine;

public class PageObjectMTest1 {

   PageObject1 page;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        page = new PageObject1(driver);
        page.openWebSite("http://newtours.demoaut.com/mercurywelcome.php ");
    }

    @Test
    public void logInTest() {
        page.logIn();
    }
    @Test
    public void logWithLogin() {
        page.logWithLogin();
    }

    @Test
    public void logWithDataFromFileTest() {
        page.logWithDataFromFile();
    }

    @Test
    public void bannerCheckTest() {
        page.bannerCheck();
    }

    @Test
    public void leftMenuTest() {
        page.leftMenu();
    }

    @Test
    public void upperMenuTest() {
        page.upperMenu();
    }

    @AfterTest
    public void tearDown() {
        page.driverQuit();
    }



}
