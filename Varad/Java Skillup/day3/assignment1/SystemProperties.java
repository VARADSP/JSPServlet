package day3.assignment1;
/**
 * @author Varad Parlikar Day3 Assignment1
 */
import java.util.Map.Entry;
public class SystemProperties {
    /**
     * Class SystemProperties containing methods to display username,osname,user
     * home directory and all details
     * @author: Varad Parlikar Created Date: 2019/06/20
     */
    /**
     * method display used to display user name,directory,os name,all details
     * @String return type : void
     */

    public void display(String command) {
        switch (command) {
        case "uname":
            getUname();
            break;
        case "osname":
            getOsName();
            break;
        case "udir":
            getUdir();
            break;
        case "all":
            getAll();
            break;
        }
    }
    /**
     * method getUname prints user name
     * return type : void
     */
    public void getUname() {
        System.out.println("User Name : " + System.getProperty("user.name"));
    }
    /**
     * method getOsName prints os name
     * return type : void
     */
    public void getOsName() {
        System.out.println("Operating System : " + System.getProperty("os.name"));
    }
    /**
     * method getUdir prints user home directory
     * return type : void
     */
    public void getUdir() {
        System.out .println("User Directory : " + System.getProperty("user.home"));
    }
    /**
     * method getAll prints all system properties return type : void
     */
    public void getAll() {
    	getUname(); getOsName();getUdir();
    }
}