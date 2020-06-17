package Tests.selenium_day2;
import org.openqa.selenium.WebDriver;

public class TestingBrowserFactory {

    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("firefox");

        driver.get("https://cybertekschool.com");
    }
}
