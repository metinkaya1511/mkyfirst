package Tests.PracticeOnCybertek.SelfStudy;

import Utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.Scanner;

public class radioButtonsColors {


    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/radio_buttons");

        //verify blue is selected by default
        //verify red is selected by default
        WebElement blue = driver.findElement(By.id("blue"));
        if (blue.isSelected())
            System.out.println("blue = " + blue.isSelected());
        System.out.println("PASS");



        WebElement red = driver.findElement(By.id("red"));

        if (red.isSelected()){
            System.out.println("red = " + red);
            red.click();
        }

        WebElement yellow = driver.findElement(By.xpath("//input[@id='yellow']"));
        System.out.println("tagName: " + yellow.getTagName());
        System.out.println("attribute: " + yellow.getAttribute("type"));
        yellow.click();

        WebElement black = driver.findElement(By.id("black"));
        black.click();
        System.out.println("black is enabled?  - " + black.isEnabled());
// if black is checked thenit passes
        VerificationUtils.verifySelected(black, true);

        Thread.sleep(1500);
        driver.quit();
    }


}
