import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {

    WebDriver driver;

    By firstSearchResultSelector = By.cssSelector("img.s-image");

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
    }

    public void OpenSearchResult(int index) throws InterruptedException {
        List<WebElement> listResults = driver.findElements(firstSearchResultSelector);
        listResults.get(index).click();
    }
}
