package pageObjects.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public class GoogleMainPage extends GooglePage {

    private static final By GOOGLE_LOCATOR = By.name("q");

    public GoogleMainPage(WebDriver driver) {
        super(driver);
    }

    public GoogleResultPage searchInMainPage(String searchText) {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(GOOGLE_LOCATOR));
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
