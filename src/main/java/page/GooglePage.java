package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import static java.lang.Thread.sleep;


public class GooglePage extends BasePage {

    @FindBy(id = "lst-ib")
    private WebElement searchField;

    @FindBy(xpath = "//input[@type='button' and contains(@value, 'Google')]")
    private WebElement searchButton;


    public GooglePage(WebDriver webDriver) {

        super(webDriver);
        PageFactory.initElements(webDriver, this);

    }

    public boolean isPageLoaded() {

        return searchButton.isDisplayed();
    }

    public SearchResultsPage search(String searchTerm) throws InterruptedException {
        searchField.sendKeys(searchTerm);
        sleep(1000);
        searchButton.click();
        searchField.sendKeys(Keys.ENTER);
        return new SearchResultsPage(webDriver);


    }


}


