package base;

import org.junit.jupiter.api.BeforeEach;
import pages.IndexPage;
import pages.ProfilePage;
import util.PageUrlCollection;
import util.WebDriverManager;

import java.util.List;

public class BaseLoginTest extends BaseTests{
    protected ProfilePage profilePage = new ProfilePage(driver);

    public BaseLoginTest(String url) {
        super(url);
    }

    @Override
    @BeforeEach
    public void prepareTest() {
        openPage();
    }

    public void emptyCredentialLogin() {
        indexPage.clickLoginButton();
        waitForLoginFailPopupText();
    }

    public void wrongPasswordLogin(){
        List<String> loginCredentials = getLoginCredentials("invalid_password");
        indexPage.attemptLogin(loginCredentials);
        waitForLoginFailPopupText();
    }

    private void waitForLoginFailPopupText(){
        WebDriverManager.waitUntilVisible(driver, indexPage.getWrongCredentials());
    }


    public void openProfilePage(){
        driver.get(PageUrlCollection.PROFILE.getUrl());
        WebDriverManager.waitUntilVisible(driver, profilePage.getUsername());
    }

    protected String getLoggedInUserName(){
        return getLoginCredentials("valid").get(IndexPage.USERNAME_COLUMN_INDEX);
    }
}
