package pageObjects.google.tests;

import org.junit.Assert;
import org.junit.Test;
import pageObjects.google.domain.CodeSprinters;
import pageObjects.google.pages.GoogleMainPage;
import pageObjects.google.pages.GoogleResultPage;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public class GoogleSearchTest extends BaseTest {

    private GoogleResultPage searchOnGoogle(String pageName) {
        //arrange
        GoogleMainPage mainPage = new GoogleMainPage(driver);
        mainPage.open();
        //act
        return mainPage.searchInMainPage(pageName);
    }

    @Test
    public void verifyGoogleFindsCodeSprintersOnFirstPage() {
        GoogleResultPage resultPage = searchOnGoogle(CodeSprinters.PAGE_NAME);
        //assert
        System.out.println(resultPage.countResultWithUrl(CodeSprinters.PAGE_URL));
        Assert.assertEquals("czy będzie link liczba =", 1, resultPage.countResultWithUrl(CodeSprinters.PAGE_URL));
    }

    @Test
    public void verifyGoogleFindsNoCodesprintersOnSecondPage() {
        //arrange
        GoogleResultPage resultPage = searchOnGoogle(CodeSprinters.PAGE_NAME);
        GoogleResultPage secondResultPage = resultPage.displayNextPage();
        //assert
        Assert.assertTrue("pages with URL starting with", secondResultPage.countResultWithUrlMatching(CodeSprinters.PAGE_URL)==0);
    }

}
