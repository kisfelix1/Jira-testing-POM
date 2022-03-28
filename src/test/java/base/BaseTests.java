package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTests {
    protected static WebDriver driver;

    @BeforeAll
    public static void setChromeDriver() {
        if (System.getProperty("os.name").equals("Linux")) {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        } else {
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        }
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeEach
    public void prepareTest() {
        goHomePage();
    }

    private void goHomePage() {
        driver.get("https://jira-auto.codecool.metastage.net/secure/Dashboard.jspa");
    }

    @AfterAll
    static void tearDown() {
        driver.close();
        driver.quit();
    }
}
