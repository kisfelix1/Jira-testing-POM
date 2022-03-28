package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
    protected static WebDriver driver;

    @BeforeAll
    public static void setChromeDriver() {
        if (System.getProperty("os.name").equals("Linux")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        }
    }

    @BeforeEach
    public void prepareTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        goHomePage();
    }

    private void goHomePage(){
        driver.get("https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa");
    }

    @AfterEach
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
