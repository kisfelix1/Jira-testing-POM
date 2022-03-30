package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.IndexPage;
import util.PageUrlCollection;
import util.WebDriverManager;

public abstract class BaseTests {
    protected static WebDriver driver;
    protected IndexPage indexPage = new IndexPage(driver);
    protected String url;

    public BaseTests() {
        this.url = PageUrlCollection.INDEX.getUrl();
    }

    public BaseTests(String url){
        this.url = url;
    }

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
        openPage();
    }

    protected void openPage() {
        driver.get(url);
    }

    @AfterAll
    static void tearDown(){
        WebDriverManager.quitWebDriver(driver);
    }

    protected void login(){
        indexPage.successfulLogin();
    }

    protected void logout(){
        indexPage.logout();
    }

}
