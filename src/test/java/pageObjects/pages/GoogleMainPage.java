package pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public class GoogleMainPage {

    private static final String GOOGLE_LINK = "http://www.google.com";
    By GOOGLE_LOCATOR = By.name("q");
    protected WebDriver driver;

    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchInMainPage(String searchText) {
        driver.get(GOOGLE_LINK);
        final WebElement search = driver.findElement(GOOGLE_LOCATOR);
        search.sendKeys(searchText);
        search.submit();
    }

}
