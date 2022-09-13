import amazon.CartPage;
import amazon.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class TpPageObject {

    RemoteWebDriver driver;
    ChromeOptions options = new ChromeOptions();
    FirefoxOptions options2 = new FirefoxOptions();
    EdgeOptions options3 = new EdgeOptions();

    final String searchKeyword = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";
    final int searchResultIndex = 0;
    final int quantityIndex = 2;

    //Expected results:
    final String expectedProductName = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";
    final String expectedSubTotal = "Sous-total (2 articles):";
    final String expectedSize = "256Go";
    final String expectedColor = "Vert alpin";
    final String expectedCongig = "Sans AppleCare+";


    @BeforeMethod
    private void setup() throws MalformedURLException {
        System.setProperty("webdriver.msedge.driver",System.getProperty("user.dir") + "\\src\\Resources\\msedgedriver.exe");
        driver = new RemoteWebDriver(new URL("http://192.168.121.20:4444"), options3);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr");
    }

    @AfterMethod
    private void teardown(){
        driver.quit();
    }

    @Test
    public void testPO() {
        //Action
        HomePage homePage = new HomePage(driver);

        CartPage cartPage = homePage.acceptCookies()
                .searchWithButton(searchKeyword)
                .OpenSearchResult(searchResultIndex)
                .addToCart()
                .refuseAppleCare()
                .openCart()
                .selectQuantity(quantityIndex);

        //Assert
        Assert.assertEquals(cartPage.getFirstProductName(), expectedProductName, "Le titre du produit est incorrect");
        Assert.assertEquals(cartPage.getFirstProductCapacity(), expectedSize, "La taille affichée n'est pas correcte");
        Assert.assertEquals(cartPage.getFirstProductColor(), expectedColor, "La couleur affichée n'est pas correcte");
        Assert.assertEquals(cartPage.getFirstProductSubConfiguration(), expectedCongig, "La config affichée n'est pas correcte");

        //Cas particulier
        Assert.assertEquals(cartPage.GetFirstProductSubTotalCart(), expectedSubTotal, "Le nombre de produits est incorrect");
    }


    @Test
    public void testHover(){
        
        Actions actions = new Actions(driver);
        WebElement elementToHover = driver.findElement(By.cssSelector("#nav-link-accountList"));
        actions.moveToElement(elementToHover);
        actions.perform();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
