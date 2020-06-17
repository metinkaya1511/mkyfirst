package Tests.PracticeOnCybertek.OfficeHours.Muhtar;

import org.testng.annotations.Test;

public class July_10_TestNG {
    /*
    TestNG:
            @Test: is test case
            enable: if true: executes the test case, if false: ignore the test case
            Timeout: gives time limit to the test case
            priority: deciding which test case to be executed first
            description: for the test discription
            expectedexception:  for unchecked exceptions
            invocationCount: decides how mnay time the test cases should be executed

    TestNG annotations:
            controls the flow of @Test method of TestNG ( Only applicabale to Testng' @test)
            @beforemethod:  runs before each @Test' method
            @aftermethod:   runs after the completion of each @Test' methods
            @beforeclass:
            @afterclass:


     */


    @Test(enabled = true , priority = 2)
    public void Test1(){
        System.out.println("Test 1 completed");
    }

    @Test(timeOut = 3000, priority = 1)
    public void Test2() throws Exception{
        //   Thread.sleep(4000);
        System.out.println("Test 2 completed");
    }

    @Test(priority = 0)
    public void Test3(){
        System.out.println("Test 3 completed");
    }

    @Test( description = "Test description goes here"  )
    public void Test4(){

    }

    @Test ( expectedExceptions = ArrayIndexOutOfBoundsException.class )
    public void Test5(){
        System.out.println("Test 5 ");

        System.out.println( new int[]{1,2}[100] );
        System.out.println("Not done yet");

    }


    @Test (invocationCount = 3)
    public void Test6(){
        System.out.println("Test 6 completed");
    }







}