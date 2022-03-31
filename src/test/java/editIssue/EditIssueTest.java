package editIssue;

import base.BaseEdit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EditIssueTest extends BaseEdit {

    @Test
    public void editIssueThroughScreenTest() {
        openDummyIssuePage();
        Assertions.assertTrue(issueContainsOldData());
        clickEditButton();
        editIssueWithNewData();
        Assertions.assertTrue(issueContainsNewData());
        refreshPage();
        Assertions.assertTrue(issueContainsNewData());
        revertIssueToOldData();
    }

    @Test
    public void cancelIssueTest() {
        openDummyIssuePageForCancel();
        clickEditButton();
        editIssueWithNewDataThenCancel();
        clickOnAlert();
        Assertions.assertTrue(issueNotContainsNewDataAfterCancel());
    }

    @Test
    public void editToucanIssue1Test() {
        isIssueEditable("TOUCAN-1");
    }

    @Test
    public void editToucanIssue2Test() {
        isIssueEditable("TOUCAN-2");
    }

    @Test
    public void editToucanIssue3Test() {
        isIssueEditable("TOUCAN-3");
    }

    @Test
    public void editCoalaIssue1Test()  {
        isIssueEditable("COALA-1");
    }

    @Test
    public void editCoalaIssue2Test() {
        isIssueEditable("COALA-2");
    }

    @Test
    public void editCoalaIssue3Test() {
        isIssueEditable("COALA-3");
    }

    @Test
    public void editJetiIssue1Test() {
        isIssueEditable("JETI-1");
    }

    @Test
    public void editJetiIssue2Test() {
        isIssueEditable("JETI-2");
    }

    @Test
    public void editJetiIssue3Test() {
        isIssueEditable("JETI-3");
    }

}
