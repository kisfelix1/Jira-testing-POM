package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WebDriverManager;

public class IssuePage {
    private final WebDriver driver;

    public IssuePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='key-val']")
    WebElement issueKey;

    @FindBy(xpath = "//h1[@id='summary-val']")
    WebElement issueSummary;

    @FindBy(xpath = "//span[@id='type-val']")
    WebElement issueType;

    @FindBy(xpath = "//a[@id='edit-issue']")
    WebElement editIssueButton;

    @FindBy(xpath = "//input[@id='summary']")
    WebElement screenIssueSummary;

    @FindBy(xpath = "//input[@id='issuetype-field']")
    WebElement screenIssueType;

    @FindBy(xpath = "//input[@id='edit-issue-submit']")
    WebElement screenUpdateButton;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement screenCancelButton;

    public String getIssueKey() {
        return issueKey.getText();
    }

    public String getSummaryText() {
        return issueSummary.getText();
    }

    public String getTypeText() {
        return issueType.getText();
    }

    public void clickEditButton(){
        editIssueButton.click();
        WebDriverManager.waitUntilVisible(driver, screenUpdateButton);
    }

    public void editIssueSummary(String summary){
        screenIssueSummary.clear();
        screenIssueSummary.sendKeys(summary);
    }

    public void editIssueType(String type){
        screenIssueType.click();
        screenIssueType.sendKeys(type);
    }

    public void clickUpdateButton(){
        screenUpdateButton.click();
    }

    public boolean isCorrectSummary(String summary){
        WebDriverManager.waitUntilVisible(driver, issueSummary);
        return getSummaryText().equals(summary);
    }

    public boolean isCorrectType(String type){
        WebDriverManager.waitUntilVisible(driver, issueType);
        return getTypeText().equals(type);
    }

    public void clickCancelOnScreen(){
        screenCancelButton.click();
    }

    public void clickOnAlert(){
        driver.switchTo().alert().accept();
    }

    public void restartPageFactory(){
        PageFactory.initElements(driver, this);
    }
}
