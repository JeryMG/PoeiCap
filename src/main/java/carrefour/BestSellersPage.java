package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        voirButtonsList.get(productToSeeIndex).click();
        return new ProductPage(driver);
    }
}
