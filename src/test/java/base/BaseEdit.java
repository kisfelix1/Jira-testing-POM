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

    private final String OLD_SUMMARY_FOR_CANCEL = "Issue not to edit";
    private final String NEW_SUMMARY_FOR_CANCEL = "Edited";
    private final String OLD_TYPE_FOR_CANCEL = "Story";
    private final String NEW_TYPE_FOR_CANCEL = "Bug";


    public void clickEditButton(){
        issuePage.clickEditButton();
    }

    public void editIssueWithNewData(){
        issuePage.editIssueSummary(NEW_SUMMARY);
        issuePage.editIssueType(NEW_TYPE);
        issuePage.clickUpdateButton();
    }

    public void editIssueWithNewDataThenCancel(){
        issuePage.editIssueSummary(NEW_SUMMARY_FOR_CANCEL);
        issuePage.editIssueType(NEW_TYPE_FOR_CANCEL);
        issuePage.clickCancelOnScreen();
    }

    public void clickOnAlert(){
        issuePage.clickOnAlert();
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

    public boolean issueNotContainsNewDataAfterCancel(){
        return issuePage.isCorrectSummary(OLD_SUMMARY_FOR_CANCEL)
                && issuePage.isCorrectType(OLD_TYPE_FOR_CANCEL);
    }

    public void openDummyIssuePage(){
        driver.get(PageUrlCollection.EDIT_DUMMY_ISSUE.getUrl());
    }

    public void openDummyIssuePageForCancel() {
        driver.get(PageUrlCollection.CANCEL_EDIT_DUMMY_ISSUE.getUrl());
    }
}
