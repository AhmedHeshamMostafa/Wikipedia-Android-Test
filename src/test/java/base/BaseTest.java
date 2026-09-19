package base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.appmanagement.ApplicationState;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import screens.HomeScreen;
import util.ConfigReader;
import util.Onboarding;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

public class BaseTest {

    protected AndroidDriver driver;
    protected HomeScreen homeScreen;

    @BeforeClass
    public void setup() throws MalformedURLException, URISyntaxException {
        // Set up Appium capabilities using ConfigReader
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName(ConfigReader.getPlatformName());
        options.setDeviceName(ConfigReader.getDeviceName());
        options.setAppPackage(ConfigReader.getAppPackage());
        options.setAppActivity(ConfigReader.getAppActivity());
        options.setNoReset(ConfigReader.getNoReset());
        options.setAutoGrantPermissions(ConfigReader.getAutoGrantPermissions());

        // Initialize the driver
        driver = new AndroidDriver(new URI(ConfigReader.getAppiumServerUrl()).toURL(), options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigReader.getWaitTimeout()));

        wait.until(d ->
                driver.queryAppState(ConfigReader.getAppPackage()) == ApplicationState.RUNNING_IN_FOREGROUND
        );

        // Step 1: Launch app (already done in setup)
        System.out.println("Step 1: App is launched");
        
        // Skip onboarding if present
        Onboarding onboardingObj = new Onboarding(driver);
        onboardingObj.skipOnboardingIfPresent();
        
        // Initialize HomeScreen after onboarding
        homeScreen = new HomeScreen(driver);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("Test session ended");
        }
    }
}
