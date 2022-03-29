package loginTest;

import base.BaseLoginTest;
import org.junit.jupiter.api.Test;
import util.PageUrlCollection;

public class IndexPageLoginTest extends BaseLoginTest {

    public IndexPageLoginTest() {
        super(PageUrlCollection.INDEX.getUrl());
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
