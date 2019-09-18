package assignment3;

import java.util.Base64;
import java.util.Scanner;

/* 
 * Class Base64Encoder which is created to encode string input into base64 encoded output which is to be decoded
 * @author: Varad Parlikar
 *  Created Date: 2019/07/03
 */
public class Base64Encoder {
    
    /* 
     * method encode which encodes string variable into base 64 encoded format.
     * @String input which is to be encoded in base 64 format
     * return type : String
     */
    public static String encode(String input) {
       // Encode into Base64 format 
        String BasicBase64format 
            = Base64.getEncoder() 
                  .encodeToString(input.getBytes()); 
      
        return BasicBase64format;
    }
    public static void main(String[] args) {
        //main method
        System.out.println("Enter String To encode using Base64 Encoding");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String base64EncodedString = encode(input);
        System.out.println("Encoded String from base64 Encoding : " + base64EncodedString);
        
        System.out.println("Decoded output :" + Base64Decoder.decode(base64EncodedString));
 
        
    }
}
