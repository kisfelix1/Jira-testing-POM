package logout;

import base.BaseLogout;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LogoutTest extends BaseLogout {

    @Test
    public void logoutTest(){
        login();
        logout();
        Assertions.assertTrue(indexPage.isHeaderLoginButtonVisible(),
                "Header login button not visible");
    }

}
