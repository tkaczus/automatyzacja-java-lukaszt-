package pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public class GoogleResultPage extends GooglePage {

    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    private By NASTEPNA=By.id("pnnext");

    public int countResultWithUrl(String pageURL) {
        List<WebElement> results = driver.findElements(By.cssSelector(".rc > .r >a"));
        Stream<WebElement> resultsStream = results.stream();
        return (int) resultsStream.filter(result -> result.getAttribute("href").equals(pageURL)).count();
    }

    public void clickSecondPage(){
        driver.findElement(NASTEPNA).click();
    }

    public GoogleResultPage displayNextPage() {
        driver.findElement(NASTEPNA).click();
        return  new GoogleResultPage(driver);
    }

    public int countResultWithUrlMatching(String pageUrl) {
        List<WebElement> results = driver.findElements(By.cssSelector(".rc > .r >a"));
        Stream<WebElement> resultsStream = results.stream();
        return (int) resultsStream.filter(result -> result.getAttribute("href").startsWith(pageUrl)).count();
    }
}
