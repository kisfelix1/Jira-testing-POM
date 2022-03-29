package loginTest;

import base.BaseLoginTest;
import org.junit.jupiter.api.Test;
import util.PageUrlCollection;

public class LoginPageLoginTst extends BaseLoginTest {

    public LoginPageLoginTst() {
        super(PageUrlCollection.LOGIN.getUrl());
    }

    @Test
    public void successfulLoginTestOnLoginPage() {
        successfulLoginTest();
    }

    @Test
    public void emptyCredentialsTestOnLoginPage(){
        emptyCredentialsTest();
    }

    @Test
    public void wrongPasswordLoginTestOnLoginPage(){
        wrongPasswordLoginTest();
    }
}
