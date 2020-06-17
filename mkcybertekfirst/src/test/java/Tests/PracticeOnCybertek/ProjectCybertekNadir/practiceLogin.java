package Tests.PracticeOnCybertek.ProjectCybertekNadir;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
This is where you can log into the secure area.
Enter tomsmith for the username and SuperSecretPassword for the password.
If the information is wrong you should see error messages.
 */

public class practiceLogin {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("http://practice.cybertekschool.com/login");
        driver.manage().window().maximize();

        //Enter username
        //1st way -->   copy path
//        WebElement userName = driver.findElement(By.xpath("//*[@id='login']/div[1]/div/input"));
//        userName.sendKeys("tomsmith");
        //2nd way
//        WebElement userName2 = driver.findElement(By.name("username"));
//        userName2.sendKeys("thomasName");
        //3rd way -->  copy selector
        WebElement userName3 = driver.findElement(By.cssSelector("#login > div:nth-child(1) > div > input[type=text]"));
        userName3.sendKeys("tomsmith");

        //Enter Password

        WebElement password = driver.findElement(By.cssSelector("#login > div:nth-child(2) > div > input[type=password]"));
        password.sendKeys("SuperSecretPassword");
        Thread.sleep(1000);
        //click login button
        WebElement login = driver.findElement(By.id("wooden_spoon"));
        login.click();

        System.out.println(driver.getTitle());//Practice

        String expected = "Your username is invalid!";
        System.out.println("expected: " + expected);

        WebElement errrorMessage = driver.findElement(By.id("flash"));
        String actual = errrorMessage.getText();
        System.out.println("actual : " + actual);

        if (!expected.equalsIgnoreCase(actual)){
            System.out.println(actual);

//   logout
Thread.sleep(1000);
       // driver.findElement(By.tagName("i")).click();
             //   <a class="button secondary radius" href="/logout"><i class="icon-2x icon-signout"> Logout</i></a>

      //  driver.findElement(By.xpath("//*[@id=\"content\"]/div/a")).click();

            Thread.sleep(3000);
            driver.quit();

        }



    }
}
