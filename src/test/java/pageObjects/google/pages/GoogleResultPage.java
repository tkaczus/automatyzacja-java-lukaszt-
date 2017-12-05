package pageObjects.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public class GoogleResultPage extends GooglePage {

    public static final String LOCATOR_SINGLE_RESULT = ".rc > .r >a";

    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    private static final By NASTEPNA=By.id("pnnext");

    public int countResultWithUrl(String pageURL) {
        List<WebElement> results = driver.findElements(By.cssSelector(LOCATOR_SINGLE_RESULT));
        Stream<WebElement> resultsStream = results.stream();
        return (int) resultsStream.filter(result -> result.getAttribute("href").equals(pageURL)).count();
    }

    public GoogleResultPage displayNextPage() {
        driver.findElement(NASTEPNA).click();
        return  new GoogleResultPage(driver);
    }

    public int countResultWithUrlMatching(String pageUrl) {
        List<WebElement> results = driver.findElements(By.cssSelector(LOCATOR_SINGLE_RESULT));
        Stream<WebElement> resultsStream = results.stream();
        return (int) resultsStream.filter(result -> result.getAttribute("href").startsWith(pageUrl)).count();
    }
}
