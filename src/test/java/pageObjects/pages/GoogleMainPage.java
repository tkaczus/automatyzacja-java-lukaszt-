package pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public class GoogleMainPage extends GooglePage {

    private static final By GOOGLE_LOCATOR = By.name("q");

    public GoogleMainPage(WebDriver driver) {
        super(driver);
    }

    public GoogleResultPage searchInMainPage(String searchText) {
        final WebElement search = driver.findElement(GOOGLE_LOCATOR);
        search.clear();
        search.click();
        search.sendKeys(searchText);
        search.submit();
        return new GoogleResultPage(driver);
    }

    public void open() {
        driver.get(GOOGLE_LINK);
    }
}
