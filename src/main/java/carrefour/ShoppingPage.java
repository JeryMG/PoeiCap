package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingPage {

    WebDriver driver;
    By rayonButtonSelector = By.cssSelector("#data-rayons");

    public ShoppingPage(WebDriver driver){
        this.driver = driver;
    }

    public ShoppingPage OpenRayonMenu(){
        WebElement rayonMenuButton = driver.findElement(rayonButtonSelector);
        rayonMenuButton.click();
        return this;
    }

}
