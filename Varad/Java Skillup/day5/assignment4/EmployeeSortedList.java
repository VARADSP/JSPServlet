package day5.assignment4;
/* @author Varad Parlikar Day5 Assignment1*/
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/* Class EmployeeSortedList contains methods to sort the input data based on columns
 * @author: Varad Parlikar
 * Created Date: 2019/06/25 */

public class EmployeeSortedList {

	 /* method sortByColumn sorts data by using column as key and outputs it on console and also writes data into SortedEmployee.txt file
	  * @String colName to perform sorting on it
     * return type : void*/

	public void sortByColumn(String colName) throws FileNotFoundException{
		ArrayList<GeneralEmployee> emps = new RowReader().readFile("Employees.txt");
		switch(colName){
		case "firstName":sortByFirstName(emps);break;
		case "lastName":sortByLastName(emps);break;
		case "empType":sortByEmpType(emps);break;
		case "salary":sortBySalary(emps);break;
		default:sortByEmpCode(emps);break;
		}
	}

	 /* method sortByFirstName sorts data by using first name of employee as a key
	  * @ArrayList for accessing and sorting employees
    * return type : void*/

	public void sortByFirstName(ArrayList<GeneralEmployee> emps) throws FileNotFoundException{
        Collections.sort(emps, new SortingByFirstName());
        new RowPrinter().printRowsFromList(emps);
        new RowToFileConverter().convertToFile(emps, "SortedEmployees.txt");
	}

	 /* method sortByLastName sorts data by using last name of employee as a key
	  * @ArrayList for accessing and sorting employees
   * return type : void*/

	public void sortByLastName(ArrayList<GeneralEmployee> emps) throws FileNotFoundException{
      Collections.sort(emps, new SortingByLastName());
      new RowPrinter().printRowsFromList(emps);
      new RowToFileConverter().convertToFile(emps, "SortedEmployees.txt");
	}

	 /* method sortByEmpType sorts data by using  employee type of employee as a key
	  * @ArrayList for accessing and sorting employees
   * return type : void*/

	public void sortByEmpType(ArrayList<GeneralEmployee> emps) throws FileNotFoundException{
        Collections.sort(emps, new SortingByEmpType());
        new RowPrinter().printRowsFromList(emps);
        new RowToFileConverter().convertToFile(emps, "SortedEmployees.txt");
	}

	 /* method sortBySalary sorts data by using  employee salary of employee as a key
	  * @ArrayList for accessing and sorting employees
  * return type : void*/

	public void sortBySalary(ArrayList<GeneralEmployee> emps) throws FileNotFoundException{
        Collections.sort(emps, new SortingBySalary());
        new RowPrinter().printRowsFromList(emps);
        new RowToFileConverter().convertToFile(emps, "SortedEmployees.txt");
	}

	 /* method sortByEmpCode sorts data by using  employee code of employee as a key
	  * @ArrayList for accessing and sorting employees
  * return type : void*/

	public void sortByEmpCode(ArrayList<GeneralEmployee> emps) throws FileNotFoundException{
        Collections.sort(emps, new CustomerSortingByEmpCode());
        new RowPrinter().printRowsFromList(emps);
        new RowToFileConverter().convertToFile(emps, "SortedEmployees.txt");
	}

	/* Class SortingByFirstName implements comparator for sorting purpose
	 * @author: Varad Parlikar Created Date: 2019/06/25 */

	class SortingByFirstName implements Comparator<GeneralEmployee> {
        public int compare(GeneralEmployee a, GeneralEmployee b) {
        	 return a.firstName.compareToIgnoreCase(b.firstName);
        }
    }

	/* Class SortingByLastName implements comparator for sorting purpose
	 * @author: Varad Parlikar Created Date: 2019/06/25 */

	class SortingByLastName implements Comparator<GeneralEmployee> {
       public int compare(GeneralEmployee a, GeneralEmployee b) {
       	 return a.lastName.compareToIgnoreCase(b.lastName);
       }
   }

	/* Class SortingByEmpType implements comparator for sorting purpose
	 * @author: Varad Parlikar Created Date: 2019/06/25 */

	class SortingByEmpType implements Comparator<GeneralEmployee> {
        public int compare(GeneralEmployee a, GeneralEmployee b) {
        	 return a.empType.compareToIgnoreCase(b.empType);
        }
    }

	/* Class SortingBySalary implements comparator for sorting purpose
	 * @author: Varad Parlikar Created Date: 2019/06/25 */

	class SortingBySalary implements Comparator<GeneralEmployee> {
        public int compare(GeneralEmployee a, GeneralEmployee b) {
        	 return a.basicSal < b.basicSal ? -1 : a.basicSal == b.basicSal ? 0 : 1;
        }
    }

	/* Class SortingByEmpCode implements comparator for sorting purpose
	 * @author: Varad Parlikar Created Date: 2019/06/25 */

	class CustomerSortingByEmpCode implements Comparator<GeneralEmployee> {
        public int compare(GeneralEmployee a, GeneralEmployee b) {
        	 return Integer.parseInt(a.empCode) < Integer.parseInt(b.empCode) ? -1 : Integer.parseInt(a.empCode) == Integer.parseInt(b.empCode) ? 0 : 1;
        }
    }
}