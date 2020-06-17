package Tests.PracticeOnCybertek.OfficeHours.Muhtar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class July_10_Annotations {

    WebDriver driver;

    @BeforeMethod
    public void method1(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.facebook.com");

    }

    @Test(
            description = "Verify the URL" ,
            priority = 2,
            invocationCount = 1
    )
    public void Test1(){

        String URL =  driver.getCurrentUrl();
        Assert.assertTrue( URL.contains("www.facebook.com")  ); // must provide true condition

        // Assert.assertFalse( !URL.contains("www.facebook.com") ); // must provide false condition

        System.out.println(URL);

        Assert.assertEquals("https://www.facebook.com/", URL);

        System.out.println("Test completed");




    }


    @Test(
            description = "Verify the Title" ,
            priority = 1,
            enabled = false
    )
    public void Test2() throws Exception{
        Assert.assertTrue( driver.getTitle().contains("Facebook") );



    }


    @AfterMethod
    public void closes(){
        driver.quit();

    }

}