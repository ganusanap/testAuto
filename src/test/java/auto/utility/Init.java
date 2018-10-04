package auto.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Init {
    protected WebDriver driver = null;

    /**
     * This function is used for doing web driver setup.
     */
    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        System.out.println("*** Setup - Starting Test Case Execution ***");
        FirefoxProfile ffprofile = createFirefoxProfile();
        driver = new FirefoxDriver(ffprofile);
        driver.get("https://openweathermap.org/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    /**
     * This function is quit the driver instance.
     */
    @AfterMethod(alwaysRun = true)
    public void teardown() {
        System.out.println("*** Teardown - Test Case Executed ***");
        if (driver != null)
            driver.quit();

    }

    public FirefoxProfile createFirefoxProfile() {

        FirefoxProfile firefoxProfile = new FirefoxProfile();

        firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("browser.download.folderList", 2);
        firefoxProfile.setPreference("browser.download.dir", "E:\\git_projects\\download");
        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk",
                "text/csv,application/pdf,application/vnd.ms-excel,application/octet-stream");
        firefoxProfile.setPreference("pdfjs.disabled", true);

        return firefoxProfile;
    }
}
