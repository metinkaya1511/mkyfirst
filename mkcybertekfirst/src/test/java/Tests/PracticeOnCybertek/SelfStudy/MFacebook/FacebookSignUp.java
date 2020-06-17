package Tests.PracticeOnCybertek.SelfStudy.MFacebook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class FacebookSignUp {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        driver.findElement(By.id("logoutMenu")).click();
        driver.findElement(By.partialLinkText("Find Groups")).click();
        Thread.sleep(3000);
       //driver.quit();
    }

    @Test
    public void signUp(){
        WebElement firstNAme = driver.findElement(By.cssSelector("input[class='inputtext _58mg _5dba _2ph-'][name='firstname']"));
        firstNAme.sendKeys("Gurbetci");

        WebElement lastName = driver.findElement(By.cssSelector("input[name='lastname']"));
        lastName.sendKeys("Kanarya");

        WebElement email = driver.findElement(By.name("reg_email__"));
        email.sendKeys("fandfgermany@gmail.com");

        WebElement reEmail = driver.findElement(By.cssSelector("input[name='reg_email_confirmation__'][aria-label='Re-enter email']"));
        reEmail.sendKeys("fandfgermany@gmail.com");

        WebElement password = driver.findElement(By.cssSelector("input[name='reg_passwd__']"));
        password.sendKeys("Fenerbahce1907");

       WebElement birthMonth = driver.findElement(By.id("month"));
         Select select = new Select(birthMonth);
         select.selectByVisibleText("Jan");

         WebElement birthDay =driver.findElement(By.id("day"));
         Select selectDay = new Select(birthDay);
         selectDay.selectByIndex(3);

         driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);

         WebElement birthYear = driver.findElement(By.id("year"));
         Select selectYear = new Select(birthYear);
         selectYear.selectByValue("2000");

        Assert.assertTrue(birthYear.isDisplayed());

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebElement mail = driver.findElement(By.id("u_0_9"));
        mail.click();

        Assert.assertTrue(mail.isSelected());

        driver.findElement(By.cssSelector("input[type='submit'][id='u_0_2']")).click();





    }
    @Test
    public void facebookSignIn(){
        driver.findElement(By.id("email")).sendKeys("fandfgermany@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Fenerbahce1907" + Keys.ENTER);

       // driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
//        String originalWindow = driver.getWindowHandle();
//        Set<String> windows = driver.getWindowHandles();
//        for(String window: windows){
//            if(!window.equals(originalWindow)){
//                driver.switchTo().window(window);
//                driver.close();
//            }
//        }

//        driver.switchTo().alert().accept();


    }



}
