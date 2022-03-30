package loginTest;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogoutTest extends BaseTests {

    @Test
    public void logoutTest(){
        login();
        logout();
        Assertions.assertEquals("You are now logged out. Any automatic login has also been stopped.",
                indexPage.getLogoutNotificationText(),
                "The logout notification does not matching.");
    }
}
