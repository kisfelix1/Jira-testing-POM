package editIssue;

import base.BaseEdit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
    public void editToucanIssue1Test() {
        login();
        openIssue("TOUCAN", 1);
        Assertions.assertTrue(editButtonIsVisible());
        logout();
    }

    @Test
    public void editToucanIssue2Test() {
        login();
        openIssue("TOUCAN", 2);
        Assertions.assertTrue(editButtonIsVisible());
        logout();
    }

    @Test
    public void editToucanIssue3Test() {
        login();
        openIssue("TOUCAN", 3);
        Assertions.assertTrue(editButtonIsVisible());
        logout();
    }

    @Test
    public void editCoalaIssue1Test() {
        login();
        openIssue("COALA", 1);
        Assertions.assertTrue(editButtonIsVisible());
        logout();
    }

    @Test
    public void editCoalaIssue2Test() {
        login();
        openIssue("COALA", 2);
        Assertions.assertTrue(editButtonIsVisible());
        logout();
    }

    @Test
    public void editCoalaIssue3Test() {
        login();
        openIssue("COALA", 3);
        Assertions.assertTrue(editButtonIsVisible());
        logout();
    }

    @Test
    public void editJetiIssue1Test() {
        login();
        openIssue("JETI", 1);
        Assertions.assertTrue(editButtonIsVisible());
        logout();
    }

    @Test
    public void editJetiIssue2Test() {
        login();
        openIssue("JETI", 2);
        Assertions.assertTrue(editButtonIsVisible());
        logout();
    }

    @Test
    public void editJetiIssue3Test() {
        login();
        openIssue("JETI", 3);
        Assertions.assertTrue(editButtonIsVisible());
        logout();
    }
}
