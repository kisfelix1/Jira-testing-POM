package base;

import pages.IssuePage;
import util.PageUrlCollection;
import util.WebDriverManager;

public class BaseEdit extends BaseTests{
    protected IssuePage issuePage = new IssuePage(driver);
    private final String OLD_SUMMARY = "Test issue for edit";
    private final String NEW_SUMMARY = "Edited";
    private final String OLD_TYPE = "Story";
    private final String NEW_TYPE = "Task";

    public void clickEditButton(){
        issuePage.clickEditButton();
    }

    public void editIssueWithNewData(){
        issuePage.editIssueSummary(NEW_SUMMARY);
        issuePage.editIssueType(NEW_TYPE);
        issuePage.clickUpdateButton();
    }

    public void revertIssueToOldData(){
        issuePage.editIssueSummary(OLD_SUMMARY);
        issuePage.editIssueType(OLD_TYPE);
        issuePage.clickUpdateButton();
    }

    public boolean issueContainsOldData(){
        return issuePage.isCorrectSummary(OLD_SUMMARY)
                && issuePage.isCorrectType(OLD_TYPE);
    }

    public boolean issueContainsNewData(){
        return issuePage.isCorrectSummary(NEW_SUMMARY)
                && issuePage.isCorrectType(NEW_TYPE);
    }

    public void openDummyIssuePage(){
        driver.get(PageUrlCollection.EDIT_DUMMY_ISSUE.getUrl());
    }
}
