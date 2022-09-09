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

    By ButtonsListSelector = By.cssSelector(".ds-button.ds-button--secondary.show-options-cta>.ds-button__label.ds-button__label--hidden");
    int productToSeeIndex = 0;

    public BestSellersPage(WebDriver driver){
        this.driver = driver;
    }

    public ProductPage ClickOnFirstSportProduct(){
        List<WebElement> voirButtonsList = driver.findElements(ButtonsListSelector);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(voirButtonsList.get(productToSeeIndex)));
        voirButtonsList.get(productToSeeIndex).click();
        return new ProductPage(driver);
    }
}
