package pageObjects.worldpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.worldpress.domain.User;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public class WPReplayPage extends WPPage {


    public WPReplayPage(WebDriver driver) {
        super(driver);
    }

    private static final By COMMENTS = By.cssSelector("#comments > ol > li");
    private static final By TEXTAREA = By.id("comment");
    private static final By EMAIL = By.xpath("//DIV[@class='comment-form-field comment-form-email']");
    private static final By EMAILACTIVE = By.id("email");
    private static final By AUTHOR = By.xpath("//DIV[@class='comment-form-field comment-form-author']");
    private static final By AUTHORACTIVE = By.id("author");
    private static final By URL = By.xpath("//DIV[@class='comment-form-field comment-form-url']");
    private static final By URLACTIVE = By.id("url");
    private static final By POSTCOMMENT = By.name("submit");


//    public int countResultWithUrlMatching(String pageUrl) {
//        List<WebElement> results = driver.findElements(By.cssSelector(LOCATOR_SINGLE_RESULT));
//        Stream<WebElement> resultsStream = results.stream();
//        return (int) resultsStream.filter(result -> result.getAttribute("href").startsWith(pageUrl)).count();
//    }

    public WebElement getWhenVisible(By locator, int timeout) {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;

    }
    public void clickWhenReady(By locator, int timeout) {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();

    }

    public void leaveComment(User user) {
        driver.findElement(TEXTAREA).click();
        driver.findElement(TEXTAREA).sendKeys(user.getComment());
//        clickWhenReady(EMAIL,60);
//        getWhenVisible(EMAIL,30).click();
        driver.findElement(EMAIL).click();
        driver.findElement(EMAILACTIVE).clear();
        driver.findElement(EMAILACTIVE).sendKeys(user.getEmail());
        driver.findElement(AUTHOR).click();
        driver.findElement(AUTHORACTIVE).clear();
        driver.findElement(AUTHORACTIVE).sendKeys(user.getName());
        driver.findElement(URL).click();
        driver.findElement(URLACTIVE).clear();
        driver.findElement(URLACTIVE).sendKeys(user.getWebsite());
        waitUntilElementIsClickable(POSTCOMMENT);
        driver.findElement(POSTCOMMENT).click();
    }

    public int veirfyComment(User user) {
        System.out.println("user.getComment() = " + user.getComment());
        waitUntilElementIsClickable(COMMENTS);
        List<WebElement> results = driver.findElements(COMMENTS);
        System.out.println("results.size() = " + results.size());
        Stream<WebElement> resultsStream = results.stream();
        return (int) resultsStream.filter(result -> result.getText().contains(user.getComment())).count();
    }
}
