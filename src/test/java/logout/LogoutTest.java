package logout;

import base.BaseLogout;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogoutTest extends BaseLogout {

    @Test
    public void logoutTest(){
        login();
        logout();
        Assertions.assertEquals("You are now logged out. Any automatic login has also been stopped.",
                indexPage.getLogoutNotificationText(),
                "The logout notification does not matching.");
    }

    @Override
    public void logoutAfterTest(){}
}
