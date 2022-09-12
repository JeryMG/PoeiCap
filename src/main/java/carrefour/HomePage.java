package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver;
    By acceptCookiesSelector = By.cssSelector(".banner-actions-container>#onetrust-accept-btn-handler");
    By maisonLoisirButtonSelector = By.cssSelector("[for = header-tab-non-food]>.header__topbar-tabs-link");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public HomePage acceptCookies(){

        WebElement acceptCookiesButton = driver.findElement(acceptCookiesSelector);
        acceptCookiesButton.click();
        return new HomePage(driver);
    }

    public ShoppingPage clickHomeHobbiesButton(){
        WebElement homeHobbiesButton = driver.findElement(maisonLoisirButtonSelector);
        homeHobbiesButton.click();
        return new ShoppingPage(driver);
    }
}
