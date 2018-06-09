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


public class SearchResultsNavigationPage extends BasePage {


    @FindBy(xpath ="//*[@id='navcnt']")
    private WebElement searchResultsCount;

    @FindBy(xpath = "//a[contains(@aria-label, 'Page 2')]")
    private List<WebElement> searchResultElements;


    public SearchResultsNavigationPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
        //waitUntilElementIsVisible(searchResultsCount, 5);
    }

    public boolean isPageLoaded() {
        return searchResultsCount.isDisplayed();
    }

       }








