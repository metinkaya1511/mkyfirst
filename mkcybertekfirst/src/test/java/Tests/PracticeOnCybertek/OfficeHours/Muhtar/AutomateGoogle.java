package Tests.PracticeOnCybertek.OfficeHours.Muhtar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateGoogle {
    public static void main(String[] args) throws InterruptedException {

    Test1();


    }

    public static void Test1() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");  // open google.com
        Thread.sleep(3000);

        /*
       <input class="gLFyf gsfi" maxlength="2048" name="q" type="text"
       jsaction="paste:puy29d" aria-autocomplete="both" aria-haspopup="false"
       autocapitalize="off" autocomplete="off" autocorrect="off" role="combobox"
       spellcheck="false" title="Search" value="" aria-label="Search"
       data-ved="0ahUKEwif6omf25TjAhWITd8KHbMWCnEQ39UDCAY">
         */
//        By SearchBoxLocator =By.xpath("//input[@title='Search']");  // has to be unique
//        WebElement SearchBox = driver.findElement(SearchBoxLocator);

WebElement SearchBox = driver.findElement(By.xpath("//input[@title='Search']"));
        // SendKeys(): inputs value to search box...
        SearchBox.sendKeys("Apple"  );
        SearchBox.submit();

        /*
        <h3 class="sA5rQ"> Apple | Official site‎</h3>
         */
        //h3[@class='sA5rQ']

        //  By AppleLocator = By.xpath("//h3[@class='sA5rQ']");
        // formula for conatin text xpath: //tagname[ contains(text(),'some text') ]

        Thread.sleep(3000);
        By AppleLocator = By.xpath("//h3[contains(text(),'Official')]");
        WebElement AppleStore = driver.findElement(AppleLocator);

        // getText() returns the linktext of the element
        System.out.println( AppleStore.getText() );   // should contain apple, official

        AppleStore.click();


        Thread.sleep(3000);

        driver.navigate().back();

        Thread.sleep(3000);









    }
}