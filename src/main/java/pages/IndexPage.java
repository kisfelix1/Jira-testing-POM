package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IndexPage {
    private final WebDriver driver;

    public IndexPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='login-form-username']")
    WebElement usernameInputField;

    @FindBy(xpath = "//input[@id='login-form-password']")
    WebElement passwordInputField;

    @FindBy(xpath = "//input[@id='login']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@id='usernameerror']")
    WebElement wrongCredentialsText;

    public void setUsernameInputField(String username){
        usernameInputField.sendKeys(username);
    }

    public void setPasswordInputField(String password){
        passwordInputField.sendKeys(password);
    }

    public void clickLoginButton(){
        loginButton.click();
    }

}
