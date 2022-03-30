package editIssue;

import base.BaseEdit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.PageUrlCollection;

public class EditIssueTest extends BaseEdit {

    @Test
    public void editIssueThroughScreenTest() throws InterruptedException {
        login();
        openDummyIssuePage();
        Assertions.assertTrue(issueContainsOldData());
        clickEditButton();
        editIssueWithNewData();
        Assertions.assertTrue(issueContainsNewData());
        refreshPage();
        Assertions.assertTrue(issueContainsNewData());
        revertIssueToOldData();
        logout();
    }

    @Test
    public void cancelIssueTest() {
        login();
        openDummyIssuePageForCancel();
        clickEditButton();
        editIssueWithNewDataThenCancel();
        clickOnAlert();
        Assertions.assertTrue(issueNotContainsNewDataAfterCancel());
        logout();
    }

    @Test
    public void editToucanIssueTest() {
        login();

        logout();
    }

    @Test
    public void editCoalaIssueTest() {
        login();

        logout();
    }

    @Test
    public void editJetiIssueTest() {
        login();

        logout();
    }
}
