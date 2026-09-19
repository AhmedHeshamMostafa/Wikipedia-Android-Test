package screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ArticleScreen {

    private final WebDriver driver;
    private static final int DEFAULT_WAIT_SECONDS = 20;

    private final By saveIcon = AppiumBy.accessibilityId("Save");
    private final By crtNewClcnBtn = AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Button\")");
    private final By clcnNameTxtField = AppiumBy.id("org.wikipedia:id/text_input");
    private final By oktoCrtClcnBtn = AppiumBy.id("android:id/button1");


    public ArticleScreen(WebDriver userDriver) {
        this.driver = userDriver;
    }


    public void tapSaveIcon(){
        // Click on the save button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_SECONDS));
        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(saveIcon));
        saveButton.click();
    }


    public void createNewCollection(String collectionName){
        // Click on "Create new Collection" button
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_SECONDS));
        WebElement crtNewCollectionBtn = wait.until(ExpectedConditions.elementToBeClickable(crtNewClcnBtn));
        crtNewCollectionBtn.click();

        // Enter collection name
        WebElement clcnNameInput = wait.until(ExpectedConditions.elementToBeClickable(clcnNameTxtField));
        clcnNameInput.sendKeys(collectionName);

        // Click OK to create collection
        WebElement okButton = driver.findElement(oktoCrtClcnBtn);
        okButton.click();
    }


    public void saveArticleToNewCollection(String collectionName) {
        tapSaveIcon();
        createNewCollection(collectionName);
    }
}
