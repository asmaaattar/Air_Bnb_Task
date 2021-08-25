package Project_Base.Base;

import Project_Base.Utilities.Helper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.security.PublicKey;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class Test_Base extends Objects {

    public static WebDriver driver;
    public Actions action;
    public static WebDriverWait wait;
    public static String Downloads_path = System.getProperty("user.dir") + "\\Downloads";
    public String Base_URL = "http://www.airbnb.com/";
    //public String Base_URL ="https://www.airbnb.com/rooms/22137442?adults=2&children=1&check_in=2021-09-24&check_out=2021-09-30&translate_ugc=false&federated_search_id=54d3f7f8-830f-40af-b58c-4f104cd51935&source_impression_id=p3_1629836700_uCBJmryhqehjC7WO&guests=1";

    //Setting up Google_Chrome options
    public static ChromeOptions chromeOption() {

        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities caps = new DesiredCapabilities();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("profile.default.content_settings.popups", 0);
        chromePrefs.put("download.default_directory", Downloads_path);
        options.setExperimentalOption("prefs", chromePrefs);
        caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        return options;
    }

    @BeforeSuite
    @Parameters({"browser"})
    public void Start_Driver(@Optional("Chrome") String Browser_name) {


        // Setting up The Drivers Based on the name Parameters send from .XMl file
        if (Browser_name.equalsIgnoreCase("Chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(chromeOption());
        }
        // Setting up The Drivers for headless browser testing
        else if (Browser_name.equalsIgnoreCase("chrome-headless")) {
            System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "/drivers/chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);
        }
        wait = new WebDriverWait(driver, 30);
        action = new Actions(driver);


        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        //Navigating to Base_URL
        driver.navigate().to(Base_URL);
    }



    @AfterMethod
    public void screen_shot_On_Failure(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Failed!");
            Helper.captureScreenshot(driver, result.getName());
        }
    }

    @AfterSuite
    public void Stop_Driver() {
        driver.quit();
    }
}
