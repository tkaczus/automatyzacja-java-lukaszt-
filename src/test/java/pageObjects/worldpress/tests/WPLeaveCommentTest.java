package pageObjects.worldpress.tests;

import org.junit.Assert;
import org.junit.Test;
import pageObjects.worldpress.domain.User;
import pageObjects.worldpress.pages.WPMainPage;
import pageObjects.worldpress.pages.WPReplayPage;

/**
 * Created by Lukasz.Tkaczyk on 2017-12-04.
 */
public class WPLeaveCommentTest extends WPBaseTest {

    @Test
    public void verifyLeavingCommendOnFirstPost() {
        //arrange
        User user= new User();
        System.out.println(user.toString());
        WPMainPage mainPage = new WPMainPage(driver);
        mainPage.open();
        WPReplayPage replayPage = mainPage.openFirstNote();
        replayPage.leaveComment(user);
        //assert
        Assert.assertTrue("verify comment", replayPage.veirfyComment(user)>=1);
    }

}
