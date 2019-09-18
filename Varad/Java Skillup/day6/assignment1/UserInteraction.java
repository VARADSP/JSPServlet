package day6.assignment1;

import java.io.FileNotFoundException;
import java.util.Scanner;
import day1.assignment4.*;
import day2.assignment3.*;
import day2.assignment4.*;
import day2.assignment4.StringOperation;
import day3.assignment3.*;
import day3.assignment4.*;
import day3.assignment5.*;
import day3.assignment8.*;
import day4.assignment5.*;
import day5.assignment3.*;
import day5.assignment3.EmployeeSearch;
import day5.assignment4.*;

/* Class UserInteraction implements previous assignments to provide multiple choices and multiple operations to user
 * @author: Varad Parlikar
 *  Created Date: 2019/06/25
 */
public class UserInteraction {
	static Scanner sc = new Scanner(System.in);

	/*
	 * static method callClassAddNumbers implements add number functionality
	 * return type : void
	 */

	static void callClassAddNumbers() {
		System.out.println("Please enter choice(1/2)");
		System.out.println("1.To add numbers");
		System.out.println("2.To convert to lowercase");
		System.out.println("Followed by string of inputs separated by space (e.g 1 2 3 or 2 HELLO)");
		sc.nextLine();// skip the newline
		String in = sc.nextLine();
		String[] args = in.split(" ");
		new MultiCommandLine().doOperation(args);
	}

	/*
	 * static method callClassStringManipulation implements string manipulation
	 * with regex for string matching operations
	 * return type : void
	 */

	static void callClassStringManipulation() {
		System.out.println("Please enter choice(1/2)");
		System.out.println("1.To reverse string array");
		System.out.println("2.To count uppercase,lowercase,digits");
		System.out.println("Followed by string of inputs separated by space (e.g. 1 hello or 2 hello bye 22hh)");
		sc.nextLine();// skip the newline
		String in = sc.nextLine();
		String[] args = in.split(" ");
		String[] args1 = { args[0], args[1] };
		new StringOperation().doOperationWithRegEx(args1);
	}
	/*
	 * static method callClassStringOperations implements string manipulation
	 * operations
	 * return type : void
	 */

	static void callClassStringOperations() {
		System.out.println("Please enter choice(1/2)");
		System.out.println("1.To reverse string array");
		System.out.println("2.To count uppercase,lowercase,digits");
		System.out.println("Followed by string of inputs separated by space (e.g. 1 hello or 2 hello bye 22hh)");
		sc.nextLine();// skip the newline
		String in = sc.nextLine();
		String[] args = in.split(" ");
		String[] args1 = { args[0], args[1] };
		new StringOperation().doOperation(args1);
	}
	/*
	 * static method callClassDateFormat formats date provided
	 * return type :void
	 */

	static void callClassDateFormat() throws Exception {
		System.out.println("Please enter date output format(e.g dd/MM/yyyy )");
		sc.nextLine();// skip the newline
		String outputFormat = sc.next();
		System.out.println("Please enter date in format (yyyy/MM/dd) separated by / (e.g 2019/06/26 )");
		// sc.nextLine();// skip the newline
		String date = sc.next();
		new DateAndTime().showDate(outputFormat, date);
	}

	/*
	 * static method callClassDateDifference calculates dates difference
	 * return type : void
	 *
	 *
	 */
	static void callClassDateDifference() throws Exception {
		System.out.println("Please enter date1 separated by / in required format yyyy/MM/dd (e.g 2019/05/29 )");
		sc.nextLine();// skip the newline
		String date1 = sc.nextLine();
		System.out.println("Please enter date2 separated by / in required format yyyy/MM/dd (e.g 2019/06/12 )");
		// sc.nextLine();// skip the newline
		String date2 = sc.nextLine();
		new DateDifference().showDateDifference(date1, date2);
	}

