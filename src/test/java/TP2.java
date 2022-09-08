import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class TP2 {

    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setup(){
        //WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr");
    }

    @AfterTest
    public void teardown(){
        driver.quit();
    }

    @Test
    public void testAmazonXpath() throws InterruptedException {

        //setup();

        //Accepter cookies
        WebElement acceptButton = driver.findElement(By.xpath("//input[@class='a-button-input celwidget']"));
        acceptButton.click();

        //Input dans barre de recherche et click sur loupe
        WebElement searchbar = driver.findElement(By.xpath("(//input[@class='nav-input nav-progressive-attribute'])[1]"));
        searchbar.sendKeys("coque iphone 13");

        WebElement searchButton = driver.findElement(By.xpath("(//input[@class='nav-input nav-progressive-attribute'])[2]"));
        searchButton.click();

        //Cliquer sur le premier resultat
        WebElement firstImage = driver.findElement(By.xpath("(//a/div/img)[3]"));
        firstImage.click();

        //Ajouter premier resultat dans le panier
        WebElement addBasketButton = driver.findElement(By.xpath("//input[@title='Ajouter au panier']"));
        addBasketButton.click();

        //Ouvrir le panier
        WebElement goBasket = driver.findElement(By.xpath("//a/div[2]"));
        goBasket.click();

        sleep(3000);

        //Fermer le navigateur
        //teardown();
    }

    @Test
    public void testAmazonCss() throws InterruptedException {

        //setup();

        //Implicit wait
//        final int IMPLICIT_TIMEOUT = 5;
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_TIMEOUT));

        //Accepter cookies
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(3));
        WebElement acceptButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".a-button-input.celwidget")));
        //WebElement acceptButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".a-button-input.celwidget")));
        acceptButton.click();

        //WebElement acceptButton = driver.findElement(By.cssSelector(".a-button-input.celwidget"));
        //acceptButton.click();

        //Input dans barre de recherche et click sur loupe
        WebElement searchbar = driver.findElement(By.cssSelector("[aria-label='Rechercher']"));
        searchbar.sendKeys("coque iphone 13");

        WebElement searchButton = driver.findElement(By.cssSelector("[type='submit']"));
        searchButton.click();

        //Cliquer sur le premier resultat
        WebElement firstImage = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[cel_widget_id='MAIN-SEARCH_RESULTS-2']")));
        firstImage.click();

        //Ajouter premier resultat dans le panier
        WebElement addBasketButton = driver.findElement(By.cssSelector("[title='Ajouter au panier']"));
        addBasketButton.click();

        //Ouvrir le panier
        WebElement goBasket = driver.findElement(By.cssSelector("#nav-cart-text-container"));
        goBasket.click();

        //Fermer le navigateur
        //teardown();
    }
}
