package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class CartPage {

    WebDriver driver;
    By quantitySelector = By.cssSelector("#quantity");
    By productTitleSelector = By.cssSelector(".a-truncate-full");
    By productCapacitySelector = By.cssSelector("li.sc-product-variation>span>span");
    By productColorSlector = By.cssSelector("li.sc-product-variation>span>span");
    By productSubtotalSelector = By.cssSelector("li.sc-product-variation>span>span");
    By buyboxSubTotalSelector = By.cssSelector("#sc-subtotal-label-buybox");
    By cartSubTot = By.cssSelector("#sc-subtotal-label-activecart");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public CartPage selectQuantity(int quantity){
        Select quantitySelect = new Select(driver.findElement(quantitySelector));
        quantitySelect.selectByIndex(quantity);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public String getFirstProductName(){
        WebElement productTitle = driver.findElement(productTitleSelector);
        return productTitle.getText();
    }

    public String getFirstProductCapacity(){
        List<WebElement> phoneDescription = driver.findElements(productCapacitySelector);
        return phoneDescription.get(1).getText();
    }

    public String getFirstProductColor(){
        List<WebElement> phoneDescription = driver.findElements(productColorSlector);
       return phoneDescription.get(3).getText();
    }

    public String getFirstProductSubConfiguration(){
        List<WebElement> phoneDescription = driver.findElements(productSubtotalSelector);
        return phoneDescription.get(5).getText();
    }

    public String GetFirstProductSubTotalBuyBox(){
        WebElement buyboxSubtot = driver.findElement(buyboxSubTotalSelector);
        return buyboxSubtot.getText();
    }

    public String GetFirstProductSubTotalCart(){
        WebElement buyboxSubtot = driver.findElement(cartSubTot);
        return buyboxSubtot.getText();
    }
}
