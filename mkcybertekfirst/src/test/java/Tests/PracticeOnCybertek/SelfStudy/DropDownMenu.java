package Tests.PracticeOnCybertek.SelfStudy;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownMenu {
    public static void main(String[] args) throws InterruptedException {
//set up
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/dropdown");
        driver.manage().window().maximize();

//1.We identify the Select element:
        WebElement selectElement = driver.findElement(By.id("dropdown"));
//2.We create a select object by passing the select web element as a constructor:
        Select dropDownList = new Select(selectElement);

//        System.out.println(dropDownList.getOptions().get(0).getText()); //Please select an option
//        System.out.println(dropDownList.getOptions().get(1).getText()); //option 1
//        System.out.println(dropDownList.getOptions().get(2).getText()); //option 2

        //READ THE SELECETED OPTION:
        //getFirstSelectedOption();    returns the selected option

        WebElement selectedOption = dropDownList.getFirstSelectedOption();//ilk acildiginda default gelen
        System.out.println("selected default option: " + selectedOption.getText()); //selected default option: Please select an option


        //GET ALL AVAILABLE OPTIONS
        List<WebElement> allOptions = dropDownList.getOptions();
        System.out.println("Numbers of Options: " + allOptions.size()); //Numbers of Options: 3

        //optionslarin adini yazdir
        for(WebElement option : allOptions){
            System.out.println(option.getText());
        }

        Thread.sleep(2000);
        //HOW TO SELECT USING VISIBLE TEXT   -->   dropDownList.selectByVisibleText("Option 1");:
        dropDownList.selectByVisibleText("Option 1"); //Option 1 is selected ..this is as like dropDownList.click()
        selectedOption = dropDownList.getFirstSelectedOption();  //Option is assigned
        System.out.println("selected option: " + selectedOption.getText());  //selected option: Option 1

        Thread.sleep(3000);
        dropDownList.selectByVisibleText("Option 2");
        selectedOption = dropDownList.getFirstSelectedOption();
        System.out.println("selected option: " + selectedOption.getText()); //selected option: Option 2


//        HOW TO SELECT USING INDEX -->  dropDownList.selectByIndex(1);
//        Index starts from zire (0)
        Thread.sleep(500);
        dropDownList.selectByIndex(1);
        selectedOption = dropDownList.getFirstSelectedOption();
        System.out.println("selected option: " + selectedOption.getText());//selected option: Option 1

        Thread.sleep(1000);
        dropDownList.selectByIndex(2);
        selectedOption = dropDownList.getFirstSelectedOption();
        System.out.println("selected option: " + selectedOption.getText());////selected option: Option 2

//       HOW TO SELECT USING THE VALUE ATTRIBUTE  -->  dropDownList.selectByValue("1");:
//        <option value="1">Option 2</option>
//        dropDownList.selectByValue("1");
        dropDownList.selectByValue("1");
        selectedOption = dropDownList.getFirstSelectedOption();
        System.out.println("selected: " + selectedOption.getText());

        Thread.sleep(1000);
        dropDownList.selectByValue("2");
        selectedOption = dropDownList.getFirstSelectedOption();
        System.out.println("selected: " + selectedOption.getText());


        Thread.sleep(1000);
        driver.quit();
    }
}
