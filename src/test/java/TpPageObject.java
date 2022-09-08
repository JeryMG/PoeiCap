import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TpPageObject {

    WebDriver driver;

    final String searchKeyword = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";
    final int searchResultIndex = 0;


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
    public void testPO() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.acceptCookies();
        homePage.searchWithButton(searchKeyword);

        SearchResultPage searchResultPage = new SearchResultPage(driver);
        searchResultPage.OpenSearchResult(searchResultIndex);

        ProductPage productPage = new ProductPage(driver);
        productPage.addToCart();
        productPage.refuseAppleCare();
    }
}
