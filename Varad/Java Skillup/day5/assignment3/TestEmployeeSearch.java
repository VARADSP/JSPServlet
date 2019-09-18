package day5.assignment3;
/* @author Varad Parlikar Day5 Assignment1*/
import java.io.FileNotFoundException;
/* Class TestEmployeeSearch used to test the EmployeeSearch class and implement its methods
 * @author: Varad Parlikar
 * Created Date: 2019/06/25 */

public class TestEmployeeSearch {
	public static void main(String[] args) throws FileNotFoundException {
		try{
		EmployeeSearch employeeSearch = new EmployeeSearch();
		employeeSearch.setFilePath("Employees.txt");
		employeeSearch.searchEmployee("D'Souza");
	}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}