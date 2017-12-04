package pageObjects.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public class GoogleResultPage extends GooglePage {

    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    private By NASTEPNA=By.id("pnnext");

    public void checkResultPage(String textToCheck) {
        Assert.assertEquals("Tekst na stronie", textToCheck, driver.findElement(By.xpath("//*[@id=\"rhs_title\"]/span")).getText());
    }

    public int countResultWithUrl(String pageURL) {
        List<WebElement> results = driver.findElements(By.cssSelector(".rc > .r >a"));
        Stream<WebElement> resultsStream = results.stream();
        return (int) resultsStream.filter(result -> result.getAttribute("href").equals(pageURL)).count();
    }

    public void clickSecondPage(){
        driver.findElement(NASTEPNA).click();
    }

}
