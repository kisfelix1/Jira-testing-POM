package createIssueTest;

import base.BaseIssueTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.IndexPage;
import util.PageUrlCollection;


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
        indexPage.navigateToURL(PageUrlCollection.MTP_ISSUE.getUrl());
        Assertions.assertEquals("MTP-8982431",
                indexPage.getSummaryIssueName(),
                "Summaries do not match.");
        indexPage.deleteIssue();
    }

    @Test
    public void cancelIssueTest(){
        indexPage.fillProjectInputField();
        indexPage.fillSummaryInputField();
        indexPage.clickToCancelButton();
        indexPage.clickToAlert();
        indexPage.goToURL(PageUrlCollection.MTP_ISSUE.getUrl());
        Assertions.assertEquals("No issues were found to match your search",
                issuePage.getIssuesH2Text(),
                "The text does not matching.");



    }
}
