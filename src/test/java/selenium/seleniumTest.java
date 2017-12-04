package selenium;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public class seleniumTest {

    public static final String LOCATOR_CS_PAGE = "//*[@class='rc']/*[@class='r']/a[@href='http://agileszkolenia.pl/']";
    public static final String GOOGLE_LINK = "http://www.google.com";
    public static final String CODESPRINTERS = "codesprinters";
    By GOOGLE_LOCATOR = By.name("q");
    WebDriver driver;

    @Before
    public void initializeBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void firstSeleniumTest() {
        driver.get(GOOGLE_LINK);
        final WebElement search = driver.findElement(GOOGLE_LOCATOR);
        search.sendKeys(CODESPRINTERS);
        search.submit();
        Assert.assertTrue("Cs page found", driver.findElements(By.xpath(LOCATOR_CS_PAGE)).size() > 0);
        Assert.assertEquals("Tekst na stronie", "Code Sprinters", driver.findElement(By.xpath("//*[@id=\"rhs_title\"]/span")).getText());
    }

    @After
    public void closeBrowser() {
        if (driver != null) driver.close();
    }
}
