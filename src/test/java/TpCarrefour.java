import carrefour.CartPage;
import carrefour.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TpCarrefour {

    WebDriver driver;

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
    public void testCarrefour() {

        //Action
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies()
                .clickHomeHobbiesButton()
                .OpenRayonMenu()
                .HoverSportsLClickBSellers()
                .ClickBestSellersButton()
                .ClickOnFirstSportProduct();
    }
}