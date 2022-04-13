package editIssue;

import base.BaseEdit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

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

    @ParameterizedTest
    @CsvFileSource(resources = "/editIssue.csv", delimiter = ',', numLinesToSkip = 1)
    public void editSpecificIssueTest(String type, String id) {
        openIssue(type, id);
        Assertions.assertTrue(isEditButtonVisible());
    }


}
