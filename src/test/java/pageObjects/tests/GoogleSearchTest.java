package pageObjects.tests;

import org.junit.Assert;
import org.junit.Test;
import pageObjects.domain.CodeSprinters;
import pageObjects.pages.GoogleMainPage;
import pageObjects.pages.GoogleResultPage;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public class GoogleSearchTest extends BaseTest {

    @Test
    public void firstSeleniumTest() {
        //arrange
        GoogleMainPage mainPage = new GoogleMainPage(driver);
        mainPage.open();
        //act
        GoogleResultPage resultPage = mainPage.searchInMainPage(CodeSprinters.CODESPRINTERS);
        //assert
        resultPage.checkResultPage(CodeSprinters.PAGE_NAME);
        System.out.println(resultPage.countResultWithUrl(CodeSprinters.PAGE_URL));
        resultPage.clickSecondPage();
        Assert.assertEquals("czy będzie link liczba =",0,resultPage.countResultWithUrl(CodeSprinters.PAGE_URL));
    }

}
