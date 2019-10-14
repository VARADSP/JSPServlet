package day8.assignment1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* Class GenericsTest uses generics type in hash maps to manipulate employee information
 * @author: Varad Parlikar
 *  Created Date: 2019/06/27
 */
public class GenericsTest {
	Scanner scanner = new Scanner(System.in);
	private Map<Object, Object> collection = new HashMap<Object, Object>();//collection map to store employee data

	public GenericsTest() {//constructor
		collection.put(Long.parseLong("9987123456"), "Jacob");
		collection.put(Long.parseLong("9819123456"), "Jenny");
	}

	/* static method isValid to check if entered string is valid mobile number or not
	 * @String is the argument as a mobile number in string format
	 * return type : boolean
	 */

	public static boolean isValid(String s) {
		Pattern p = Pattern.compile("[7-9][0-9]{9}");
		Matcher m = p.matcher(s);
		return (m.find() && m.group().equals(s));
	}

	/* method searchMobile searches the employee collection set to return the matched records
	 * return type : void
	 */
	public void searchMobile() {
		try {
			System.out.println("Enter MobileNumber to search");
			String mobileNumber = scanner.next();
			boolean isMatched = false;
			if (isValid(mobileNumber)) {
				System.out.println("Matched Record :");
				for (Entry<Object, Object> entry : collection.entrySet()) {
					if (entry.getKey().equals(Long.parseLong(mobileNumber))) {
						System.out.println("Name: " + entry.getValue());
						isMatched = true;
					}

				}
			}else {
				System.out.println("Invalid mobile number provided !");
			}
			if (isMatched == false) {
				System.out.println("No records matched!");
			}
		} catch (Exception e) {
			System.out.println("Invalid input entered !");
			e.printStackTrace();
		}
	}

	/* method printAll prints employee records from collection set
	 * return type : void
	 */
	public void printAll() {
		int count = 1;
		System.out.println("Printing Records");
		for (Entry<Object, Object> entry : collection.entrySet()) {
			System.out.println("(" + count++ + ")" + "Name: " + entry.getValue());
			System.out.println("   Mobile: " + entry.getKey());
		}
	}

	/* method addToDictionary is used to add new employee record in collection set
	 * return type : void
	 */
	public void addToDictionary() {
		try {
			System.out.println("Adding Record");
			System.out.println("Enter MobileNumber");
			String mobileNumber = scanner.next();
			if (!isValid(mobileNumber)) {
				System.out.println("Entered mobile number is not valid");
				return;
			}
			System.out.println("Enter First Name");
			String name = scanner.next();
			collection.put(Long.parseLong(mobileNumber), name);
			System.out.println("Record Added");
		} catch (Exception e) {
			System.out.println("Invalid input entered !");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {//main method
		try {
			GenericsTest genericsTest = new GenericsTest();
			genericsTest.printAll();
			genericsTest.addToDictionary();
			genericsTest.addToDictionary();
			genericsTest.addToDictionary();
			genericsTest.printAll();
			genericsTest.searchMobile();
			genericsTest.searchMobile();
		} catch (Exception e) {
			System.out.println("invalid input entered");
			e.printStackTrace();
		}
	}
}