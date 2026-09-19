package screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchScreen {

    private final WebDriver driver;
    private static final int DEFAULT_WAIT_SECONDS = 20;

    private final By searchBxBfTap = AppiumBy.id("org.wikipedia:id/search_text_view");
    private final By searchBxAftTap = AppiumBy.id("org.wikipedia:id/search_src_text");
    private final By firstSrchResult = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.view.View\").instance(3)");

    public SearchScreen(WebDriver userDriver) {
        this.driver = userDriver;
    }


    public void searchforArticle(String searchItem) {
        // Enter search text
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_SECONDS));
        WebElement srchBxBfTap = wait.until(ExpectedConditions.elementToBeClickable(searchBxBfTap));
        srchBxBfTap.click();

        WebElement srchBxAftTap = wait.until(ExpectedConditions.elementToBeClickable(searchBxAftTap));
        srchBxAftTap.sendKeys(searchItem);
    }


    public ArticleScreen tapFirstSrchResult() {
        // Click on the first search result
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_SECONDS));
        WebElement firstResult = wait.until(ExpectedConditions.elementToBeClickable(firstSrchResult));
        firstResult.click();

        return new ArticleScreen(driver);
    }
}
