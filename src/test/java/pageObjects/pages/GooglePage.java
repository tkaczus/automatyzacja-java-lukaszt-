package pageObjects.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public abstract class GooglePage {
    protected static final String GOOGLE_LINK = "http://www.google.com";

    protected WebDriver driver;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
    }
}
