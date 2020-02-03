import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.com.aay.pageObject.*;

public class TestFactoryPageObject1 {

            WebDriver driver;
            PageObject1 pageObject1;
            PageObject2 pageObject2;
            PageObject3Register pageObject3Register;
            PageObject4SupportContactRest page4;
            PageObjectCruiseSpecial page5;
            PageObjectFlightFinder page6;
            PageObjectFlightReserv page7;
            PageObjectSelectFlight page8;
            String url;

            @BeforeClass
            public void setUp(){
                System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
                driver = new FirefoxDriver();
                pageObject1=new PageObject1(driver);
                pageObject2 = new PageObject2(driver);
                pageObject3Register = new PageObject3Register(driver);
                page4 = new PageObject4SupportContactRest(driver);
                page5 = new PageObjectCruiseSpecial(driver);
                page6 = new PageObjectFlightFinder(driver);
                page7 = new PageObjectFlightReserv(driver);
                page8 = new PageObjectSelectFlight(driver);
                url = "http://newtours.demoaut.com/mercurywelcome.php";
                pageObject1.openWebSite(url);

            }
            @AfterClass
            public void tearDown(){
                pageObject1.driverQuit();
            }

            @DataProvider(name = "test")
            public Object[][] getData(){
                return DataProvide.data();
            }

            @Test(dataProvider = "test")
            public void logIntoSite(String username,String password) {                  // proces logowania na stronie g³ównej z uzyciem danych z macierzy;

                pageObject1.useDataPlogin().sendKeys(username);
                pageObject1.useDataPpassword().sendKeys(password);
            }

            @Test
            public void loginToSiteAndTakeFlightTest(){  // dotyczy logowania oraz nastepnie calego procesu zakupu lotu
                pageObject1.logIn();
                pageObject1.logIn2();
                pageObject1.signIn();
                page6.clickRoundTrip();
                page6.clickOneWayCheckBox();
                page6.passangerSelectClick();
                page6.departingSelectClick();
                page6.continueButtonClick();
                page8.clickSelectCheckBox1();
                page8.clickSelectCheckBox2();
                page8.clickContinueClick();
                page7.passangersName();
                page7.mealSelCheck();
                page7.creditCardSelect();
                page7.numberCheck();
                page7.expirationSelects();                                  // wpisywanie wszystkich danych aby kupic lot
                page7.firstNameCheck();
                page7.middleNameCheck();
                page7.mealSelCheck();
                page7.lastNameCheck();
                page7.ticketLessCheckBox();
                page7.addressCheck();
                page7.cityCheck();
                page7.stateCheck();
                page7.postalCodecheck();
                page7.countrySelectCheck();
                page7.sameAsBilling();
                page7.securePurchase();                                     // wcisniêcie klawisza "secure purchase"
            }

            @Test(priority = 1)
            public void registrationUsingDataTest(){                      // proces rejestracji przy u¿yciu danych z Json
                pageObject1.upperMenu2();
                pageObject3Register.registerToFlight();
            }

            @Test
            public void leftMenuHomeTest(){                             // pojedyncze testy sprawdzaj¹ce tylko i wyl¹cznie klikniêcie
                pageObject1.leftMenu();
            }

            @Test
            public void leftMenuFlightsTest(){                          // analogicznie
                pageObject1.leftMenu2();
            }

            @Test
            public void leftMenuHotelsTest(){                           // klika w lewym menu "Hotels" i przechodzi na strone"under construction" tam sprawdza obrazki i klika "backToHome"
                pageObject1.leftMenu3();
                page4.setHtmlImageCheck();
                page4.setMainViewCheck();
                page4.setSavingsImageCheck();
                page4.setUnderConstructionImgCheck();
                page4.backToHomeClick();                                // klikniêcie BackToHome
            }

            @Test
            public void leftMenuCarrentalsTest(){
                pageObject1.leftMenu4();
            }

            @Test
            public void leftMenuCruisesTest(){                          // w lewym menu klika "cruises" i przechodzi do strony kolejnej gdzie sprawdza obrazki
                pageObject1.leftMeny5();
                page5.setAlaskaImg();
                page5.setMercuryToursImgCheck();
                page5.setNowAcceptingReservationsImg();
                page5.setSavingsImage();
            }

            @Test
            public void leftMenuDestinationsTest(){                     // przedostatni w lewym menu od góry licz¹æ
                pageObject1.leftMenu6();
            }

            @Test
            public void leftMenuVacationsTest(){                        // ostatni w lewym menu.
                pageObject1.leftMenu7();
            }

            @Test
            public void bannerCheckTest(){                          // przyklad z wykorzystaniem fluent wait dotyczy Bannera na stronie glownej, z klasy PageObject1
                pageObject1.bannerCheck();
            }

            @Test
            public void imageCheckTest(){                           // dotyczy obrazka "Aruba" wykorzystuje fluent wait z klasy PageObject1
                pageObject1.imageArubaCheck();
            }

            @Test                                                                   // dodano
            public void upperMenu3Test(){
                pageObject1.upperMenu3();
            }

            @Test                                                                      // dodano
            public void upperMenu4Test(){
                pageObject1.upperMenu4();
            }




}
