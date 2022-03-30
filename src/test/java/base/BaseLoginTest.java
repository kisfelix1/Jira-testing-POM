package base;

import pages.ProfilePage;
import util.PageUrlCollection;
import util.WebDriverManager;

public class BaseLoginTest extends BaseTests{
    protected ProfilePage profilePage = new ProfilePage(driver);

    public BaseLoginTest(String url) {
        super(url);
    }

    public void wrongPasswordLogin(){
        indexPage.login("invalid_password");
        waitForWrongLoginCredentialPopup();
    }

    public void emptyCredentialLogin() {
        indexPage.clickLoginButton();
        waitForWrongLoginCredentialPopup();
    }

    private void waitForWrongLoginCredentialPopup(){
        WebDriverManager.waitUntilVisible(driver, indexPage.getWrongCredentials());
    }


    public void openProfilePage(){
        driver.get(PageUrlCollection.PROFIL.getUrl());
        WebDriverManager.waitUntilVisible(driver, profilePage.getUsername());
    }
}
