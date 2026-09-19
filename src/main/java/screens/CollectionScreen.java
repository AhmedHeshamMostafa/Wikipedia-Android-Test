package screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CollectionScreen {

    private final WebDriver driver;
    private static final int DEFAULT_WAIT_SECONDS = 20;


    public CollectionScreen(WebDriver userDriver){
        this.driver = userDriver;
    }


    private By getArticleLocator(String articleTitle) {
        By articleItem = AppiumBy.xpath("//android.widget.TextView[contains(@text, '" + articleTitle + "')]");
        return articleItem;
    }


    public String getArticleTitle(String expectedArticleTitle) {
        // Verify that the article is present in the collection
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_SECONDS));
        WebElement articleTitle = wait.until(ExpectedConditions.presenceOfElementLocated(getArticleLocator(expectedArticleTitle)));
        return articleTitle.getText();
    }
}
