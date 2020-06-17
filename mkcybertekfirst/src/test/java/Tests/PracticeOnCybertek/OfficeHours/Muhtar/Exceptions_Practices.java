package Tests.PracticeOnCybertek.OfficeHours.Muhtar;
public class Exceptions_Practices {
    public static void main(String[] args) {




        int[] arr={1,2};

        System.out.println("Unchecked Exception: ");
        try {

            System.out.println(arr[100]);
            System.out.println("this one is try block");
        }catch (Exception e){
            System.out.println("This one is catch block");
        }finally {
            System.out.println("Finally block");
        }


        System.out.println("checked Exception: ");
        try {
            Thread.sleep(3000);
            System.out.println("this one is try block");
        }catch (Exception e){
            System.out.println("This one is catch block");
        } finally {
            System.out.println("Finally block");
        }



    }

}