package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.Navigation;

public class ArticleSaveToClcn extends BaseTest {

    //Test Data Constants
    private static final String ARTICLE_TITLE = "Artificial intelligence";
    private static final String COLLECTION_NAME = "testClcn";


    @Test(priority = 1)
    public void testArticleSaveToClcn() {
        Navigation navigationObj = new Navigation(driver);
        try {

            // Step 2: Search for "Artificial Intelligence"
            System.out.println("Step 2: Searching for 'Artificial Intelligence'");
            var searchScreen = homeScreen.accessSearchScrn();
            searchScreen.searchforArticle(ARTICLE_TITLE);

            // Step 3: Open the first article in search results
            System.out.println("Step 3: Opening first article");
            var articleScreen = searchScreen.tapFirstSrchResult();

            // Step 4: Save the article and create a collection named "test"
            System.out.println("Step 4: Saving article to 'test' collection");
            articleScreen.saveArticleToNewCollection(COLLECTION_NAME);

            // Step 5: Navigate to the created collection
            System.out.println("Step 5: Navigating to the created collection");
            navigationObj.backToHomeScreen();
            var savedScreen = homeScreen.accessSavedScrn();
            savedScreen.accessClcnsTab();
            var collectionScreen = savedScreen.tapCollection(COLLECTION_NAME);

            // Step 6: Verify the article is in the created collection
            System.out.println("Step 6: Verifying article is in collection");
            String actualArticlTitle = collectionScreen.getArticleTitle(ARTICLE_TITLE);

            Assert.assertEquals(actualArticlTitle, ARTICLE_TITLE, "Article does not exist in collection!");



        } catch (Exception e) {
            System.err.println("Test failed with error: " + e.getMessage());
            e.printStackTrace();
            throw e;
        }
    }
}
