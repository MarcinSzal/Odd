package pl.com.aay.pageObjectTest2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pl.com.aay.pageObject.PageObject3Register;

public class PageObject3RegisterTest {

    PageObject3Register page;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        page = new PageObject3Register(driver);
        page.openWebSite("http://newtours.demoaut.com/mercuryregister.php");
    }

    @Test
    public void registerTest(){

    }
    public void registerImgVisibleTest(){
        page.registerImgVisible();
    }

    @Test
    public void reserveFlightTest(){


    }

    @AfterTest
    public void tearDown(){
        page.driverQuit();
    }


}
