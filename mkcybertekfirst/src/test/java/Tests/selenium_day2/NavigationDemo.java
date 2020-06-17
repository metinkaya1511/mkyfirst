package Tests.selenium_day2;

import org.openqa.selenium.WebDriver;

public class NavigationDemo {
    public static void main(String[] args) throws InterruptedException {

//        System.setProperty("webdriver.chrome.driver",                  //driver we want to use
//                "/Users/metinkaya/Documents/Selenium/chromedriver");  //location of the file
//
//        WebDriver driver = new ChromeDriver();

        //yukaridaki declaration'i yapmak yerine BrowseFactory'den obje ile cagirdik:
        WebDriver driver = BrowserFactory.getDriver("chrome");

        //opening pages
        //get() --> open pages
        driver.get("http://practice.cybertekschool.com");
        System.out.println(driver.getTitle());  //Practice
        driver.manage().window().fullscreen();

        //navigate().to() --> navigate to this url and opens pages

        Thread.sleep(2000);

        driver.navigate().to("http://tripadvisor.com/");  //url is gonna change from "http://practice.cybertekschool.com"
                                                         //to http://google.com/
        System.out.println(driver.getTitle());  //TripAdvisor: Read Reviews, Compare Prices & Book
    }
}
