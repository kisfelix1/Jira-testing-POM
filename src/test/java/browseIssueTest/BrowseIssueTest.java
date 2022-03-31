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
}
