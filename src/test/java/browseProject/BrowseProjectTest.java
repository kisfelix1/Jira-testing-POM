package browseProject;

import base.BaseTests;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;
import pages.IndexPage;
import pages.ProjectPage;

public class BrowseProjectTest extends BaseTests {

    private IndexPage indexPage = new IndexPage(BaseTests.driver);



    @Test
    public void browseMTPProject(){
        indexPage.login("valid");
        driver.get(ProjectPage.MTP_PATH);
        //Assertions.assertEquals("MTP", projectPage.getProjectKeyText(), "Key is not matching");
    }

    @Test
    public void browseTOUCANProject(){
        login();
        driver.get(ProjectPage.TOUCAN_PATH);
        //Assertions.assertEquals("TOUCAN", projectPage.getProjectKeyText(), "Key is not matching");
    }

    @Test
    public void browseJETIProject(){
        login();
        driver.get(ProjectPage.JETI_PATH);
        //Assertions.assertEquals("JETI", projectPage.getProjectKeyText(), "Key is not matching");
    }

    @Test
    public void browseCOALAProject(){
        login();
        driver.get(ProjectPage.COALA_PATH);
        //Assertions.assertEquals("COALA", projectPage.getProjectKeyText(), "Key is not matching");
    }
}
