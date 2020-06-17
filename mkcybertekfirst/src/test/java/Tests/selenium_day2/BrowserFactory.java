package Tests.selenium_day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//ASSIGNMENT 1: DRIVER FACTORY
// 1.Create class BrowserFactory.
// 2.Create a public static methodgetDriver which takes a string argument.
// 3.If argument is equal to chrome, method should return new ChromeDriverobject.
//      If argument is equal to firefox method should return new FirefoxDriver.
//      Return null inall other cases.
// 4.Create a different class to test the BrowserFactory class.

public class BrowserFactory {

    public static WebDriver getDriver(String browser){
        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver",
                    "/Users/metinkaya/Documents/Selenium/chromedriver");
            return new ChromeDriver();

        } else if (browser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver",
                    "/Users/metinkaya/Documents/Selenium/geckodriver");
            ///Users/metinkaya/Documents/Selenium/geckodriver
            return new FirefoxDriver();

        } else {
            return null;
        }
    }
}