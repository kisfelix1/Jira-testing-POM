package browseIssueTest;

import base.BaseBrowseIssueTest;
import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.IndexPage;
import pages.IssuePage;
import util.PageUrlCollection;

public class BrowseIssueTest extends BaseBrowseIssueTest {


    @Test
    public void browseIssue(){
        indexPage.goToURL(PageUrlCollection.MTP_ISSUE_FOR_BROWSE.getUrl());
        Assertions.assertEquals(MTP_ISSUE_KEY,
                issuePage.getIssueKey(),
                "Issue key is not matching");
    }

    @Test
    public void browseIssueCOALA_ID_1(){
        indexPage.goToURL(PageUrlCollection.COALA_ISSUE_ID_1.getUrl());
        Assertions.assertEquals(COALA_ISSUE_KEY_1,
                issuePage.getIssueKey(),
                "Issue key is not matching");
    }

    @Test
    public void browseIssueCOALA_ID_2(){
        indexPage.goToURL(PageUrlCollection.COALA_ISSUE_ID_2.getUrl());
        Assertions.assertEquals(COALA_ISSUE_KEY_2,
                issuePage.getIssueKey(),
                "Issue key is not matching");
    }

    @Test
    public void browseIssueCOALA_ID_3(){
        indexPage.goToURL(PageUrlCollection.COALA_ISSUE_ID_3.getUrl());
        Assertions.assertEquals(COALA_ISSUE_KEY_3,
                issuePage.getIssueKey(),
                "Issue key is not matching");
    }

    @Test
    public void browseIssueJETI_ID_1() {
        indexPage.goToURL(PageUrlCollection.JETI_ISSUE_ID_1.getUrl());
        Assertions.assertEquals(JETI_ISSUE_KEY_1,
                issuePage.getIssueKey(),
                "Issue key is not matching");
    }

    @Test
    public void browseIssueJETI_ID_2() {
        indexPage.goToURL(PageUrlCollection.JETI_ISSUE_ID_2.getUrl());
        Assertions.assertEquals(JETI_ISSUE_KEY_2,
                issuePage.getIssueKey(),
                "Issue key is not matching");
    }

    @Test
    public void browseIssueJETI_ID_3() {
        indexPage.goToURL(PageUrlCollection.JETI_ISSUE_ID_3.getUrl());
        Assertions.assertEquals(JETI_ISSUE_KEY_3,
                issuePage.getIssueKey(),
                "Issue key is not matching");
    }

    @Test
    public void browseIssueTOUCAN_ID_1() {
        indexPage.goToURL(PageUrlCollection.TOUCAN_ISSUE_ID_1.getUrl());
        Assertions.assertEquals(TOUCAN_ISSUE_KEY_1,
                issuePage.getIssueKey(),
                "Issue key is not matching");
    }

    @Test
    public void browseIssueTOUCAN_ID_2() {
        indexPage.goToURL(PageUrlCollection.TOUCAN_ISSUE_ID_2.getUrl());
        Assertions.assertEquals(TOUCAN_ISSUE_KEY_2,
                issuePage.getIssueKey(),
                "Issue key is not matching");
    }

    @Test
    public void browseIssueTOUCAN_ID_3() {
        indexPage.goToURL(PageUrlCollection.TOUCAN_ISSUE_ID_3.getUrl());
        Assertions.assertEquals(TOUCAN_ISSUE_KEY_3,
                issuePage.getIssueKey(),
                "Issue key is not matching");
    }


}
