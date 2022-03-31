package base;

import org.junit.jupiter.api.BeforeEach;
import pages.IssuePage;

public class BaseIssueTest extends BaseTests{

    protected IssuePage issuePage = new IssuePage(driver);

    @BeforeEach
    public void prepareCreateIssueTest() {
        indexPage.openCreateIssueModal();
    }
}
