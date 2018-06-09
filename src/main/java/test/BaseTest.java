package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import page.GooglePage;


public class BaseTest {
    WebDriver webDriver;
    GooglePage googlePage;


    @Parameters({"browserType", "envURL"})
    @BeforeMethod
    public void beforeTest(@Optional("chrome") String browserType,
                           @Optional("https://www.google.com/") String envURL) {

        switch (browserType.toLowerCase()){
            case "firefox" :
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
                break;
            default :
                WebDriverManager.firefoxdriver().setup();
                webDriver = new FirefoxDriver();
        }

        webDriver.navigate().to(envURL);
        googlePage = new GooglePage(webDriver);

    }
    @AfterMethod
    public void after() {
        webDriver.close();
    }


}


