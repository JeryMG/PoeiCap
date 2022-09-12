import carrefour.HomePage;
import carrefour.ProductPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TpCarrefourTest {

    WebDriver driver;
    final String expectedProductName = "Draisienne pliable et électrique MOOVWAY";

    @BeforeMethod
    private void setup(){
        driver = new ChromeDriver();
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
