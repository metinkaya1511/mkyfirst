package Tests.PracticeOnCybertek.ProjectCybertekNadir;

import Utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class VyTruckLoginLogout {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://qa3.vytrack.com/user/login");
        driver.manage().window().maximize();

        Thread.sleep(2000);

//        WebElement userId = driver.findElement(By.xpath("//input[@id='prependedInput']"));
//        WebElement pasword = driver.findElement(By.xpath("//input[@id='prependedInput2']"));
//        WebElement signIn = driver.findElement(By.xpath("//button[@id='_submit']"));

        WebElement userId = driver.findElement(By.id("prependedInput"));
        userId.sendKeys("user156");

        Thread.sleep(2000);

        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");

        Thread.sleep(2000);
        //login
        WebElement signInButton = driver.findElement(By.id("_submit"));
        signInButton.click();
        Thread.sleep(2000);

        //VEHICLE and CONTRACT page is not accessible
        driver.findElement(By.xpath("(//span[@class='title title-level-1'])[1]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[.='Vehicle Contracts']")).click();

        Thread.sleep(2000);
        String expected = "You do not have permission to perform this action.";
        System.out.println("expected = " + expected);
        Thread.sleep(2000);
        String actual = driver.findElement(By.xpath("//div[.='You do not have permission to perform this action.']")).getText();
        System.out.println("actual = " + actual);
        VerificationUtils.verifyEquals(expected, actual);


        //logout:
        Thread.sleep(1000);


        WebElement logoutAlex = driver.findElement(By.xpath("//a[@href='javascript: void(0);']"));  //findElement(By.xpath("//*[@id='user-menu']"));
        logoutAlex.click();

        Thread.sleep(1000);

        WebElement logout2 = driver.findElement(By.xpath("//a[@href='/user/logout']"));
        logout2.click();
        Thread.sleep(2000);

//        Select dropdownList = new Select(driver.findElement(By.xpath("(//ul[@class=\"dropdown-menu\"])[1]")));
//        dropdownList.selectByVisibleText("Logout");
//        WebElement selected = dropdownList.getFirstSelectedOption();
//        selected.click();

//        Library.sleep(3);
//        driver.quit();

//<a href="/user/logout" class="no-hash">Logout</a>

    }
}