package base;

import org.junit.jupiter.api.Assertions;
import pages.IssuePage;
import util.PageUrlCollection;
import util.Util;
import util.WebDriverManager;

import java.io.IOException;
import java.util.List;

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
    private final int ISSUE_TYPE_COLUMN_INDEX = 1;
    private final int ISSUE_ID_COLUMN_INDEX = 2;
    private static final String EDIT_TEST_DATA_PATH = "src/test/resources/editIssue.csv";


    public void clickEditButton(){
        issuePage.clickEditButton();
    }

    public void editIssueWithNewData() throws InterruptedException {
        issuePage.editIssueSummary(NEW_SUMMARY);
        issuePage.editIssueType(NEW_TYPE);
        issuePage.clickUpdateButton();
        Thread.sleep(2000);
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
        clickEditButton();
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

    protected void isIssueEditable(String key){
        login();
        List<String> testData = getIssueData(key);
        String type = testData.get(ISSUE_TYPE_COLUMN_INDEX);
        String id = testData.get(ISSUE_ID_COLUMN_INDEX);
        openIssue(type, id);
        Assertions.assertTrue(isEditButtonVisible());
        logout();
    }

    private List<String> getIssueData(String key){
        try {
            return Util.getTestData(key, EDIT_TEST_DATA_PATH);
        } catch (IOException e){
            WebDriverManager.quitWebDriver(driver);
            return null;
        }
    }


    public boolean isEditButtonVisible(){
        return issuePage.hasEditButton();
    }

    public void openIssue(String issueName, String issueId){
        String url = String.format("https://jira-auto.codecool.metastage.net/projects/%s/issues/%s-%s", issueName, issueName, issueId);
        System.out.println(url);
        driver.get(url);
    }

    public void openDummyIssuePage(){
        driver.get(PageUrlCollection.EDIT_DUMMY_ISSUE.getUrl());
    }

    public void openDummyIssuePageForCancel() {
        driver.get(PageUrlCollection.CANCEL_EDIT_DUMMY_ISSUE.getUrl());
    }


}
