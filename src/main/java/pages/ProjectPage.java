package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectPage {

    private final WebDriver driver;

    public ProjectPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//dl[@class='project-meta']/dd[last()]")
    WebElement projectKey;

    public String getProjectKeyText(){
        return projectKey.getText();
    }

    public void navigateToNextUrl(String url){
        driver.get(url);
    }

}
