package day5.assignment2;
/* @author Varad Parlikar Day5 Assignment1*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import day5.assignment2.GeneralEmployee;
import day5.assignment2.RowReader;
/* Class RowToFileConverter provides methods to convert the
 *  input data and store it in output file
 * @author: Varad Parlikar
 * Created Date: 2019/06/25 */
public class RowToFileConverter {
	private PrintWriter printWriter;

	 /* method convertToFile converts input array list data into output file by using file writing
	  * @String input file path to read the file
	  * @String ouput file path to write the contents
	  *
     * return type : void*/
	public void convertToFile(String inputFilePath,String outputFilePath) throws FileNotFoundException{
		ArrayList<GeneralEmployee> employees;
		employees = new RowReader().readFile(inputFilePath);
		File outputFile = new File(outputFilePath);
		printWriter = new PrintWriter(outputFile);
		int count=1;
		for(GeneralEmployee emp : employees){
			printWriter.println("\nEmployee["+count+++"]:"+emp.empCode+"\nName:"+emp.firstName+" "+ emp.lastName + ""			+ "\nEmployee Type:"+emp.empType+"\nSalary:"+emp.basicSal);
			 System.out.println("Employee["+count+++"]:"+emp.empCode);
        	 System.out.println("Name:"+emp.firstName+" "+ emp.lastName);
        	 System.out.println("Employee Type:"+emp.empType);
        	 System.out.println("Salary:"+emp.basicSal);
		}
		printWriter.close();
	}
}