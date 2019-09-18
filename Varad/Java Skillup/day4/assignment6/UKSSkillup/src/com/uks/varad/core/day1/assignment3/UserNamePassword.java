package com.uks.varad.core.day1.assignment3;
/**
 * @author Varad Parlikar Day1 Assignment3
 */
public class UserNamePassword {//
    /**
     * Class UserNamePassword containing validate method
     * @author: Varad Parlikar
     * Created Date: 2019/06/18
     */
    public boolean validate(String code, String password) {//
        /**
         * method to validate user code and password.
         * return type : boolean
         */
        if (code.equals("varad") && password.equals("pass")) {
            return true;
        }
        return false;
    }
}
