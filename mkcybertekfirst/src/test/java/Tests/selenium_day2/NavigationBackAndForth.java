package Tests.selenium_day2;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class NavigationBackAndForth {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = BrowserFactory.getDriver("chrome");

        //go to the first website: https://www.google.com/
        driver.get("https://www.google.com/");
        Thread.sleep(2000);   //wait 20sec
        Dimension a = driver.manage().window().getSize();  //bu window size'i hafizaya al ve a olarak ata
        driver.manage().window().fullscreen();  //windows'u fullScreen yap
        System.out.println(driver.getTitle());  //Google

        //go to the second website: https://www.etsy.com
        driver.navigate().to("https://www.etsy.com");
        Thread.sleep(2000);
        System.out.println(driver.getTitle());  //Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

        //go back to the first website (google) :https://www.google.com/

        driver.navigate().back();
        System.out.println(driver.getTitle());  //Google
        Thread.sleep(2000);

        //go return / navigate to etsy : https://www.etsy.com
        driver.navigate().forward();
        System.out.println(driver.getTitle());//Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone
        Thread.sleep(2000);

        //refresh the current page
        driver.navigate().refresh();
        System.out.println(driver.getTitle());//Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone
        driver.manage().window().setSize(a);  //hafizaya aldigimiz size'i ata.
        Thread.sleep(2500);


        //close the webpage
        driver.close();

    }
}
