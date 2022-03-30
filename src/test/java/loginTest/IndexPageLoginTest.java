package loginTest;

import base.BaseLoginTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import util.PageUrlCollection;


public class IndexPageLoginTest extends BaseLoginTest {

    public IndexPageLoginTest() {
        super(PageUrlCollection.INDEX.getUrl());
    }

    @Test
    public void successfulLoginTestOnIndexPage() {
        login();
        openProfilePage();
        Assertions.assertEquals("automation16", profilePage.getUsernameText(), "Username do not match!");
        logout();
    }

    @Test
    public void emptyCredentialsTestOnIndexPage(){
        emptyCredentialLogin();
        Assertions.assertEquals("Sorry, your username and password are incorrect - please try again.",
                indexPage.getWrongCredentialsText(), "Messages do not match!");
        login();
        logout();
    }

    @Test
    public void wrongPasswordLoginTestOnIndexPage(){
        wrongPasswordLogin();
        Assertions.assertEquals("Sorry, your username and password are incorrect - please try again.",
                indexPage.getWrongCredentialsText(), "Messages do not match!");
        login();
        logout();
    }
}
