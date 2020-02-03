package pl.com.aay.pageObjectTest1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pl.com.aay.pageObject.*;

public class PageObjectTest {
	
	WebDriver driver;
	MainPage mainPage;
	ContactUsPage contactUsPage;
	CartPage cartPage;
	SignInPage signInPage;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
		driver = new FirefoxDriver ();
		mainPage = new MainPage (driver);
		contactUsPage = new ContactUsPage (driver);
		cartPage = new CartPage (driver);
		signInPage = new SignInPage (driver);
		mainPage.openMainPage();
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testCheckBanner() {
		mainPage.clickBunner();
	}
	
	//@Test
	public void testSearchObject() {
		mainPage.searchObject();
	}
	
	//@Test
	public void testMenu() {
		mainPage.openAllMenu();
	}
	
	//@Test
	public void testSendEmailNewsletter() {
		mainPage.sendEmailNewsletter();
	}
	
	@Test
	public void testSendEmailToContact() {
		mainPage.openContactUs();
		contactUsPage.sendEmailToContact();
	}
	
	//@Test
	public void testCheckAllertCartTest() {
		mainPage.goToCart();
		cartPage.checkAllertCart();
	}
	
	@Test
	public void createAccountTest() {
		mainPage.openSignIn();
		signInPage.createAccount();
	}

}
