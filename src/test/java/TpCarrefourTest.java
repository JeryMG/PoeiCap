import carrefour.HomePage;
import carrefour.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TpCarrefourTest {

    ChromeOptions options = new ChromeOptions();
    RemoteWebDriver driver;
    final String expectedProductName = "Draisienne pliable et électrique MOOVWAY";

    @BeforeMethod
    private void setup() throws MalformedURLException {
        options.setCapability(CapabilityType.BROWSER_NAME, "chrome");
        //options.addArguments("--headless");
        //driver = new ChromeDriver();
        driver = new RemoteWebDriver(new URL("http://192.168.121.20:4444"), options);
        driver.get("https://www.carrefour.fr/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    private void teardown(){
        driver.quit();
    }

    @Test
    public void testCarrefour(){

        //Action
        HomePage homePage = new HomePage(driver);
        ProductPage productPage = homePage.acceptCookies()
                .clickHomeHobbiesButton()
                .OpenRayonMenu()
                .HoverSportsLClickBSellers()
                .ClickBestSellersButton()
                .ClickOnFirstSportProduct();

        //Assert
        Assert.assertEquals(productPage.getProductName(), expectedProductName, "Le nom du produit est incorrect");
    }
}
