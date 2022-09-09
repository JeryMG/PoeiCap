package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;
    private final int TIMEOUT_APPLECARE = 5;
    private final int TIMEOUT_CART = 5;
    By addToCartButtonSelector = By.cssSelector("[name='submit.add-to-cart']");
    By noAppleCareSelector = By.cssSelector("#attachSiNoCoverage");
    By cartButtonSelector = By.cssSelector("#attach-view-cart-button-form");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public ProductPage addToCart(){
        WebElement addCartButton = driver.findElement(addToCartButtonSelector);
        addCartButton.click();
        return this;
    }

    public ProductPage refuseAppleCare(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_APPLECARE));
        WebElement noGarantyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(noAppleCareSelector));
        noGarantyButton.click();
        return this;
    }

    public CartPage openCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_CART));
        WebElement basketButton = wait.until(ExpectedConditions.visibilityOfElementLocated(cartButtonSelector));
        basketButton.click();
        return new CartPage(driver);
    }
}
