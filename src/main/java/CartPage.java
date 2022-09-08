import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class CartPage {

    WebDriver driver;
    By quantitySlector = By.cssSelector("#quantity");

    public CartPage(WebDriver driver){
        this.driver = driver;
    }

    public void selectQuantity(int quantity){
        Select quantitySelect = new Select(driver.findElement(quantitySlector));
        quantitySelect.selectByIndex(quantity);
    }



}
