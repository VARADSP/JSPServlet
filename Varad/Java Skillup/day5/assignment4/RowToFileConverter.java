package day5.assignment4;
/* @author Varad Parlikar Day5 Assignment1*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import day5.assignment4.GeneralEmployee;
import day5.assignment4.RowReader;

/* Class RowToFileConverter provides methods to convert the input data and store it in output file
 * @author: Varad Parlikar
 * Created Date: 2019/06/25 */

public class RowToFileConverter {
	private PrintWriter printWriter;

	 /* method convertToFile converts input data into output file
	  * @String input file path to read from the file
	  * @String output file path to write to the file
	  *
 * return type : void*/

	public void convertToFile(String inputFilePath,String outputFilePath) throws FileNotFoundException{
		ArrayList<GeneralEmployee> employees;
		employees = new RowReader().readFile(inputFilePath);
		File outputFile = new File(outputFilePath);
		printWriter = new PrintWriter(outputFile);
		for(GeneralEmployee emp : employees){
			printWriter.println(emp.empCode+","+emp.firstName+","+ emp.lastName + ","
					+emp.empType+","+emp.basicSal);
		}
		printWriter.close();
	}

	 /* method convertToFile converts input data into output file
	  * @ArrayList to access employees rowset from the file
	  * @String output filepath to write the contents
 * return type : void*/

	public void convertToFile(ArrayList<GeneralEmployee> emps,String outputFilePath) throws FileNotFoundException{
		File outputFile = new File(outputFilePath);
		PrintWriter printWriter = new PrintWriter(outputFile);
		int count=1;
		for (GeneralEmployee emp : emps){
			printWriter.println(emp.empCode+","+emp.firstName+","+ emp.lastName + ","
					+emp.empType+","+emp.basicSal);
			 System.out.println("Employee["+count+++"]:"+emp.empCode);
        	 System.out.println("Name:"+emp.firstName+" "+ emp.lastName);
        	 System.out.println("Employee Type:"+emp.empType);
        	 System.out.println("Salary:"+emp.basicSal);
		}
		printWriter.close();
	}
}
