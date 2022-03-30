package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.WebDriverManager;

import java.util.List;

public class IndexPage {
    private final WebDriver driver;
    public static final int USERNAME_COLUMN_INDEX = 1;
    public static final int PASSWORD_COLUMN_INDEX = 2;

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

    public String getLogoutNotificationText() {
        return logoutNotification.getText();
    }



    public void attemptLogin(List<String> loginCredentials){
        WebDriverManager.waitUntilVisible(driver, passwordInputField);
        setUsernameInputField(loginCredentials.get(USERNAME_COLUMN_INDEX));
        setPasswordInputField(loginCredentials.get(PASSWORD_COLUMN_INDEX));
        clickLoginButton();
    }

    public void successfulLogin(List<String> loginCredentials){
        attemptLogin(loginCredentials);
        WebDriverManager.waitUntilVisible(driver, getUserIcon());
    }

    public void logout(){
        userIcon.click();
        logoutButton.click();
    }



}