	/*
	 * static method callClassDateAdd adds date to the current date
	 * return type:void
	 *
	 */
	static void callClassDateAdd() throws Exception {
		System.out.println("Please enter date separated by / in required format yyyy/MM/dd (e.g 2019/05/29 )");
		sc.nextLine();// skip the newline
		String date = sc.nextLine();
		System.out.println("Please enter add type for date (e.g year or month or day)");
		// sc.nextLine();// skip the newline
		String addType = sc.nextLine();
		System.out.println("Please enter a number to add in the date according to add type");
		// sc.nextLine();// skip the newline
		Integer num = sc.nextInt();
		new DateAdd().addDate(date, addType, num);
	}

	/*
	 * static method callClassReflections uses reflections in java to provide
	 * details of class
	 * return type : void
	 */
	static void callClassReflections() {
		System.out.println("Please enter class name (e.g java.util.Date)");
		sc.nextLine();// skip the newline
		String className = sc.nextLine();
		System.out.println(
				"Please enter type of info to show (e.g M for methods , C for constructors , F for fields , ALL for all details)");
		// sc.nextLine();// skip the newline
		String typeOfInfo = sc.nextLine();
		System.out.println(typeOfInfo);
		new ClassDetail().printDetails(className, typeOfInfo);
	}

	/*
	 * static method callClassFrequencyChecker checks frequency of words
	 * return type : void
	 */
	static void callClassFrequencyChecker() {
		System.out.println("Please enter strings of words separated by space");
		sc.nextLine();// skip the newline
		String in = sc.nextLine();
		String[] args = in.split(" ");
		System.out.println("Frequency Checker By Using HashMap");
		new FrequencyChecker().frequencyCheckerByHashMap(args);
		System.out.println("Frequency Checker By Using TreeMap");
		new FrequencyChecker().frequencyCheckerByTreeMap(args);
	}

	/*
	 * static method callClassEmployeeSearch searches the employees records
	 * return type : void
	 */
	static void callClassEmployeesSearch() throws FileNotFoundException {
		EmployeeSearch employeeSearch = new EmployeeSearch();
		System.out.println("Enter file path");
		sc.nextLine();// skip the newline
		String filepath = sc.nextLine();
		employeeSearch.setFilePath(filepath);
		System.out.println("Enter last name of employee to search");
		// sc.nextLine();// skip the newline
		String lastName = sc.nextLine();
		employeeSearch.searchEmployee(lastName);
	}

	/*
	 * static method callClassEmployeesSort sort the employee data
	 * return type:void
	 *
	 */
	static void callClassEmployeesSort() throws FileNotFoundException {
		System.out.println("Please enter column name for sorting (e.g firstName,lastName,empType,salary)");
		sc.nextLine();// skip the newline
		String colName = sc.nextLine();
		new EmployeeSortedList().sortByColumn(colName);
	}

	public static void main(String[] args) throws Exception {// main method
		do {
			try {

				System.out.println("Please choose between the following");
				System.out.println("1.Add Numbers");
				System.out.println("2.Change string to lower case or print string array in reverse order");
				System.out.println("3.count frequency of uppercase,lowercase,digits");
				System.out.println("4.Format Date");
				System.out.println("5.Calculate Date Difference");
				System.out.println("6.Add Date");
				System.out.println("7.Use Reflections in java");
				System.out.println("8.Frequency Checker");
				System.out.println("9.Search Employees");
				System.out.println("10.Sorting record columnwise");
				System.out.println("11.Exit");
				System.out.println("Enter your choice");
				Integer choice = sc.nextInt();
				switch (choice) {
				case 1:
					callClassAddNumbers();
					break;
				case 2:
					callClassStringManipulation();
					break;
				case 3:
					callClassStringOperations();
					break;
				case 4:
					callClassDateFormat();
					break;
				case 5:
					callClassDateDifference();
					break;
				case 6:
					callClassDateAdd();
					break;
				case 7:
					callClassReflections();
					break;
				case 8:
					callClassFrequencyChecker();
					break;
				case 9:
					callClassEmployeesSearch();
					break;
				case 10:
					callClassEmployeesSort();
					break;
				default:
					sc.close();
					System.out.println("Exiting");
					System.exit(0);
					break;
				}

			} catch (Exception e) {
				System.out.println("Invalid input provided");
				System.out.println("Please enter input in required format");
			}
		} while (true);

	}
}