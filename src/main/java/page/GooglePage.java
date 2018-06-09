package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.lang.Thread.sleep;


public class GooglePage extends BasePage {

    @FindBy(id = "lst-ib")
    private WebElement searchField;

    @FindBy(xpath = "//input[@type='button' and contains(@value, 'Google')]")
    private WebElement searchButton;


    public GooglePage(WebDriver webDriver) {

        super(webDriver);
        PageFactory.initElements(webDriver, this);
        //waitUntilElementIsVisible(searchButton, 5);
    }

    public boolean isPageLoaded() {

        return searchButton.isDisplayed();
    }

    public SearchResultsPage search(String searchTerm) throws InterruptedException {
        searchField.sendKeys(searchTerm);
        sleep(1000);
        //searchField.sendKeys(Keys.RETURN);
        searchButton.click();
        searchField.sendKeys(Keys.ENTER);
        return new SearchResultsPage(webDriver);


    }

    public WebElement waitUntilElementIsVisible (WebElement webElement, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(webDriver, timeOutInSeconds);
        wait.until(ExpectedConditions.visibilityOf(webElement));
        return webElement;
    }

    //public  login(String email, String password) {
    //loginField.sendKeys(email);
    //passwordField.sendKeys(password);
    //loginButton.click();
    //return PageFactory.initElements(webDriver, LinkedinHomePage.class);
    // or
    //return new LinkedinHomePage(webDriver);
}


