import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;
    private final int TIMEOUT_APPLECARE = 5;
    By addToCartButtonSelector = By.cssSelector("[name='submit.add-to-cart']");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public void addToCart(){
        WebElement addCartButton = driver.findElement(addToCartButtonSelector);
        addCartButton.click();
    }

    public void refuseAppleCare(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_APPLECARE));
        WebElement noGarantyButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#attachSiNoCoverage")));
        noGarantyButton.click();
    }
}
