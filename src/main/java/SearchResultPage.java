import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultPage {

    WebDriver driver;

    public SearchResultPage(WebDriver driver){
        this.driver = driver;
    }

    public void OpenSearchResult(int index){
        List<WebElement> listResults = driver.findElements(By.cssSelector("[data-component-type = 's-search-result']"));
        listResults.get(index).click();
    }
}
