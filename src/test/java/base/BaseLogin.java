package base;

import org.junit.jupiter.api.Assertions;
import pages.IndexPage;
import pages.ProfilePage;
import util.WebDriverManager;

public class BaseLogin extends BaseTests{
    protected IndexPage indexPage = new IndexPage(driver);
    protected ProfilePage profilePage = new ProfilePage(driver);
    protected String url;

    public BaseLogin() {
        this.url = "https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa";
    }

    @Override
    void openPage() {
        driver.get(url);
    }

    public void successfulLoginTest(){
        indexPage.successfulLogin();
        driver.get(indexPage.getUserProfilePageUrl());
        WebDriverManager.waitUntilVisible(driver, profilePage.getUsername());
        Assertions.assertEquals("automation16", profilePage.getUsernameText(), "Username do not match!");
    }
}
