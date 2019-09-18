package day5.assignment3;
/* @author Varad Parlikar Day5 Assignment1*/

import java.io.FileNotFoundException;
import java.util.ArrayList;
/* Class RowPrinter provides methods to read a file and print data from the file
 * @author: Varad Parlikar
 * Created Date: 2019/06/25 */

public class RowPrinter {
	 /* method printRows used to print data from the input file
	  * @String filepath to read the file
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
}