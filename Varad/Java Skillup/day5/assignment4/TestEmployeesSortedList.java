package day5.assignment4;
/* @author Varad Parlikar Day5 Assignment1*/

import java.io.FileNotFoundException;

import day5.assignment3.EmployeeSearch;

/* Class TestEmployeesSortedList used to test EmployeesSortedList class and implement its methods
 * @author: Varad Parlikar
 * Created Date: 2019/06/25 */

public class TestEmployeesSortedList {
	public static void main(String[] args) throws FileNotFoundException {
		try{
		new EmployeeSortedList().sortByColumn("firstName");
		EmployeeSearch employeeSearch = new EmployeeSearch();
		employeeSearch.setFilePath("SortedEmployees.txt");
		employeeSearch.searchEmployee("D'Souza");
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
