package createIssueTest;

import base.BaseIssueTest;
import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CreateIssueTest extends BaseIssueTest {

    @BeforeEach
    public void prepareCreateIssueTest() {
        login();
        indexPage.openCreateIssueModal();
    }

    @Test
    public void createIssueMTP() throws IOException{
        indexPage.fillCreateIssueForMTP();
        indexPage.clickCreateIssueCreateButton();
        indexPage.clickCreatedIssueLink();
        Assertions.assertEquals(indexPage.getPopUpIssueKey(), issuePage.getIssueKey());
        Assertions.assertEquals("0", issuePage.getSummaryText());
        Assertions.assertEquals("0", issuePage.getStoryText());
    }
}
