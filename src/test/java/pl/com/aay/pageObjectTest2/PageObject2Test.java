package pl.com.aay.pageObjectTest2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.com.aay.pageObject.PageObject2;

public class PageObject2Test {

    PageObject2 page;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        page = new PageObject2(driver);
        page.openWebSite("http://newtours.demoaut.com/mercurysignon.php");
    }

    @Test
    public void userNameTest() {
        page.userName();
    }
    public void passwordTest() {
        page.passWord();
    }
    public void submitButtonTest(){
        page.submitButton();
    }

    @Test
    public void setUserNameTextCheckTest() {
        page.setUserNameTextCheck();
    }
    public void setPasswordCheckTest(){
        page.setPasswordCheck();
    }

    @Test
    public void checkImgTest(){
        page.checkImg();
    }

    @AfterTest
    public void tearDown(){
        page.driverQuit();
    }



}
