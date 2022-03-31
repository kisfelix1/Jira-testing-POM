package base;

import org.junit.jupiter.api.BeforeEach;

public class BaseLogout extends BaseTests{

    @Override
    @BeforeEach
    public void prepareTest() {
        openPage();
    }
}
