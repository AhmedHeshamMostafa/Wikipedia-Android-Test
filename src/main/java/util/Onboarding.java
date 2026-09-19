package util;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Onboarding {

    private static final Logger log = LoggerFactory.getLogger(Onboarding.class);
    private final WebDriver driver;

    private final By skipBtn = AppiumBy.id("org.wikipedia:id/fragment_onboarding_skip_button");

    public Onboarding(WebDriver driver) {
        this.driver = driver;
    }

    public void skipOnboardingIfPresent() {
        try {
            // Try to find and click "Skip" button if onboarding is present
            WebElement skipButton = driver.findElement(skipBtn);
            skipButton.click();
        } catch (Exception _) {
            log.info("No onboarding screen found or already skipped");
        }
    }
}
