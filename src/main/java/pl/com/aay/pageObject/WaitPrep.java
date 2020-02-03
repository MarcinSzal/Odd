package pl.com.aay.pageObject;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.util.concurrent.TimeUnit;

public class WaitPrep {
    protected WebDriver driver;
    protected Wait<WebDriver>wait;

    public WaitPrep(WebDriver driver){
        this.driver = driver;
        wait = new FluentWait<>(driver)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(ElementNotVisibleException.class);
    }
    public static Wait<WebDriver> waitFor(WebDriver driver){
        return new WaitPrep(driver).wait;
    }
}
