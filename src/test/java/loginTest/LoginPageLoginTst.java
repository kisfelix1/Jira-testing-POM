package loginTest;

import base.BaseLoginTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.PageUrlCollection;

public class LoginPageLoginTst extends BaseLoginTest {

    public LoginPageLoginTst() {
        super(PageUrlCollection.LOGIN.getUrl());
    }

    @Test
    public void successfulLoginTestOnLoginPage() {
        indexPage.successfulLogin();
        openProfilePage();
        Assertions.assertEquals("automation16", profilePage.getUsernameText(), "Username do not match!");

    }

    @Test
    public void emptyCredentialsTestOnLoginPage(){
        emptyCredentialLogin();
        Assertions.assertEquals("Sorry, your username and password are incorrect - please try again.",
                indexPage.getWrongCredentialsText(), "Messages do not match!");
        indexPage.successfulLogin();
    }

    @Test
    public void wrongPasswordLoginTestOnLoginPage(){
        wrongPasswordLogin();
        Assertions.assertEquals("Sorry, your username and password are incorrect - please try again.",
                indexPage.getWrongCredentialsText(), "Messages do not match!");
        indexPage.successfulLogin();
    }
}
