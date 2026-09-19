package screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomeScreen {

    private final WebDriver driver;
    private static final int DEFAULT_WAIT_SECONDS = 20;

    private final By searchIcon = AppiumBy.id("org.wikipedia:id/nav_tab_search");
    private final By savedIcon = AppiumBy.accessibilityId("Saved");

    public HomeScreen(WebDriver userDriver) {
        this.driver = userDriver;
    }

    public SearchScreen accessSearchScrn() {
        // Click on search container/button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_SECONDS));
        WebElement searchContainer = wait.until(ExpectedConditions.presenceOfElementLocated(searchIcon));
        searchContainer.click();

        return new SearchScreen(driver);
    }

    public SavedScreen accessSavedScrn() {
        // Click on the bottom navigation "Saved" tab
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_SECONDS));
        WebElement savedTab = wait.until(ExpectedConditions.elementToBeClickable(savedIcon));
        savedTab.click();

        return new SavedScreen(driver);
    }
}
