package Tests.properties_driver_class_test_base;

//import com.cybertek.utilities.ConfigurationReader;
import Utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {

    @Test
    public void systemPropertiesTest() {
        //
        String os = System.getProperty("os.name");
        System.out.println("os = " + os);//os = Mac OS X

        String user = System.getProperty("user.name");
        System.out.println("user = " + user);//user = metinkaya

        String javaVersion = System.getProperty("java.specification.version");
        System.out.println("javaVersion = " + javaVersion);//javaVersion = 11

        String currentFolder = System.getProperty("user.dir");
        System.out.println("currentFolder = " + currentFolder);//currentFolder = /Users/metinkaya/IdeaProjects/va-spring-2019-selenium-testng


    }

    @Test
    public void systemPropertiesTest2() {

        Properties properties = System.getProperties();
        String os = properties.getProperty("os.name");
        System.out.println("os = " + os);

//        properties.forEach((k, v) -> System.out.println(k + ": " + v));

        System.setProperty("webdriver.chrome.driver", "/Users/cybertekschool/drivers/chromedriver");

        System.out.println(properties.getProperty("webdriver.chrome.driver"));


        System.setProperty("marufjons.last.name.before.marriage", "same");

        System.out.println(properties.getProperty("marufjons.last.name.before.marriage"));


    }

    @Test
    public void readPropertiesFileTest() throws IOException {
        // get the file path (location)
        String path = "configuration.properties";
        // open the file
        FileInputStream fileInputStream = new FileInputStream(path);

        // load into the local object

        Properties properties = new Properties();

        // load --> put the file contents in to the properties object
        properties.load(fileInputStream);

        // read properties from that object

        String url = properties.getProperty("url");
        System.out.println("url = " + url);

        System.out.println(properties.getProperty("salesmanager_username"));
        System.out.println(properties.getProperty("salesmanager_password"));

    }


    @Test
    public void readPropertiesTest() {

        String url = ConfigurationReader.get("url");
        System.out.println("url = " + url);

        String username = ConfigurationReader.get("username");
        String password = ConfigurationReader.get("password");
        System.out.println("username = " + username);
        System.out.println("password = " + password);
    }


}







