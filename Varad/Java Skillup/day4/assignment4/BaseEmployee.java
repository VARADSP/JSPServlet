package day4.assignment4;
/*
 * @author Varad Parlikar Day4 Assignment4
 */

abstract class BaseEmployee implements IWork,IReport {
	 /**
     * Abstract BaseEmployee acts as a base class and implements IWork and IReport interfaces and its methods.
     * @author: Varad Parlikar Created Date: 2019/06/20
     */
	 String firstName,lastName,empType,basicSalary;
	 public abstract void doWork();
	 public abstract void reportToSenior();
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	public String getBasicSalary() {
		return basicSalary;
	}
	public void setBasicSalary(String basicSalary) {
		this.basicSalary = basicSalary;
	}

}