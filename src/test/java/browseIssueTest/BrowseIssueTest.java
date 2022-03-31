package browseIssueTest;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.IndexPage;
import pages.IssuePage;
import util.PageUrlCollection;

public class BrowseIssueTest extends BaseTests {

    IndexPage indexPage = new IndexPage(driver);
    IssuePage issuePage = new IssuePage(driver);

    @Test
    public void browseIssue(){
        indexPage.goToURL(PageUrlCollection.MTP_ISSUE_FOR_BROWSE.getUrl());
        Assertions.assertEquals("MTP-1841",
                issuePage.getIssueKey(),
                "Issue key is not matching");
    }

    @Test
    public void browseIssueCOALA_ID_1(){
        indexPage.goToURL(PageUrlCollection.COALA_ISSUE_ID_1.getUrl());
        Assertions.assertEquals("COALA-1",
                issuePage.getIssueKey(),
                "Issue key is not matching");
    }

    @Test
    public void browseIssueCOALA_ID_2(){
        indexPage.goToURL(PageUrlCollection.COALA_ISSUE_ID_2.getUrl());
        Assertions.assertEquals("COALA-2",
                issuePage.getIssueKey(),
                "Issue key is not matching");
    }

    @Test
    public void browseIssueCOALA_ID_3(){
        indexPage.goToURL(PageUrlCollection.COALA_ISSUE_ID_3.getUrl());
        Assertions.assertEquals("COALA-3",
                issuePage.getIssueKey(),
                "Issue key is not matching");
    }

    @Test
    public void browseIssueJETI_ID_1() {
        indexPage.goToURL(PageUrlCollection.JETI_ISSUE_ID_1.getUrl());
        Assertions.assertEquals("JETI-1",
                issuePage.getIssueKey(),
                "Issue key is not matching");
    }

    @Test
    public void browseIssueJETI_ID_2() {
        indexPage.goToURL(PageUrlCollection.JETI_ISSUE_ID_2.getUrl());
        Assertions.assertEquals("JETI-2",
                issuePage.getIssueKey(),
                "Issue key is not matching");
    }

    @Test
    public void browseIssueJETI_ID_3() {
        indexPage.goToURL(PageUrlCollection.JETI_ISSUE_ID_3.getUrl());
        Assertions.assertEquals("JETI-3",
                issuePage.getIssueKey(),
                "Issue key is not matching");
    }

}
