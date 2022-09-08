import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TpPageObject {

    WebDriver driver;

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
    private void setup(){
        driver = new ChromeDriver();
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
        homePage.acceptCookies();
        homePage.searchWithButton(searchKeyword);

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.OpenSearchResult(searchResultIndex);

        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        productPage.refuseAppleCare();
        productPage.openCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.selectQuantity(quantityIndex);

        //Assert
        Assert.assertEquals(cartPage.getFirstProductName(), expectedProductName, "Le titre du produit est incorrect");
        Assert.assertEquals(cartPage.getFirstProductCapacity(), expectedSize, "La taille affichée n'est pas correcte");
        Assert.assertEquals(cartPage.getFirstProductColor(), expectedColor, "La couleur affichée n'est pas correcte");
        Assert.assertEquals(cartPage.getFirstProductSubConfiguration(), expectedCongig, "La config affichée n'est pas correcte");

        //Cas particulier


        Assert.assertEquals(cartPage.GetFirstProductSubTotalCart(), expectedSubTotal, "Le nombre de produits est incorrect");
    }
}
