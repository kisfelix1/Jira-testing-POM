package base;

import pages.ProfilePage;
import util.PageUrlCollection;
import util.WebDriverManager;

import java.util.List;

public class BaseLoginTest extends BaseTests{
    protected ProfilePage profilePage = new ProfilePage(driver);

    public BaseLoginTest(String url) {
        this.url = url;
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
}
