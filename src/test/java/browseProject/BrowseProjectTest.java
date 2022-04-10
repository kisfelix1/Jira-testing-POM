package browseProject;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import pages.ProjectPage;


public class BrowseProjectTest extends BaseTests {

    private final ProjectPage projectPage = new ProjectPage(driver);

    @ParameterizedTest
    @ValueSource(strings = {"MTP","TOUCAN","JETI","COALA"})
    public void browseAllProjectTest(String input){
        projectPage.navigateToNextUrl(String.format("https://jira-auto.codecool.metastage.net/projects/%s/summary", input));
        Assertions.assertEquals(input,
                projectPage.getProjectKeyText(),
                "Key is not matching");
    }
}
