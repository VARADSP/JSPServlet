package day6.assignment4;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/* Class CompanyInfo implements resource bundle to use various locales
 * @author: Varad Parlikar
 * Created Date: 2019/06/25
 * */
public class CompanyInfo {

	/*
	 * static method displayValues shows values from ResourceBundle
	 *
	 * @ResourceBundle
	 * return type : void
	 */
	public static void displayValues(ResourceBundle bundle) {
		  // get the keys
	      Enumeration<String> enumeration = bundle.getKeys();
	      // print all the keys
	      ArrayList<String> keys = new ArrayList<>();

	      while (enumeration.hasMoreElements()) {
	         keys.add(enumeration.nextElement());
	      }
	      for(String key:keys){
	    	  System.out.println(key + " :" +bundle.getString(key));
	      }
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Locale value (i.e. ja_JP for japanese, en_US for English )");
		String locale = sc.next();
		Locale n = null;
		if (locale.equals("ja_JP")) {
			n = Locale.JAPANESE;
			ResourceBundle mybundle = ResourceBundle.getBundle("day6.assignment4.Message_jp");
			displayValues(mybundle);
		} else {
			n = Locale.ENGLISH;
			;
			ResourceBundle mybundle = ResourceBundle.getBundle("day6.assignment4.Message_en", n);
			displayValues(mybundle);
		}
		sc.close();
	}
}