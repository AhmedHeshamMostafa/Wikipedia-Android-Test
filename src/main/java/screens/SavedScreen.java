package screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SavedScreen {

    private final WebDriver driver;
    private static final int DEFAULT_WAIT_SECONDS = 20;

    private final By clcnsTab = AppiumBy.androidUIAutomator("new UiSelector().text(\"Collections\")");

    public SavedScreen(WebDriver userDriver){
        this.driver = userDriver;
    }

    private By getCollectionLocator(String collectionName) {
        By clcnItem = AppiumBy.xpath("//android.widget.TextView[@text='" + collectionName + "']");
        return clcnItem;
    }

    public void accessClcnsTab(){
        // Click the Collections tab
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_SECONDS));
        WebElement collectionsTab = wait.until(ExpectedConditions.elementToBeClickable(clcnsTab));
        collectionsTab.click();
    }


    public CollectionScreen tapCollection(String collectionName){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_SECONDS));
        WebElement collectionItem = wait.until(ExpectedConditions.elementToBeClickable(getCollectionLocator(collectionName)));
        collectionItem.click();

        return new CollectionScreen(driver);
    }
}
