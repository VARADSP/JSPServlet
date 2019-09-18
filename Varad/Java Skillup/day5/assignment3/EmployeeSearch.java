package day5.assignment3;
/* @author Varad Parlikar Day5 Assignment1*/

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;
/* Class EmployeeSearch is used to search employees from provide input based on certain parameters
 * @author: Varad Parlikar
 * Created Date: 2019/06/25 */

public class EmployeeSearch {
	String filePath;
	 /* method searchEmployee searches input data and returns resultant rows matched
	  * @String lastName to search the employees
     * return type : void*/

	public void searchEmployee(String lastName) throws FileNotFoundException{
		HashMap<Integer, GeneralEmployee> hashMap = new RowReader().provideDetails(this.filePath);
		TreeMap<Integer,GeneralEmployee> treeMap = new TreeMap<>();
		treeMap.putAll(hashMap);
		 // using for-each loop for iteration over Map.entrySet()
		int count=1;
        for (Entry<Integer, GeneralEmployee> entry : treeMap.entrySet()){
        if(entry.getValue().lastName.equals(lastName)){
        	 System.out.println("Employee["+count+++"]:"+entry.getValue().empCode);
        	 System.out.println("Name:"+entry.getValue().firstName+" "+ entry.getValue().lastName);
        	 System.out.println("Employee Type:"+entry.getValue().empType);
        	 System.out.println("Salary:"+entry.getValue().basicSal);
        }
        }
	}

	 /* method setFilePath used to set the filepath
	  * @String filepath to read the file
     * return type : void*/

	public void setFilePath(String filePath){
		this.filePath = filePath;
	}
}