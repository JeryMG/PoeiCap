package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    By acceptCookiesSelector = By.cssSelector("html > body > div:nth-of-type(4) > div:nth-of-type(3) > div > div > div:nth-of-type(2) > div > div > button");
    By maisonLoisirButtonSelector = By.cssSelector("[for = header-tab-non-food]>.header__topbar-tabs-link");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public HomePage acceptCookies(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement acceptCookiesButton = wait.until(ExpectedConditions.elementToBeClickable(acceptCookiesSelector));
        acceptCookiesButton.click();
        return new HomePage(driver);
    }

    public ShoppingPage clickHomeHobbiesButton(){
        WebElement homeHobbiesButton = driver.findElement(maisonLoisirButtonSelector);
        homeHobbiesButton.click();
        return new ShoppingPage(driver);
    }
}
