package loginTest;

import base.BaseLoginTest;
import org.junit.jupiter.api.Test;

public class LoginPageLoginTst extends BaseLoginTest {

    public LoginPageLoginTst() {
        super("https://jira-auto.codecool.metastage.net/login.jsp");
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
