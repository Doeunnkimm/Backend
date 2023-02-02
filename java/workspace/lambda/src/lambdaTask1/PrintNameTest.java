package lambdaTask1;

public class PrintNameTest {
   public static void printFullName(PrintName printName, String lastName, String firstName) {
      System.out.println(printName.getFullName(lastName, firstName));
   }
   
   public static void main(String[] args) {
      PrintNameTest.printFullName((l, f) -> l + f, "ÇÑ", "µ¿¼®");
   }
}