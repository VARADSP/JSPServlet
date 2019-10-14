package day5.assignment4;
/* @author Varad Parlikar Day5 Assignment1*/
/* Class GeneralEmployee basic structure of the general employee
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