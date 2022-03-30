package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage {

    private final WebDriver driver;
    public static final String MTP_PATH = "https://jira-auto.codecool.metastage.net/projects/MTP/summary";
    public static final String TOUCAN_PATH = "https://jira-auto.codecool.metastage.net/projects/TOUCAN/summary";
    public static final String JETI_PATH = "https://jira-auto.codecool.metastage.net/projects/JETI/summary";
    public static final String COALA_PATH = "https://jira-auto.codecool.metastage.net/projects/COALA/summary";


    public ProjectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//dl[@class='project-meta']/dd[last()]")
    WebElement projectKey;


    public String getProjectKeyText(){
        return projectKey.getText();
    }

}
