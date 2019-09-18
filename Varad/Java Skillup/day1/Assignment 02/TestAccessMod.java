package day1.assignment2;
/**
 * @author Varad Parlikar Day1 Assignment2
 */
public class TestAccessMod {//
    /**
     * TestAccessMod class for accessing object of AccessMod class
     * @author: Varad Parlikar
     * Created Date: 2019/06/18
     */
    public static void main(String[] args) {// main method
        AccessMod accessMod = new AccessMod();
        accessMod.printProperties();
        System.out.println("Accessing integer variable " + accessMod.integerVar);
        System.out.println("Accessing character variable " + accessMod.characterVar);
        System.out.println("Accessing boolean variable " + accessMod.booleanVar);
        // System.out.println("Accessing string variable " + accessMod.stringVar); Not
        // accessible because it is private
        System.out.println("Accessing float variable " + accessMod.floatVar);
        System.out.println("Accessing double variable " + accessMod.doubleVar);
        System.out.println("Accessing long variable " + accessMod.longVar);
    }
}
