package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.IndexPage;
import util.PageUrlCollection;
import util.Util;
import util.WebDriverManager;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public abstract class BaseTests {
    protected static WebDriver driver;
    protected IndexPage indexPage = new IndexPage(driver);
    protected String url;
    private static final String LOGIN_TEST_DATA_PATH = "src/test/resources/login.csv";

    public BaseTests() {
        this.url = PageUrlCollection.INDEX.getUrl();
    }

    public BaseTests(String url){
        this.url = url;
    }

    @BeforeAll
    public static void setChromeDriver() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setCapability("browseVersion", "94");
        chromeOptions.setCapability("platformName", "LINUX");
        driver = new RemoteWebDriver(new URL("http://gretsapdomain.ddns.net:4444/wd/hub/"), chromeOptions);
        driver.manage().window().maximize();
    }

    protected List<String> getLoginCredentials(String key){
        try {
            return Util.getTestData(key,LOGIN_TEST_DATA_PATH);
        }catch (IOException e){
            WebDriverManager.quitWebDriver(driver);
            return null;
        }
    }

    @BeforeEach
    public void prepareTest() {
        openPage();
        login();
    }

    @AfterEach
    public void logoutAfterTest(){
        logout();
    }

    protected void openPage() {
        driver.get(url);
    }

    @AfterAll
    static void tearDown(){
        WebDriverManager.quitWebDriver(driver);
    }

    protected void login(){
        List<String> loginCredentials = getLoginCredentials("valid");
        indexPage.successfulLogin(loginCredentials);
    }

    protected void logout(){
        indexPage.logout();
    }

    protected void refreshPage(){
        driver.navigate().refresh();
    }

}
