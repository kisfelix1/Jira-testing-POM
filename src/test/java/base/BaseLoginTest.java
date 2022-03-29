package base;

import org.junit.jupiter.api.Assertions;
import util.WebDriverManager;

import java.util.List;

public class BaseLoginTest extends BaseLogin{

    public BaseLoginTest(String url) {
        this.url = url;
    }


    public void emptyCredentialsTest(){
        indexPage.clickLoginButton();
        WebDriverManager.waitUntilVisible(driver, indexPage.getWrongCredentials());
        Assertions.assertEquals("Sorry, your username and password are incorrect - please try again.",
                indexPage.getWrongCredentialsText(), "Messages do not match!");
    }

    public void wrongPasswordLoginTest() {
        List<String> loginCredentials = indexPage.getLoginCredentials("invalid_password");
        indexPage.login(loginCredentials);
        WebDriverManager.waitUntilVisible(driver, indexPage.getWrongCredentials());
        Assertions.assertEquals("Sorry, your username and password are incorrect - please try again.",
                indexPage.getWrongCredentialsText(), "Messages do not match!");
    }
}
