import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.internal.Debug;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.ListIterator;

public class Tp4 {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    @BeforeMethod
    private void setup(){
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr");

        //Accepter cookies
        WebElement acceptButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".a-button-input.celwidget")));
        acceptButton.click();
    }

    @AfterMethod
    private void teardown(){
        driver.quit();
    }

    @Test
    public void testAchatIphone13() throws InterruptedException {

        //Arrange
        final String searchKeyword = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";
        final String expectedProductName = "Apple iPhone 13 Pro Max (256 Go) - Vert Alpin";
        final String expectedSubTotal = "Sous-total (2 articles):";
        final String expectedSize = "256Go";
        final String expectedColor = "Vert alpin";
        final String expectedCongig = "Sans AppleCare+";

        //Action
        WebElement searchBar = driver.findElement(By.cssSelector("#twotabsearchtextbox"));
        searchBar.sendKeys(searchKeyword);
        WebElement loupe = driver.findElement(By.cssSelector("#nav-search-submit-button"));
        loupe.click();
        List<WebElement> listResults = driver.findElements(By.cssSelector("[data-component-type = 's-search-result']"));
        listResults.get(0).click();
        WebElement addCartButton = driver.findElement(By.cssSelector("[name='submit.add-to-cart']"));
        addCartButton.click();
        WebElement noGarantyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#attachSiNoCoverage")));
        noGarantyButton.click();
        WebElement basketButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#attach-view-cart-button-form")));
        basketButton.click();
        Select quantitySelect = new Select(driver.findElement(By.cssSelector("#quantity")));
        quantitySelect.selectByIndex(2);

        WebElement productTitle = driver.findElement(By.cssSelector(".a-truncate-cut"));
        List<WebElement> phoneDescription = driver.findElements(By.cssSelector("li.sc-product-variation>span>span"));
        //List<WebElement> listDescription = driver.findElements(By.cssSelector(".a-text-bold + span"));

        //Assert
        Assert.assertEquals(productTitle.getText(), expectedProductName, "Le titre du produit est incorrect");
        Assert.assertEquals(phoneDescription.get(1).getText(), expectedSize, "La taille affichée n'est pas correcte");
        Assert.assertEquals(phoneDescription.get(3).getText(), expectedColor, "La couleur affichée n'est pas correcte");
        Assert.assertEquals(phoneDescription.get(5).getText(), expectedCongig, "La config affichée n'est pas correcte");

        //Cas particulier
        Thread.sleep(5000);
        WebElement subTotal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sc-subtotal-label-activecart")));
        Assert.assertEquals(subTotal.getText(), expectedSubTotal, "Le nombre de produits est incorrect");
    }
}
