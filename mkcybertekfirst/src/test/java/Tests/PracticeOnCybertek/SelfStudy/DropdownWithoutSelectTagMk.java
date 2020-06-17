package Tests.PracticeOnCybertek.SelfStudy;

import Utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class DropdownWithoutSelectTagMk {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement dropdownMenuLink = driver.findElement(By.id("dropdownMenuLink"));
        dropdownMenuLink.click();

        List<WebElement> allLinks = driver.findElements(By.className("dropdown-item"));
        System.out.println("Number of links under the dropDon=wnLink: " + allLinks.size());

//        for (WebElement linkName : allLinks) {
//            System.out.println(linkName.getText());
//        }

        Thread.sleep(1500);
        String result = "";
        for (int i = 0; i < allLinks.size(); i++) {
           result += allLinks.get(i).getText() + "\n";
        }
        System.out.println(result);


        WebElement etsy = driver.findElement(By.linkText("Etsy"));
        etsy.click();

        Thread.sleep(1000);
        driver.navigate().back();

        driver.findElement(By.id("dropdownMenuLink")).click();
        WebElement facebook = driver.findElement(By.linkText("Facebook"));
        facebook.click();
        String currentUrl = driver.getCurrentUrl();
        System.out.println("currentUrl = " + currentUrl);
        System.out.println("faceBookTitle = " + driver.getTitle());

        String expectedTitle = "Facebook - Log In or Sign Up";
        String actualTitle = driver.getTitle();

        VerificationUtils.verifyEquals(expectedTitle, actualTitle);

        Thread.sleep(500);
        driver.quit();

    }
}
