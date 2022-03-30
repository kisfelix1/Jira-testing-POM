package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.Util;
import util.WebDriverManager;

import java.io.IOException;
import java.util.List;

public class IndexPage {
    private final WebDriver driver;
    private static final String LOGIN_TEST_DATA_PATH = "src/test/resources/login.csv";
    private static final String ISSUE_TEST_DATA_PATH = "src/test/resources/create_issue.csv";
    private final int USERNAME_COLUMN_INDEX = 1;
    private final int PASSWORD_COLUMN_INDEX = 2;
    private final int PROJECT_NAME_COLUMN_INDEX = 1;
    private final int ISSUE_TYPE_COLUMN_INDEX = 2;
    private final int SUMMARY_COLUMN_INDEX = 3;
    private String popUpIssueKey = "";

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='login-form-username']")
    WebElement usernameInputField;

    @FindBy(xpath = "//input[@id='login-form-password']")
    WebElement passwordInputField;

    @FindBy(xpath = "//input[@name='login']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class='aui-message aui-message-error']/p")
    WebElement wrongCredentials;

    @FindBy(xpath = "//a[@id='header-details-user-fullname']")
    WebElement userIcon;

    @FindBy(xpath = "//a[@id='log_out']")
    WebElement logoutButton;

    @FindBy(xpath = "//p[@class='title']/strong")
    WebElement logoutNotification;

    @FindBy(xpath = "//a[@id='create_link']")
    WebElement createButton;

    @FindBy(xpath = "//section[@id='create-issue-dialog']")
    WebElement createIssueModal;

    @FindBy(xpath = "//input[@id='project-field']")
    WebElement projectInputField;

    @FindBy(xpath = "//input[@id='issuetype-field']")
    WebElement issueTypeField;

    @FindBy(xpath = "//input[@id='summary']")
    WebElement summaryInputField;

    @FindBy(xpath = "//input[@id='create-issue-submit']")
    WebElement createIssueCreateButton;

    @FindBy(xpath = "//a[contains(text(), ' has been successfully created.')]")
    WebElement createIssuePopUp;

    public String getWrongCredentialsText(){
        return wrongCredentials.getText();
    }

    public WebElement getWrongCredentials() {
        return wrongCredentials;
    }

    public WebElement getUserIcon(){
        return userIcon;
    }

    public void setUsernameInputField(List<String> data){
        usernameInputField.sendKeys(data.get(USERNAME_COLUMN_INDEX));
    }

    public void setPasswordInputField(List<String> data){
        passwordInputField.sendKeys(data.get(PASSWORD_COLUMN_INDEX));
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public String getLogoutNotificationText() {
        return logoutNotification.getText();
    }

    public List<String> getLoginCredentials(String key){
        try {
            return Util.getTestData(key,LOGIN_TEST_DATA_PATH);
        }catch (IOException e){
            WebDriverManager.quitWebDriver(driver);
            return null;
        }
    }

    public void login(String key){
        List<String> loginCredentials = getLoginCredentials(key);
        setUsernameInputField(loginCredentials);
        setPasswordInputField(loginCredentials);
        clickLoginButton();
    }

    public void successfulLogin(){
        login("valid");
        WebDriverManager.waitUntilVisible(driver, getUserIcon());
    }

    public void logout(){
        userIcon.click();
        logoutButton.click();
    }

    public void openCreateIssueModal() {
        createButton.click();
        WebDriverManager.waitUntilVisible(driver, summaryInputField);
    }

    public void fillCreateIssueForMTP() throws IOException{
        String key = "MTP";
        List<String> data = getIssueData(key);
        setSummaryInputField(data);
        setIssueTypeField(data);
//        setProjectInputField(data);
    }

    public void setProjectInputField(List<String> data) {
        projectInputField.sendKeys(getProjectNameData(data));
    }

    public void setIssueTypeField(List<String> data) {
        issueTypeField.sendKeys(Keys.CONTROL, "a");
        issueTypeField.sendKeys(Keys.DELETE);
        issueTypeField.sendKeys(getIssueTypeData(data));
    }

    public void setSummaryInputField(List<String> data) {
        summaryInputField.sendKeys(getSummaryData(data));
    }

    public void clickCreateIssueCreateButton() {
        createIssueCreateButton.click();
    }

    public void clickCreatedIssueLink() {
        WebDriverManager.waitUntilVisible(driver, createIssuePopUp);
        popUpIssueKey = getCreatedIssueKey();
        createIssuePopUp.click();
    }

    public String getCreatedIssueKey() {
        return createIssuePopUp.getAttribute("data-issue-key");
    }

    public String getPopUpIssueKey() {
        return popUpIssueKey;
    }

    public List<String> getIssueData(String key) throws IOException {
        return Util.getTestData(key,ISSUE_TEST_DATA_PATH);
    }

    public String getProjectNameData(List<String> issueData) {
        return issueData.get(PROJECT_NAME_COLUMN_INDEX);
    }

    public String getIssueTypeData(List<String> issueData) {
        return issueData.get(ISSUE_TYPE_COLUMN_INDEX);
    }

    public String getSummaryData(List<String> issueData) {
        return issueData.get(SUMMARY_COLUMN_INDEX);
    }


}
