package browseProject;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.ProjectPage;
import util.PageUrlCollection;


public class BrowseProjectTest extends BaseTests {

    private final ProjectPage projectPage = new ProjectPage(driver);


    @Test
    public void browseMTPProject(){
        projectPage.navigateToNextUrl(PageUrlCollection.MTP_PROJECT.getUrl());
        Assertions.assertEquals("MTP",
                projectPage.getProjectKeyText(),
                "Key is not matching");
    }

    @Test
    public void browseTOUCANProject(){
        projectPage.navigateToNextUrl(PageUrlCollection.TOUCAN_PROJECT.getUrl());
        Assertions.assertEquals("TOUCAN",
                projectPage.getProjectKeyText(),
                "Key is not matching");
    }

    @Test
    public void browseJETIProject(){
        projectPage.navigateToNextUrl(PageUrlCollection.JETI_PROJECT.getUrl());
        Assertions.assertEquals("JETI",
                projectPage.getProjectKeyText(),
                "Key is not matching");
    }

    @Test
    public void browseCOALAProject(){
        projectPage.navigateToNextUrl(PageUrlCollection.COALA_PROJECT.getUrl());
        Assertions.assertEquals("COALA",
                projectPage.getProjectKeyText(),
                "Key is not matching");
    }

}
