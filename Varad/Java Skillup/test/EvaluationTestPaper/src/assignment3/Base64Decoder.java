package assignment3;

import java.util.Base64;
import java.util.Scanner;

/* 
 * Class Base64Decoder which is created to decode the base64 encoded output into string variable 
 * @author: Varad Parlikar
 *  Created Date: 2019/07/03
 */
public class Base64Decoder {
    
    /* 
     * method decode which decodes base64 encoded into string variable.
     * @String input which is in base 64 encoded format
     * return type : String
     */
    public static String decode(String input) {
        byte[] getBytes = Base64.getDecoder().decode(input);
        String decodedString = new String(getBytes);
        return decodedString;  
    }

   

}
