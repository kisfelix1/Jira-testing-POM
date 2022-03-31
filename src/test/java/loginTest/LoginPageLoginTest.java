package loginTest;

import base.BaseLoginTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.PageUrlCollection;

public class LoginPageLoginTest extends BaseLoginTest {

    public LoginPageLoginTest() {
        super(PageUrlCollection.LOGIN.getUrl());
    }

    @Test
    public void successfulLoginTestOnLoginPage() {
        login();
        openProfilePage();
        Assertions.assertEquals(getLoggedInUserName(), profilePage.getUsernameText(), "Username do not match!");
        logout();
    }

    @Test
    public void emptyCredentialsTestOnLoginPage(){
        emptyCredentialLogin();
        Assertions.assertEquals("Sorry, your username and password are incorrect - please try again.",
                indexPage.getWrongCredentialsText(), "Messages do not match!");
        login();
        logout();
    }

    @Test
    public void wrongPasswordLoginTestOnLoginPage(){
        wrongPasswordLogin();
        Assertions.assertEquals("Sorry, your username and password are incorrect - please try again.",
                indexPage.getWrongCredentialsText(), "Messages do not match!");
        login();
        logout();
    }
}
