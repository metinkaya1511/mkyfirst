package Tests.PracticeOnCybertek.SelfStudy;

import Utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListOfElementsTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();
//        NOTE: select different buttons every time
        List<WebElement> buttons = driver.findElements(By.name("sport"));

        System.out.println("Number of spor type: " + buttons.size());
 //        verify that none of the options under Select your favorite sport: are selected by default
        for (WebElement button:buttons) {
            VerificationUtils.verifySelected(button,false);
        }
//        select any radio button
        Random random = new Random();
        int num = random.nextInt(buttons.size());
        buttons.get(num).click();

        for (int i=0; i < buttons.size(); i++){
            buttons.get(i).click();
            if (i==num){
                VerificationUtils.verifySelected(buttons.get(i), true);
            }else {
                VerificationUtils.verifySelected(buttons.get(i), false);
            }
            //        select any other radio button

            int num2;
            do {
                num2 = random.nextInt(buttons.size());
            }while (num2 == num);

            buttons.get(num2).click();

            //select Hockey
//            driver.findElement(By.id("hockey")).click();
            for (int j = 0; j < buttons.size(); j++) {
                if (buttons.get(j).equals(driver.findElement(By.id("hockey")))){
                    buttons.get(j).click();

                }

            }

            VerificationUtils.verifySelected(driver.findElement(By.id("hockey")), true);

        }

        Thread.sleep(1000);
        driver.quit();

    }
}
