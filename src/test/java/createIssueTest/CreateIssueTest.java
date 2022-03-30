package createIssueTest;

import base.BaseIssueTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.IndexPage;
import pages.IssuePage;

import java.io.IOException;

public class CreateIssueTest extends BaseIssueTest {
    @BeforeEach
    public void prepareCreateIssueTest() {
        login();
        indexPage.openCreateIssueModal();
    }

    @Test
    public void createIssueMTP(){
        indexPage.fillProjectInputField();
        indexPage.fillSummaryInputField();
        indexPage.clickCreateIssueButton();
        indexPage.navigateToURL(IndexPage.issueURL);
        Assertions.assertEquals("MTP-8982431",
                indexPage.getSummaryIssueName(),
                "Summaries do not match");
        indexPage.deleteIssue();
    }
}
