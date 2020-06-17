package Tests.PracticeOnCybertek.OfficeHours.OfficeHourVasyl.ExpediaTest;


import Utilities.Library;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class HomePageTests {
    //ONLY CSS HERE

    String flightsLocator = "#tab-flight-tab-hp";
    String flyingFromLocator = "#flight-origin-hp-flight";
    String flyingToLocator = "#flight-destination-hp-flight";
    String departingDateLocator = "#flight-departing-hp-flight";
    String returningDateLocator = "#flight-returning-hp-flight";
    String flightsSearchButtonLocator = "form[id='gcw-flights-form-hp-flight'] button[type='submit']";
    String airlineNamesLocator = "span[data-test-id='airline-name']";
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.expedia.com");
    }

    @Test
    public void test1() {
        //test data
        String flyingFrom = "Washington, DC (IAD-Washington Dulles Intl.)";
        String flyingTo = "London, England, UK (LON-All Airports)";
        String departingDate = "10/10/2019";
        String returningDate = "10/20/2019";

        String originalWindow = driver.getWindowHandle();

        driver.findElement(By.cssSelector(flightsLocator)).click();
        driver.findElement(By.cssSelector(flyingFromLocator)).sendKeys(flyingFrom);
        Library.sleep(2);

        driver.findElement(By.cssSelector(flyingToLocator)).sendKeys(flyingTo);
        Library.sleep(2);
        driver.findElement(By.cssSelector(returningDateLocator)).clear();
        driver.findElement(By.cssSelector(returningDateLocator)).sendKeys(returningDate);
        Library.sleep(2);
        driver.findElement(By.cssSelector(departingDateLocator)).sendKeys(departingDate, Keys.ENTER);
        Library.sleep(2);
//        driver.findElement(By.cssSelector(flightsSearchButtonLocator)).click();
        Set<String> windows = driver.getWindowHandles();
        for(String window: windows){
            if(!window.equals(originalWindow)){
                driver.switchTo().window(window);
                driver.close();
            }
        }
        driver.switchTo().window(originalWindow);
        Library.sleep(15);
        List<WebElement> elements = driver.findElements(By.cssSelector(airlineNamesLocator));
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
    }


    @AfterMethod
    public void teardown() {
        Library.sleep(2);
        driver.close();
    }

}