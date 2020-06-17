package Tests.PracticeOnCybertek.OfficeHours.Muhtar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class July_1_Locators {

    public static void main(String[] args) {

        /*
            Today's topic: locators
             locators: created from By abstract class
                        id(),
                        name(),
                        className(),
                        tagname(),
                        linktext(),
                        partialLinktext(),
                        xpath(),
                        css(),

            WebElements:
                        findElement(By):   for unique locators only, returns single webElement
                        findElements(By):  for non-uniuqe locators, returns List of Elements

    write xpath:   //tagname[@attribute='value of the attribute' and @attribute='value of the attribute' and ....]

    <input class="gLFyf gsfi" maxlength="2048" name="q" type="text" jsaction="paste:puy29d" aria-autocomplete="both"
    aria-haspopup="false" autocapitalize="off" autocomplete="off" autocorrect="off" role="combobox" spellcheck="false"
    title="Search" value="" aria-label="Search" data-ved="0ahUKEwjVl7nQ15TjAhWkm-AKHeQAAacQ39UDCAY">

        //input[@name='q']


         */
        WebDriver driver = new ChromeDriver();

        // id:
        By IdLocator =  By.id("id goes here");
        WebElement element1 = driver.findElement(IdLocator);  // only if the locator is unique

        List<WebElement> list= driver.findElements(IdLocator);
        // to click second elemnt:
        list.get(1).click();

        // name:
        By name = By.name("name goes here");
        WebElement nameElement = driver.findElement(name);









    }

}