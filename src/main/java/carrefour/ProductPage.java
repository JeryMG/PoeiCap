package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private static final int TIMEOUT_PRODUCTPAGE = 5;
    WebDriver driver;

    private By productNameSelector = By.cssSelector(".ds-title.pdp-card__title.ds-title--light.ds-title--l");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }

    public String getProductName(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_PRODUCTPAGE));
        wait.until(ExpectedConditions.visibilityOfElementLocated(productNameSelector));
        WebElement productName = driver.findElement(productNameSelector);
        return productName.getText();
    }
}
