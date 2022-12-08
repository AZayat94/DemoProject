package Base;

import Config.ConfigProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import pages.HomePage;

import java.io.IOException;
import java.time.Duration;

public class BaseTests {
    private static WebDriver driver;
    protected  HomePage HomePage;


    @BeforeClass
    public void setUp() throws IOException {
        ConfigProperties.InitializePropFile();
        if (ConfigProperties.properties.getProperty("BrowserType").equalsIgnoreCase("Chrome"))
        {
           // WebDriverManager.chromedriver().setup();
            //driver = new ChromeDriver();
             driver = new ChromeDriver();
        }
        else if (ConfigProperties.properties.getProperty("BrowserType").equalsIgnoreCase("FireFox"))
        {
            driver = new FirefoxDriver();
          //  WebDriverManager.firefoxdriver().create();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20)); // implicit wait
        driver.manage().window().maximize();
        driver.get(ConfigProperties.properties.getProperty("URL"));
        HomePage = new HomePage(driver);
    }

    public static WebDriver getDriver(){
        return driver;
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }


}