package Tests.properties_driver_class_test_base;

import Tests.TestBase;
//import com.cybertek.tests.TestBase;
import org.testng.annotations.Test;

public class UsesTestBaseTest2 extends TestBase {

    @Test
    public void test1(){
        driver.get("https://cybertekschool.com");
        System.out.println(driver.getTitle());

    }

}
