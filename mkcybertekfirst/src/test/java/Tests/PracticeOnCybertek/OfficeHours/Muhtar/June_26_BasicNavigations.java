package Tests.PracticeOnCybertek.OfficeHours.Muhtar;
import Utilities.Library;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class June_26_BasicNavigations {


    public static void main(String[] args)  {

        System.setProperty(
                "webdriver.chrome.driver",
                "/Users/cybertekschool/Documents/selenium dependencies/drivers/chromedriver"
        );

        WebDriver driver = new ChromeDriver();    // opens the browser
        driver.get("http://www.google.com");  // get method is an override method

        String PageTitle = driver.getTitle();

        // verifying the title.
        if(PageTitle.contains("Google")){
            System.out.println("Title is verified");
        } else {
            System.out.println("Title is not verified");
            System.exit(0);
        }



        String PageURL = driver.getCurrentUrl();
        if(PageURL.contains("www.google.com"))
            System.out.println("URL is verified");
        else{
            System.out.println("URL is not verified");
            System.exit(0);
        }

        // maximize the window:
        driver.manage().window().maximize();

        Library.sleep(3);

        // full screen:
        driver.manage().window().fullscreen();

        Library.sleep(3);


        // refresh:
        driver.navigate().refresh();
        Library.sleep(3);

        // go back:
        driver.navigate().back();
        Library.sleep(3);

        // go forward:
        driver.navigate().forward();

        // open URL:
        driver.navigate().to("http://www.amazon.com");
        // http:  hypertext transfer protocol
        // https:  hypertext transfer protocol secure
        Library.sleep(3);
        driver.navigate().back();


        driver.manage().window().setSize( new Dimension(5,9) );

        System.out.println("Test completed");






         /*

                Differences between Navigate().to()   and get():
                            get() will wait of the webpage fully uploaded
                            navigate doesnt have to wait. ( faster)

               close() vs Quite():
                        close() will close a single tab
                        Quite() will closes the entire tabs and browser


          */






    }









}
