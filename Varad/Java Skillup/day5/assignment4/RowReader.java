package day5.assignment4;
/* @author Varad Parlikar Day5 Assignment1*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;
import day5.assignment4.GeneralEmployee;
/* Class RowReader provides methods to read from file and output data in output file separeted by comma
 * @author: Varad Parlikar
 * Created Date: 2019/06/25 */

public class RowReader {
	private Scanner src;

	 /* method readFile reads data from the input file
	  * @String filepath to read from the file
 * return type : ArrayList*/

	public ArrayList<GeneralEmployee> readFile(String filePath) throws FileNotFoundException{
			File fin = new File(filePath);
		    src = new Scanner(fin);
		    String[] line;
		    ArrayList<GeneralEmployee> employees = new ArrayList<>();
		    while(src.hasNextLine()){
		    	try{
		    		line = src.nextLine().split(",");
			    	employees.add(new GeneralEmployee(line[0],line[1],line[2],line[3]));
		    	}
		    	catch(Exception e){
		    		continue;
		    	}
		    }
		    src.close();
			return employees;
	}

	 /* method provideDetails puts data into treemap
	  * @String file path to read from the file
 * return type : TreeMap*/

	public TreeMap<Integer, GeneralEmployee> provideDetails(String filePath) throws FileNotFoundException{
		TreeMap<Integer, GeneralEmployee> treeMap = new TreeMap<>();
		ArrayList<GeneralEmployee> emps = readFile(filePath);
		for(GeneralEmployee e : emps){
			treeMap.put(Integer.parseInt(e.empCode), e);
		}
		return treeMap;
	}
}