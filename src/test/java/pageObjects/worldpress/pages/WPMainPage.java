package pageObjects.worldpress.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static pageObjects.worldpress.domain.WordpressData.PAGE_URL;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public class WPMainPage extends WPPage {

    private static final By COMMENTS = By.className("comments-link");

    public WPMainPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(PAGE_URL);
    }


    public WPReplayPage openFirstNote() {
        driver.findElement(COMMENTS).click();
        String url = driver.getCurrentUrl();
        Assert.assertTrue("Verify opening page with url #comments", url.contains("comments"));
        return new WPReplayPage(driver);
    }
}
