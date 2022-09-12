import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class Tp1Test {

    @Test
    public void test1() throws InterruptedException {
        System.out.println("Test");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.fr");
        driver.manage().window().maximize();

        sleep(3000);

        driver.quit();
    }

    @Test
    public void testAmazon() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.fr");

        WebElement searchbar = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        searchbar.sendKeys("Playstation 5");

        WebElement searchButton = driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
        searchButton.click();

        sleep(3000);

        driver.quit();
    }
}
