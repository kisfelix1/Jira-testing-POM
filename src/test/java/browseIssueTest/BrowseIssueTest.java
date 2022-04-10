package browseIssueTest;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import pages.IndexPage;
import pages.IssuePage;

public class BrowseIssueTest extends BaseTests {

    IndexPage indexPage = new IndexPage(driver);
    IssuePage issuePage = new IssuePage(driver);

    @ParameterizedTest
    @CsvFileSource(resources = "/issueName.csv", numLinesToSkip = 1)
    public void browseAllIssue(String input, String projectName, String expected){
        indexPage.goToURL(String.format("https://jira-auto.codecool.metastage.net/projects/%s/issues/%s?filter=allopenissues",projectName, input));
        Assertions.assertEquals(expected,
                issuePage.getIssueKey(),
                "Issue key is not matching");
    }
}
