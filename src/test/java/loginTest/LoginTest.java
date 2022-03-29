package loginTest;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.IndexPage;
import pages.ProfilePage;
import util.WebDriverManager;

import java.util.List;

public class LoginTest extends BaseTests {
    IndexPage indexPage = new IndexPage(driver);
    ProfilePage profilePage = new ProfilePage(driver);

    @Test
    public void successfulLoginTestOnIndexPage() {
        List<String> loginCredentials = indexPage.getLoginCredentials("valid");
        indexPage.login(loginCredentials);
        WebDriverManager.waitUntilVisible(driver, indexPage.getUserIcon());
        driver.get(indexPage.getUserProfilePageUrl());
        WebDriverManager.waitUntilVisible(driver, profilePage.getUsername());
        Assertions.assertEquals("automation16", profilePage.getUsernameText(), "Username do not match!");
    }

    @Test
    public void emptyCredentialsTestOnIndexPage(){
        indexPage.clickLoginButton();
        WebDriverManager.waitUntilVisible(driver, indexPage.getWrongCredentials());
        Assertions.assertEquals("Sorry, your username and password are incorrect - please try again.",
                indexPage.getWrongCredentialsText(), "Messages do not match!");
    }

    @Test
    public void wrongPasswordLoginTestOnIndexPage(){
        List<String> loginCredentials = indexPage.getLoginCredentials("invalid_password");
        indexPage.login(loginCredentials);
        WebDriverManager.waitUntilVisible(driver, indexPage.getWrongCredentials());
        Assertions.assertEquals("Sorry, your username and password are incorrect - please try again.",
                indexPage.getWrongCredentialsText(), "Messages do not match!");
    }
}
