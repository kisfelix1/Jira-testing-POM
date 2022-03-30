package pages;

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
    private final int USERNAME_COLUMN_INDEX = 1;
    private final int PASSWORD_COLUMN_INDEX = 2;

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



}
