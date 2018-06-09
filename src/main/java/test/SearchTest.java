package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.SearchResultsNavigationPage;
import page.SearchResultsPage;


import java.util.List;

import static java.lang.Thread.sleep;


public class SearchTest extends BaseTest {

    @Test
    public void SearchTest() throws InterruptedException {
        String searchTerm = "Selenium";


        SearchResultsPage searchResultsPage = googlePage.search(searchTerm);

        Assert.assertTrue(searchResultsPage.isPageLoaded(),
                "SearchResults Page is not loaded.");

        sleep(5000);

        List<String> searchResultsList = searchResultsPage.getSearchResults();
        Assert.assertEquals(searchResultsList.size(), 11,
                "Count of search result items is wrong.");

        sleep(5000);

        for (String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "Searchterm " + searchTerm + " was not found in: \n" + searchResult);
        }


        SearchResultsNavigationPage searchResultsNavigationPage = searchResultsPage.clickOnPagingLink();



           Assert.assertTrue(searchResultsNavigationPage.isPageLoaded(),
                    "SearchResultsNavigation Page is not loaded.");

           sleep(5000);

        searchResultsPage.getSearchResults();
        Assert.assertEquals(searchResultsList.size(), 11,
                "Count of search result items is wrong.");

        sleep(5000);

        for (String searchResult : searchResultsList) {
            Assert.assertTrue(searchResult.toLowerCase().contains(searchTerm.toLowerCase()),
                    "Searchterm " + searchTerm + " was not found in: \n" + searchResult);
        }

        }
    }




