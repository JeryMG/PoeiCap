package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BestSellersPage {

    WebDriver driver;

    By ButtonsListSelector = By.cssSelector(".ds-carousel__items>.ds-carousel__item");
    int productToSeeIndex = 20;

    By firstElementSelector = By.cssSelector("html > body > main > div > div > div > div > div:nth-of-type(4) > div > div > div > div > div:nth-of-type(1) > div:nth-of-type(1) > article > div:nth-of-type(1) > div > a");

    public BestSellersPage(WebDriver driver){
        this.driver = driver;
    }

    public ProductPage ClickOnFirstSportProduct(){
        //List<WebElement> voirButtonsList = driver.findElements(ButtonsListSelector);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //wait.until(ExpectedConditions.elementToBeClickable(voirButtonsList.get(productToSeeIndex)));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(firstElementSelector)));
        //voirButtonsList.get(productToSeeIndex).click();
        WebElement element = driver.findElement(firstElementSelector);
        element.click();
        return new ProductPage(driver);
    }
}
