package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IssuePage {
    private final WebDriver driver;

    public WebElement getIssueSummary() {
        return issueSummary;
    }

    public IssuePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='key-val']")
    WebElement issueKey;

    @FindBy(xpath = "//h1[@id='summary-val']")
    WebElement issueSummary;

    @FindBy(xpath = "//span[id='type-val']")
    WebElement issueStory;

    @FindBy(xpath = "//input[@id='delete-issue-submit']")
    WebElement deleteIssueSubmit;


    public String getIssueKey() {
        return issueKey.getText();
    }

    public WebElement getDeleteIssueSubmit() {
        return deleteIssueSubmit;
    }

    public String getSummaryText() {
        return issueSummary.getText();
    }

    public String getStoryText() {
        return issueStory.getText();
    }
}
