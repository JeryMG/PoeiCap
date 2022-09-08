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
import org.testng.asserts.Assertion;

import java.time.Duration;
import java.util.List;

public class Tp3 {

    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    private void setup(){
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr");
    }

    @AfterMethod
    private void teardown(){
        driver.quit();
    }

    @Test
    private void testAmazon() {

        //Accept cookies
        WebElement acceptButton = driver.findElement(By.cssSelector("#sp-cc-accept"));
        acceptButton.click();

        //click sur "toutes"
        WebElement buttonToutes = driver.findElement(By.cssSelector(".hm-icon-label"));
        buttonToutes.click();

        //Meilleures ventes

        //Synchronisation of the page
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("ul.hmenu-visible>li>a.hmenu-item")));
        //Recherche du 3eme element
        List<WebElement> listMenu = driver.findElements(By.cssSelector("ul.hmenu-visible>li>a.hmenu-item"));
        listMenu.get(0).click();

        //Click 3rd article with Xpath
//        WebElement articlesList = driver.findElement(By.xpath("//*[@id='anonCarousel1']/ol/li[3]/div[2]"));
//        articlesList.click();

        //Click 3rd article with CSS
        List<WebElement> articlesList = driver.findElements(By.cssSelector(".zg-carousel-general-faceout"));
        articlesList.get(2).click();
    }

    @Test
    public void test() {
        //Arrange (données attendues)
        final String expectedToutes = "Toutes";

        //Act
        WebElement logo = driver.findElement(By.cssSelector("#nav-logo"));
        WebElement toutesMenu = driver.findElement(By.cssSelector("#nav-hamburger-menu"));

        //Assert
        Assert.assertTrue(logo.isDisplayed(), "Logo isn't displayed");
        Assert.assertEquals(toutesMenu.getText(), expectedToutes, "Bien ecrit ! ");
    }
}
