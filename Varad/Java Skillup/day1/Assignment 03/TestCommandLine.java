package day1.assignment3;
/**
 * @author Varad Parlikar Day1 Assignment3
 */
public class TestCommandLine { //
    /**
     * TestCommandLine class for accessing object of UserNamePassword class
     * @author: Varad Parlikar
     * Created Date: 2019/06/18
     */
    public static void main(String[] args) {//main method
        String[] code = args[0].split(",");// converting arguments into string array
        UserNamePassword userNamePassword = new UserNamePassword();
        if (userNamePassword.validate(code[0], code[1])) {
            System.out.println("Valid user");
        } else {
            System.out.println("Invalid user");
        }
    }
}
