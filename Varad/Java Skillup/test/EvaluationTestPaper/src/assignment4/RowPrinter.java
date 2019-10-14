package assignment4;
 /* @author Varad Parlikar Day5 Assignment1*/

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
/* Class RowPrinter provides methods to read a file and print data from the file
 * @author: Varad Parlikar
 * Created Date: 2019/06/25
 */
import java.util.Map;
import java.util.Map.Entry;

/* Class RowPrinter reads data from employee data set and prints them in row by row format
 * @author: Varad Parlikar
   Created Date: 2019/06/25
 */
public class RowPrinter {
	/* method printRows used to print employee data by reading input file
	 * @String filepath for reading the file
     * return type : void
     */

    public void displayEmployees(ArrayList<GeneralEmployee> employees) {
        int count=1;
        for(GeneralEmployee emp : employees){
            System.out.println("Employee["+count+++"]:"+emp.empCode);
            System.out.println("Name:"+emp.firstName+" "+ emp.lastName);
            System.out.println("Employee Type:"+emp.empType);
            System.out.println("Salary:"+emp.basicSal);
   }
}
    /* 
     * method displayEmployee displays employee information.
     * @GeneralEmployee which is a class containing data variables needed to represent employee structure
     * return type : void
     */
    public void displayEmployee(GeneralEmployee employee) {
        System.out.println("Employee:"+employee.empCode);
        System.out.println("Name:"+employee.firstName+" "+ employee.lastName);
        System.out.println("Employee Type:"+employee.empType);
        System.out.println("Salary:"+employee.basicSal);
    }
    /* 
     * method printRows displays employee information.
     * @String filepath which is path of file to be read
     * return type : void
     */
	public void printRows(String filePath) throws FileNotFoundException{
		ArrayList<GeneralEmployee> employees;
		employees = new RowReader().readFile(filePath);
		displayEmployees(employees);
		
	}
	
	/* 
     * method sortRows sorts employee list according to emp code as a key and puts data into hash map.
     * @String filepath which is path of file to be read
     * return type : void
     */
	public void sortRows(String filePath) throws FileNotFoundException{
	    
	    ArrayList<GeneralEmployee> employees = new RowReader().readFile(filePath);
	    
	    System.out.println("Before Sorting List of Employees");
	    
	    displayEmployees(employees);
        
	    System.out.println("After Sorting List of Employees\n\n");
	    
	    Collections.sort(employees, new CustomerSortingByEmpCode());
	    HashMap<Integer,GeneralEmployee> employeeMap = new HashMap<Integer,GeneralEmployee>();
        for(GeneralEmployee e : employees){
            employeeMap.put(Integer.parseInt(e.empCode), e);
        }
        
        // Display the TreeMap which is naturally sorted 
        for (Entry<Integer, GeneralEmployee> entry : employeeMap.entrySet()) {
            displayEmployee(entry.getValue());      
        }  
	}
	/* Class CustomerSortingByEmpCode which implements comparator to sort the employees according to empcode
	 * @author: Varad Parlikar
	   Created Date: 2019/06/25
	 */
	class CustomerSortingByEmpCode implements Comparator<GeneralEmployee> {
        public int compare(GeneralEmployee a, GeneralEmployee b) {
             return Integer.parseInt(a.empCode) < Integer.parseInt(b.empCode) ? -1 : Integer.parseInt(a.empCode) == Integer.parseInt(b.empCode) ? 0 : 1;
        }
    }
	
}
