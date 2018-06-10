package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;


public class SearchResultsNavigationPage extends BasePage {

    @FindBy(xpath = "//div[@id='topabar']/div[@class='ab_tnav_wrp']")
    private WebElement searchResultsCount;

    @FindBy(xpath ="//*[@id='navcnt']")
    private WebElement navigationPanel;

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResultElements;


    public SearchResultsNavigationPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);

    }

    public boolean isPageLoaded() {
          return searchResultsCount.isDisplayed();
    }


    public List<String> getSearchResults() {
        List<String> searchResultsList = new ArrayList();
        for (WebElement searchResultElement : searchResultElements) {
            ((JavascriptExecutor) webDriver)
                    .executeScript("arguments[0].scrollIntoView();", searchResultElement);
            String searchResultText = searchResultElement.getText();
            searchResultsList.add(searchResultText);
        }

        return searchResultsList;
    }

       }








