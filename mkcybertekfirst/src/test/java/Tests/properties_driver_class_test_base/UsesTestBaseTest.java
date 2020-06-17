package Tests.properties_driver_class_test_base;

import Tests.TestBase;

import org.testng.annotations.Test;

public class UsesTestBaseTest extends TestBase {



    @Test
    public void test() {
        driver.get("https://google.com");
        System.out.println(driver.getTitle());

    }

    @Test
    public void test2() {

        driver.get("https://amazon.com");
        System.out.println(driver.getTitle());

    }

    @Test
    public void test3(){
        driver.get("https://ebay.com");
        System.out.println(driver.getTitle());
    }
}
