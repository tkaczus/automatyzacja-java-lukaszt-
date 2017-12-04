package pageObjects.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public class GoogleResultPage {

    private static final String LOCATOR_CS_PAGE = "//*[@class='rc']/*[@class='r']/a[@href='http://agileszkolenia.pl/']";
    protected WebDriver driver;

    public GoogleResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkResultPage(String textToCheck) {
        Assert.assertTrue("Cs page found", driver.findElements(By.xpath(LOCATOR_CS_PAGE)).size() > 0);
        Assert.assertEquals("Tekst na stronie", textToCheck, driver.findElement(By.xpath("//*[@id=\"rhs_title\"]/span")).getText());
    }

}
