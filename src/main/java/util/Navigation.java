package util;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import screens.HomeScreen;

import java.time.Duration;

public class Navigation {

    private final WebDriver driver;

    private final By homeScreenIndicator = AppiumBy.id("org.wikipedia:id/nav_tab_search");

    public Navigation(WebDriver driver) {
        this.driver = driver;
    }

    public HomeScreen backToHomeScreen() {

        WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(2));

        int maxAttempts = 10;

        for (int i = 0; i < maxAttempts; i++) {
            try {
                // Check if Home Screen element is visible
                shortWait.until(ExpectedConditions.visibilityOfElementLocated(homeScreenIndicator));
                return new HomeScreen(driver); // Found it, return
            } catch (Exception _) {
                // Not on Home Screen yet, press back
                driver.navigate().back();
            }
        }

        // Final check
        return new HomeScreen(driver);
    }
}
