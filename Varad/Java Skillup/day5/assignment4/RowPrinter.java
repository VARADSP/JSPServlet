package day5.assignment4;
/* @author Varad Parlikar Day5 Assignment1*/
import java.io.FileNotFoundException;
import java.util.ArrayList;
/* Class RowPrinter provides methods to read a file and print data from the file
 * @author: Varad Parlikar
 * Created Date: 2019/06/25 */
public class RowPrinter {
	 /* method printRows prints data from the input file
	  * @String filepath to read from the file
 * return type : void*/
	public void printRows(String filePath) throws FileNotFoundException{
		ArrayList<GeneralEmployee> employees;
		employees = new RowReader().readFile(filePath);
		int count=1;
		for(GeneralEmployee emp : employees){
			 System.out.println("Employee["+count+++"]:"+emp.empCode);
        	 System.out.println("Name:"+emp.firstName+" "+ emp.lastName);
        	 System.out.println("Employee Type:"+emp.empType);
        	 System.out.println("Salary:"+emp.basicSal);
		}
	}
	 /* method printInTabularFormat prints data in tabular format
	  * @String
 * return type : void*/
	public void printInTabularFormat(String filePath) throws FileNotFoundException{
		ArrayList<GeneralEmployee> employees;
		employees = new RowReader().readFile(filePath);
		System.out.println("empCode\tfirstName\tlastName\tempType\tSalary");
		for(GeneralEmployee emp : employees){
				System.out.println("\n"+emp.empCode+"\t"+emp.firstName+"\t"+ emp.lastName
						+ "\t"+emp.empType+"\t"+emp.basicSal);
		}
	}
	 /* method printRowsFromList prints data from the array list provided
	  * @ArrayList
 * return type : void*/
	public void printRowsFromList(ArrayList<GeneralEmployee> emps){
		System.out.println("empCode\tfirstName\tlastName\tempType\tSalary");
		for(GeneralEmployee emp : emps){
			System.out.println("\n"+emp.empCode+"\t"+emp.firstName+"\t"+ emp.lastName
					+ "\t"+emp.empType+"\t"+emp.basicSal);
	}
	}
}