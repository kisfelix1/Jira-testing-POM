package pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.PageUrlCollection;
import util.WebDriverManager;

import java.util.List;

public class IndexPage {
    IssuePage issuePage;
    private final WebDriver driver;
    public static final int USERNAME_COLUMN_INDEX = 1;
    public static final int PASSWORD_COLUMN_INDEX = 2;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.issuePage = new IssuePage(driver);
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

    @FindBy(xpath = "//a[@class='aui-nav-link login-link']")
    WebElement headerLoginButton;

    @FindBy(xpath = "//p[@class='title']/strong")
    WebElement logoutNotification;

    @FindBy(xpath = "//a[@id='create_link']")
    WebElement createButton;

    @FindBy(xpath = "//input[@id='project-field']")
    WebElement projectInputField;

    @FindBy(xpath = "//input[@id='issuetype-field']")
    WebElement issueTypeField;

    @FindBy(xpath = "//input[@id='create-issue-submit']")
    WebElement createIssueCreateButton;

    @FindBy(xpath = "//a[@class='issue-created-key issue-link']")
    WebElement createIssuePopUp;

    @FindBy(xpath = "//input[@id='summary']")
    WebElement summaryInputField;

    @FindBy(xpath = "//button[@class='aui-button aui-button-link cancel']")
    WebElement cancelButton;

    public String getWrongCredentialsText(){
        return wrongCredentials.getText();
    }

    public WebElement getWrongCredentials() {
        return wrongCredentials;
    }

    public WebElement getUserIcon(){
        return userIcon;
    }

    public void setUsernameInputField(String userName){
        usernameInputField.sendKeys(userName);
    }

    public void setPasswordInputField(String password){
        passwordInputField.sendKeys(password);
    }

    public void clickLoginButton(){
        WebDriverManager.waitUntilVisible(driver, loginButton);
        loginButton.click();
    }

    public boolean isHeaderLoginButtonVisible() {
        return headerLoginButton.isDisplayed();
    }



    public void attemptLogin(List<String> loginCredentials){
        WebDriverManager.waitUntilVisible(driver, usernameInputField);
        setUsernameInputField(loginCredentials.get(USERNAME_COLUMN_INDEX));
        WebDriverManager.waitUntilVisible(driver, passwordInputField);
        setPasswordInputField(loginCredentials.get(PASSWORD_COLUMN_INDEX));
        WebDriverManager.waitUntilVisible(driver, loginButton);
        clickLoginButton();
    }

    public void successfulLogin(List<String> loginCredentials){
        attemptLogin(loginCredentials);
        WebDriverManager.waitUntilVisible(driver, getUserIcon());
    }

    public void logout(){
        driver.get(PageUrlCollection.INDEX.getUrl());
        try{
            WebDriverManager.waitUntilClickable(driver, userIcon);
        } catch (Exception e) {
            WebDriverManager.waitUntilClickable(driver, userIcon);
            e.printStackTrace();
        }
        userIcon.click();
        WebDriverManager.waitUntilVisible(driver, logoutButton);
        logoutButton.click();
        driver.get(PageUrlCollection.INDEX.getUrl());
    }

    public void openCreateIssueModal() {
        createButton.click();
        WebDriverManager.waitUntilVisible(driver, summaryInputField);
    }

    public void clickCreatedIssueLink() {
        WebDriverManager.waitUntilVisible(driver, createIssuePopUp);
        createIssuePopUp.click();
    }

    public void fillProjectInputField(String text){
        getProjectInputField().clear();
        getProjectInputField().click();
        getProjectInputField().sendKeys(text);
        getProjectInputField().sendKeys(Keys.TAB);
    }

    public String getSummaryIssueName(){
        WebDriverManager.waitUntilVisible(driver,issuePage.getIssueSummary());
        return issuePage.getSummaryText();
    }


    public void navigateToURL(String URL){
        WebDriverManager.waitUntilVisible(driver, createIssuePopUp);
        driver.get(URL);
    }

    public void fillSummaryInputField(){
        // second try
        try{
            WebDriverManager.waitUntilClickable(driver, summaryInputField);
        } catch (Exception e) {
            WebDriverManager.waitUntilClickable(driver, summaryInputField);
            e.printStackTrace();
        }
        summaryInputField.clear();
        summaryInputField.click();
        summaryInputField.sendKeys("MTP-8982431");
        summaryInputField.sendKeys(Keys.ENTER);
    }

    public WebElement getCreateIssueCreateButton() {
        return createIssueCreateButton;
    }


    public WebElement getProjectInputField() {
        try{
            WebDriverManager.waitUntilClickable(driver, projectInputField);
        } catch (Exception e) {
            WebDriverManager.waitUntilClickable(driver, projectInputField);
            e.printStackTrace();
        }
        return projectInputField;
    }

    public void clickCreateIssueButton() {
        WebDriverManager.waitUntilClickable(driver, getCreateIssueCreateButton());
        getCreateIssueCreateButton().click();
    }

    public void deleteIssue(){
        issuePage.moreButton.click();
        WebDriverManager.waitUntilClickable(driver,issuePage.deleteButton);
        issuePage.deleteButton.click();
        WebDriverManager.waitUntilClickable(driver,issuePage.getDeleteIssueSubmit());
        issuePage.getDeleteIssueSubmit().click();
    }

    public void clickToCancelButton(){
        cancelButton.click();
    }

    public void clickToAlert(){
        driver.switchTo().alert().accept();
    }

    public void goToURL(String url){
        driver.get(url);
    }

    public String getIssueTypeValue(){
        return issueTypeField.getAttribute("value");

    }

    public void setIssueTypeField(String text){

        try{
            WebDriverManager.waitUntilClickable(driver, issueTypeField);
        } catch (Exception e) {
            WebDriverManager.waitUntilClickable(driver, issueTypeField);
            e.printStackTrace();
        }
        issueTypeField.click();
        issueTypeField.sendKeys(Keys.DELETE);
        issueTypeField.sendKeys(text);
        issueTypeField.sendKeys(Keys.ENTER);
    }

}
