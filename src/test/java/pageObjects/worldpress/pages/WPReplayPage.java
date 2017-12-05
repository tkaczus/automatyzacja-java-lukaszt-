package pageObjects.worldpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObjects.worldpress.domain.Comment;

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


    public void leaveComment(Comment comment) {
        driver.findElement(TEXTAREA).click();
        driver.findElement(TEXTAREA).sendKeys(comment.getComment());
        clickToActivateAndWriteToActive(EMAIL, EMAILACTIVE, comment.getEmail());
        clickToActivateAndWriteToActive(AUTHOR, AUTHORACTIVE, comment.getName());
        clickToActivateAndWriteToActive(URL, URLACTIVE, comment.getWebsite());
        waitUntilElementIsClickable(POSTCOMMENT);
        driver.findElement(POSTCOMMENT).click();
    }

    private void clickToActivateAndWriteToActive(By ActivateElement, By ActiveElement, String text) {
        driver.findElement(ActivateElement).click();
        driver.findElement(ActiveElement).clear();
        driver.findElement(ActiveElement).sendKeys(text);
    }

    public int verifyComment(Comment comment) {
        waitUntilElementIsClickable(COMMENTS);
        List<WebElement> results = driver.findElements(COMMENTS);
        Stream<WebElement> resultsStream = results.stream();
        return (int) resultsStream.filter(result -> result.getText().contains(comment.getComment())).count();
    }
}
