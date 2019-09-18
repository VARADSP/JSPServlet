package day7.assignment4;

/* Class EmployeeDetail demonstrates the use of serialization and deserialization by using employee data
 * @author: Varad Parlikar
 *  Created Date: 2019/06/26
 */
public class EmployeeDetail implements java.io.Serializable {
	String name;
	Integer age;
	Double salary;

	EmployeeDetail(String name, Integer age, Double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
}
