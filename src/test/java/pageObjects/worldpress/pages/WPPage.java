package pageObjects.worldpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public abstract class WPPage {

    private static final long TIMEOUT_IN_SECONDS_WAITING_FOR_ELEMENT_VISIBLE = 15;
    private static final long TIMEOUT_IN_SECONDS_WAITING_FOR_ELEMENT_HIDDEN = 15;
    private static final long TIMEOUT_IN_SECONDS_WAITING_FOR_ELEMENT_CLICKABLE = 15;
    protected WebDriver driver;

    public WPPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitUntilElementIsVisible(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS_WAITING_FOR_ELEMENT_VISIBLE);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitUntilElementIsHidden(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS_WAITING_FOR_ELEMENT_HIDDEN);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    protected void waitUntilElementIsClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT_IN_SECONDS_WAITING_FOR_ELEMENT_CLICKABLE);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
