package day1.assignment2;
/**
 * @author Varad Parlikar Day1 Assignment2
 */
public class AccessMod { //
    /**
     *AccessMod class demonstrating access modifiers
     * @author: Varad Parlikar
     * Created Date: 2019/06/18
     */
    public Integer integerVar = 21;
    Character characterVar = 'C';
    Boolean booleanVar = false;
    private String stringVar = "Hello";
    protected Float floatVar = (float) 21.21;
    protected Double doubleVar = 22.22342;
    protected Long longVar = (long) 224.42444;

    public void printProperties() {//
        /**
         *  method to print class variables
         * return type : void
         */
        System.out.println("Integer variable " + integerVar);
        System.out.println("Character variable " + characterVar);
        System.out.println("String variable " + stringVar);
        System.out.println("Boolean variable " + booleanVar);
        System.out.println("Float variable " + floatVar);
        System.out.println("Double variable " + doubleVar);
        System.out.println("Long variable " + longVar);
    }
}
