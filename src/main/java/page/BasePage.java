package page;

import org.openqa.selenium.WebDriver;


/**
 * Base Page Object class
 */
public abstract class BasePage {
    protected WebDriver webDriver;


    /**
     * Constructor of BasePage
     *
     * @param webDriver - webDriver instance
     */
    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }


    /**
     * @return The current page is loaded
     */

    public abstract boolean  isPageLoaded();





}



