package amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    WebDriver driver;
    final int TIMEOUT_COOKIE = 6;
    By acceptCookiesSelector = By.cssSelector(".a-button-input.celwidget");
    By searchBarSelector = By.cssSelector("#twotabsearchtextbox");
    By magnifierButton = By.cssSelector("#nav-search-submit-button");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public HomePage acceptCookies(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_COOKIE));
        WebElement acceptButton = wait.until(ExpectedConditions.visibilityOfElementLocated(acceptCookiesSelector));
        acceptButton.click();
        return this;
    }

    public SearchResultPage searchWithButton(String keyword){
        WebElement searchBar = driver.findElement(searchBarSelector);
        searchBar.sendKeys(keyword);
        WebElement loupe = driver.findElement(magnifierButton);
        loupe.click();

        return new SearchResultPage(driver);
    }
}
