package pageObjects.tests;

import org.junit.Test;
import pageObjects.pages.GoogleMainPage;
import pageObjects.pages.GoogleResultPage;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public class GoogleSearchTest extends BaseTest {

    public static final String CODESPRINTERS = "codesprinters";

    @Test
    public void firstSeleniumTest() {
        GoogleMainPage main= new GoogleMainPage(driver);
        main.searchInMainPage(CODESPRINTERS);
        GoogleResultPage results= new GoogleResultPage(driver);
        results.checkResultPage("Code Sprinters");
    }

}
