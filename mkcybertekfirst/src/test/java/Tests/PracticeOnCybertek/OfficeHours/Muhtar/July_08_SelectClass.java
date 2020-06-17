package Tests.PracticeOnCybertek.OfficeHours.Muhtar;


import Utilities.Library;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class July_08_SelectClass {

    public static void main(String[] args) {
        /*
        Topic: Select class

            select class is used to handle drop down boxes with the tagname of select.

                Select st = new Select(WebELement);

                methods of Select:
                        selectByindex(int a):  selects the options in drop down box by the index number
                        selectByvalue(String str): selects the options in drop down box by value
                        selectByvisibletext(String str):  selects the options in drop down box by visible text
                        getoptions(): returns List of WebElements, from the drop down box
                        getfirstSelectedoption(): returns webelement that's selected in the drop down box

         */

//        WebDriverManager.chromedriver().setup();
//        WebDriver driver=new ChromeDriver();
//
//        Select st = new Select(driver.findElement(By.xpath("")));
//            st.selectByIndex(8);
//            st.selectByValue("May");
//            List<WebElement> list= st.getOptions();
//           WebElement element = st.getFirstSelectedOption();
//

       // Test1();
        //Test2();
        //Test3();
//        Test4();
        Test5();

    }

    public static void Test1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.facebook.com");
        driver.manage().window().maximize();
        Library.sleep(5);


        /*
        <select aria-label="Month" name="birthday_month" id="month" title="Month" class="_5dba">    on><option value="4">Apr</option><option value="5">May</option><option value="6">Jun</option><option value="7" selected="1">Jul</option><option value="8">Aug</option><option value="9">Sep</option><option value="10">Oct</option><option value="11">Nov</option><option value="12">Dec</option></select>
        //select[@aria-label='Month']
         */

        WebElement monthDropDown = driver.findElement(By.xpath("//select[@aria-label='Month']"));
        Select month = new Select(monthDropDown);
        // select by index:
        month.selectByIndex(9);


        Library.sleep(3);
        // select by value:
        month.selectByValue("3");

        Library.sleep(3);
        // select by visible text:
        month.selectByVisibleText("Oct");


        List<WebElement> list2= month.getOptions();
        System.out.println("There are "+ list2.size()+" selectable options"); //There are 13 selectable options

        Library.sleep(5);
        driver.quit();


    }


    public static void Test2(){
        // verify the deafult selected option is July
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.facebook.com");
        driver.manage().window().maximize();
        Library.sleep(5);



        driver.navigate().refresh();

        WebElement monthDropDown = driver.findElement(By.xpath("//select[@aria-label='Month']"));
        Library.sleep(3);

        Select month = new Select(monthDropDown);
        String defaultvalue = month.getFirstSelectedOption().getText();

        System.out.println(defaultvalue);//Jul

        boolean result = defaultvalue.equals("Jul");
        System.out.println(result);

        Library.sleep(2);
        driver.quit();

    }

    public static void Test3(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.facebook.com");
        driver.manage().window().maximize();
        Library.sleep(5);

        WebElement dayDB = driver.findElement(By.name("birthday_day"));

        Select Day = new Select(dayDB);
        // verify 32 is not exist
        Day.selectByVisibleText("21");


        List<WebElement> list = Day.getOptions();
        WebElement E21 = list.get(21);
        WebElement E28 = null;

        System.out.println( E21.isSelected() );//true

        //select 11:
        Library.sleep(2);
        Day.selectByValue("11");

        boolean A = false;

        for(WebElement each: list){
            if(! each.getText().equals("32") )
                A = true;

            if(each.getText().equals("28"))
                E28 = each;

        }

        System.out.println(A);//true
        System.out.println(E28.getText());//28
    }


    public static void Test4(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.facebook.com");
        driver.manage().window().maximize();
        Library.sleep(5);

        WebElement YearDB = driver.findElement(By.id("year"));
        Select st = new Select(YearDB);
        st.selectByVisibleText("1906");

        WebElement E1906 = st.getFirstSelectedOption();
        System.out.println( E1906.isSelected() );

        WebElement E1906_2 =null;

        List<WebElement> all = st.getOptions();
        for(WebElement each: all){
            if(each.getText().equals("1906"))
                E1906_2 = each;
        }
        System.out.println( E1906_2.isSelected() );

        Library.sleep(5);
        driver.quit();

    }


    public static void Test5(){
        // verify the Sign up button
        // verify the warning is displayed
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.facebook.com");
        driver.manage().window().maximize();
        Library.sleep(5);

        //tagname[text()='value']
        //tagnme[conatins(text(),'value']

//        WebElement ele =driver.findElements(By.xpath("//button[text()='Sign Up']")).get(0);
        WebElement ele = driver.findElement(By.id("u_0_y"));
        System.out.println(ele.isEnabled());
        if(ele.isEnabled()){
            ele.click();
        }


        WebElement warning = driver.findElement(By.xpath("(//*[contains(text(),'your name')])[1]"));
        System.out.println( warning.isDisplayed());

        // (//*[text()='Sign Up'])[2]


        Library.sleep(3);
        driver.quit();
    }

}