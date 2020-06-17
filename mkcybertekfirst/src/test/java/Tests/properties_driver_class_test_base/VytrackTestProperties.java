package Tests.properties_driver_class_test_base;

import Utilities.ConfigurationReader;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class VytrackTestProperties {
    @Test
    public void loginTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        String url = ConfigurationReader.get("url");

        driver.get(url);
       // Driver.get().get(ConfigurationReader.get("url1"));

//        String username = ConfigurationReader.get("salesmanager_username");
//        String password = ConfigurationReader.get("salesmanager_password");
//
//        VytrackUtils.login(driver, username, password);

    }
}
