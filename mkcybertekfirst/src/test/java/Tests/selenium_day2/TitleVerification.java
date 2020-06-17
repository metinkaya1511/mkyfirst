package Tests.selenium_day2;
/*
        ASSIGNMENT2: VERIFY TITLE AND URL
        1.Create a new class TitleVerificationand create a mainmethod.
        2.Add this ArrayList declarationto the mainmethod:
            List<String> urls = Arrays.asList("http://practice.cybertekschool.com/",
            "http://practice.cybertekschool.com/dropdown","http://practice.cybertekschool.com/login");
        3.Visitall the websites and verify that they all have the same title.
        4.Verify that all url of all pages start with http://practice.cybertekschool.com.
        NOTE: Use the WebDriverFactory
         */
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class TitleVerification {
    public static void main(String[] args) {
        List <String> urls = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");
        // TODO VERIFY TITLE
        // go to the first website and verify title

        driver.get(urls.get(0)); //"http://practice.cybertekschool.com/"
        String expectedTitle = driver.getTitle();

        driver.get(urls.get(1));
        String actualTitle = driver.getTitle();

        verifyEquals(expectedTitle, actualTitle);

        driver.get(urls.get(2));
        actualTitle = driver.getTitle();

        verifyEquals(expectedTitle, actualTitle);

        // TODO VERIFY URL
        String expectedUrl = "http://practice.cybertekschool.com";
        for (String url : urls) {
            driver.get(url);
            String actualUrl = driver.getCurrentUrl();

            if (actualUrl.startsWith(expectedUrl)){
                System.out.println("PASS");
            } else {
                System.out.println("FAIL");
                System.out.println("actualUrl = " + actualUrl);
                System.out.println("expectedUrl = " + expectedUrl);
            }
        }
    }

    private static void verifyEquals(String expectedTitle, String actualTitle) {
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("actualTitle = " + actualTitle);
            System.out.println("expectedTitle = " + expectedTitle);
        }
    }
}