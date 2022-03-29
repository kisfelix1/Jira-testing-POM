package loginTest;

import base.BaseLoginTest;
import org.junit.jupiter.api.Test;

public class IndexPageLoginTest extends BaseLoginTest {

    public IndexPageLoginTest() {
        super("https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa");
    }

    @Test
    public void successfulLoginTestOnIndexPage() {
        successfulLoginTest();
    }

    @Test
    public void emptyCredentialsTestOnIndexPage(){
        emptyCredentialsTest();
    }

    @Test
    public void wrongPasswordLoginTestOnIndexPage(){
        wrongPasswordLoginTest();
    }
}
