package createIssueTest;

import base.BaseIssueTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.PageUrlCollection;


public class CreateIssueTest extends BaseIssueTest {

    @Test
    public void createIssueMTP(){
        indexPage.fillProjectInputField("MTP");
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
        indexPage.fillProjectInputField("Main");
        indexPage.fillSummaryInputField();
        indexPage.clickToCancelButton();
        indexPage.clickToAlert();
        indexPage.goToURL(PageUrlCollection.MTP_ISSUE.getUrl());
        Assertions.assertEquals("No issues were found to match your search",
                issuePage.getIssuesH2Text(),
                "The text does not matching.");

    }

    @Test
    public void createIssueInCoalaProject(){
        indexPage.fillProjectInputField("COALA");
        Assertions.assertEquals("COALA project (COALA)",
                indexPage.getProjectInputField().getAttribute("value"),
                "Project name is not matching, because you can't create issues to this project.");
        indexPage.setIssueTypeField("Bug");
        Assertions.assertEquals("Bug", indexPage.getIssueTypeValue(),"Issue type not matching.");
        indexPage.setIssueTypeField("Story");
        Assertions.assertEquals("Story", indexPage.getIssueTypeValue(),"Issue type not matching.");
        indexPage.setIssueTypeField("Task");
        Assertions.assertEquals("Task", indexPage.getIssueTypeValue(),"Issue type not matching.");
    }

    @Test
    public void createIssueInJetiProject(){
        indexPage.fillProjectInputField("JETI");
        Assertions.assertEquals("JETI project (JETI)",
                indexPage.getProjectInputField().getAttribute("value"),
                "Project name is not matching, because you can't create issues to this project.");
        indexPage.setIssueTypeField("Bug");
        Assertions.assertEquals("Bug", indexPage.getIssueTypeValue(),"Issue type not matching.");

        indexPage.setIssueTypeField("Story");
        Assertions.assertEquals("Story", indexPage.getIssueTypeValue(),"Issue type not matching.");

        indexPage.setIssueTypeField("Task");
        Assertions.assertEquals("Task", indexPage.getIssueTypeValue(),"Issue type not matching.");

    }

    @Test
    public void createIssueInToucanProject(){

        indexPage.fillProjectInputField("TOUCAN");
        Assertions.assertEquals("TOUCAN project (TOUCAN)",
                indexPage.getProjectInputField().getAttribute("value"),
                "Project name is not matching, because you can't create issues to this project.");
        indexPage.setIssueTypeField("Bug");
        Assertions.assertEquals("Bug", indexPage.getIssueTypeValue(),"Issue type not matching.");

        indexPage.setIssueTypeField("Story");
        Assertions.assertEquals("Story", indexPage.getIssueTypeValue(),"Issue type not matching.");

        indexPage.setIssueTypeField("Task");
        Assertions.assertEquals("Task", indexPage.getIssueTypeValue(),"Issue type not matching.");

    }
}
