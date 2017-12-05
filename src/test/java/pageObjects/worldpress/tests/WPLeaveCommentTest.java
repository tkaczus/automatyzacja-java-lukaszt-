package pageObjects.worldpress.tests;

import org.junit.Assert;
import org.junit.Test;
import pageObjects.worldpress.domain.Comment;
import pageObjects.worldpress.pages.WPMainPage;
import pageObjects.worldpress.pages.WPReplayPage;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public class WPLeaveCommentTest extends WPBaseTest {

    @Test
    public void verifyLeavingCommendOnFirstPost() {
        //arrange
        Comment comment = new Comment();
        WPMainPage mainPage = new WPMainPage(driver);
        mainPage.open();
        //act
        WPReplayPage replayPage = mainPage.openFirstNote();
        replayPage.leaveComment(comment);
        //assert
        Assert.assertTrue("Verify comment", replayPage.verifyComment(comment) > 0);
    }

}
