package Tests.PracticeOnCybertek.SelfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class MultiSelectedList {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/dropdown");

        List<WebElement> allList = driver.findElements(By.name("Languages"));

        System.out.println("allList size= " + allList.size());

        for (WebElement list : allList){
            System.out.println(list.getText());
        }


        Select languageList = new Select(driver.findElement(By.name("Languages")));
        languageList.selectByVisibleText("Java");
        languageList.selectByValue("js");  //JavaScript
        languageList.selectByValue("python");

        for(WebElement title:languageList.getAllSelectedOptions()){
            System.out.println(title.getText());
        }


        //System.out.println(selectedOption.getText());
        Thread.sleep(1000);
        driver.quit();
    }
}
