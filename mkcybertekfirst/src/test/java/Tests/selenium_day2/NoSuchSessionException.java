package Tests.selenium_day2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NoSuchSessionException {
    public static void main(String[] args) throws InterruptedException {
        //afterClosingSingleTab();
        //afterClosingOneOfMany();
        afterCallinQuit();
    }
    //after closing one tab
    public static void afterClosingSingleTab() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com");
        Thread.sleep(3000);
        driver.close();//kapattiktan sonra getTitle calisistirilirsa exception hatasi verir:

//        Exception in thread "main" org.openqa.selenium.NoSuchSessionException: invalid session id  -->getting this error
//        since we are trying to use browser which we already closed

        System.out.println(driver.getTitle());//this gives an error. see above
    }

    public static void afterClosingOneOfMany() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(4000);
        driver.close();

        System.out.println(driver.getTitle()); //bu hata verir. cunki tab kapatildiktan sonra title istiyoruz.

//        Exception in thread "main" org.openqa.selenium.NoSuchWindowException: no such window: target window already closed
//        we get this when we have multiple tabs open and close one of them and
//        then try to use the driver object again

    }
    public static void afterCallinQuit() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(4000);
        driver.quit();

        driver = new ChromeDriver(); //to prevent this error we have to iniitiliaze the driver... If we don't this the error in the below will come!
        System.out.println(driver.getTitle());//this gives the error in the below:
//        Exception in thread "main" org.openqa.selenium.NoSuchSessionException: Session ID is null. Using WebDriver after calling quit()?
//     //We get this error warning since we called the title after calling the quit method.

    }



}
