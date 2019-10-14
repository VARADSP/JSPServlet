package com.uks.varad.core.day3.assignment1;
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
    public void display(String command) {
        /**
         * method display used to display user name,directory,os name,all details
         * @String return type : void
         */
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
    public void getUname() {
        /**
         * method getUname prints user name
         * return type : void
         */
        System.out.println("User Name : " + System.getProperty("user.name"));
    }
    public void getOsName() {
        /**
         * method getOsName prints os name
         * return type : void
         */
        System.out.println("Operating System : " + System.getProperty("os.name"));
    }
    public void getUdir() {
        /**
         * method getUdir prints user home directory
         * return type : void
         */
        System.out .println("User Directory : " + System.getProperty("user.home"));
    }
    public void getAll() {
        /**
         * method getAll prints all system properties return type : void
         */
        for (Entry<Object, Object> e : System.getProperties().entrySet()) {
            System.out.println(String.format("%s = %s", e.getKey(), e.getValue()));
        }
    }
}