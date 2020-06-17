package Tests.selenium_day2;

import org.openqa.selenium.WebDriver;

public class ClosingBrowsers {
    public static void main(String[] args) throws InterruptedException {

        closeSingleTab();
        closeOneOfManyTabs();
        closeEverything();
    }


    public static void closeSingleTab() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "/Users/metinkaya/Documents/Selenium/chromedriver");
//        WebDriver driver = new ChromeDriver();

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        Thread.sleep(2000);

        //close() --> closes single current tab
        driver.close();
    }
    public static void closeOneOfManyTabs() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(4000);

        //close --> closes current tab
        Thread.sleep(4000);

        //close the first one
        driver.close(); //url'yi kapatir ama browser acik kalir
        Thread.sleep(4000);

        driver.quit();
    }

    public static void closeEverything() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        Thread.sleep(4000);

        //quit --> closes everthing
        driver.quit();
    }
}
