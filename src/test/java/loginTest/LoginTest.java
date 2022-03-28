package loginTest;

import base.BaseTests;
import org.junit.jupiter.api.Test;
import pages.IndexPage;

public class LoginTest extends BaseTests {
    IndexPage loginPage = new IndexPage(driver);

    @Test
    public void successfulLoginTest() {
        loginPage.setUsernameInputField(System.getenv("jira_username"));
        loginPage.setPasswordInputField(System.getenv("jira_password"));
        loginPage.clickLoginButton();
    }
}
