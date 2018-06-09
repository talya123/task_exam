package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class SearchResultsPage extends BasePage {

    @FindBy(xpath = "//div[@id='resultStats']")
    private WebElement searchResultsCount;

    //@FindBy(xpath = "//div[contains(@class, 'rc')]")
    //private List<WebElement> searchResultElements;

    @FindBy(xpath = "//span[contains(@class, 'st')]")
    private List<WebElement> searchResultElements;

    @FindBy(xpath = "//a[@aria-label='Page 2']")
    private WebElement goToNextPageLink;

    public SearchResultsPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        //waitUntilElementIsVisible(searchResultsCount, 5);
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


    public WebElement waitUntilElementIsVisible(WebElement webElement, int timeOutInSeconds) {
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }

    public SearchResultsNavigationPage clickOnPagingLink() {
        goToNextPageLink.click();
        return new SearchResultsNavigationPage(webDriver);
    }

    public void isTextPresent() {
        searchResultsCount.getText().contains("Приблизна кількість результатів");

    }
}



