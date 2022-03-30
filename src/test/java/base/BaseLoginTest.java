package base;

import util.WebDriverManager;

public class BaseLoginTest extends BaseLogin{

    public BaseLoginTest(String url) {
        this.url = url;
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

    public void wrongPasswordLoginTest() {

    }


    public void openProfilePage(){
        driver.get(indexPage.getUserProfilePageUrl());
        WebDriverManager.waitUntilVisible(driver, profilePage.getUsername());
    }
}
