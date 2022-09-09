package carrefour;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class ShoppingPage {

    private static final int TIMEOUT_RAYONMENU = 5;
    WebDriver driver;
    By rayonButtonSelector = By.cssSelector("#data-rayons");
    By rayonMenuSelector = By.cssSelector("#data-menu-level-0");
    By rayonAllCategoriesSelector = By.cssSelector("#data-menu-level-0>.nav-item");
    int sportCategoryIndex = 4;
    By secondMenuSelector = By.cssSelector("#data-menu-level-1_R26");
    int bestSellersButtonIndex = 2;
    By secondMenuAllCategoriesSelector = By.cssSelector("[data-testid=nav-item-submenu].nav-item__menu.nav-item__menu-level-1>.nav-item");

    public ShoppingPage(WebDriver driver){
        this.driver = driver;
    }

    public ShoppingPage OpenRayonMenu(){
        WebElement rayonMenuButton = driver.findElement(rayonButtonSelector);
        rayonMenuButton.click();
        return this;
    }

    public ShoppingPage HoverSportsLClickBSellers(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_RAYONMENU));
        wait.until(ExpectedConditions.visibilityOfElementLocated(rayonMenuSelector));
        List<WebElement> menuCategories = driver.findElements(rayonAllCategoriesSelector);
        Actions hoverSportCategorie = new Actions(driver);
        hoverSportCategorie.moveToElement(menuCategories.get(sportCategoryIndex));
        hoverSportCategorie.perform();
        WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_RAYONMENU));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(secondMenuSelector));
        return this;
    }

    public BestSellersPage ClickBestSellersButton(){
        List<WebElement> menu2Categories = driver.findElements(secondMenuAllCategoriesSelector);
        WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT_RAYONMENU));
        wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='data-menu-level-1_R26']/li[3]")));
        WebElement button = driver.findElement(By.xpath("//*[@id='data-menu-level-1_R26']/li[3]"));
        button.click();
        return new BestSellersPage(driver);
    }
}
