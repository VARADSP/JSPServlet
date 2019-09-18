package day5.assignment3;

/* @author Varad Parlikar Day5 Assignment1*/
/* Class GeneralEmployee provides general structure of the employee
 * @author: Varad Parlikar
 * Created Date: 2019/06/25 */

public class GeneralEmployee extends BaseEmployee {
	String empType,empCode;
	Integer basicSal;
	public GeneralEmployee(String ec,String name,String eT,String sal) {
		String[] n = name.split(" ");
		firstName = n[0];	lastName=n[1]; empType=eT;empCode=ec;
		basicSal = (int) (Integer.parseInt(sal)+(12.5/100)*Integer.parseInt(sal));
	}
}