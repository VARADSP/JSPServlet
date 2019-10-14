package day4.assignment3;
/*
 * @author Varad Parlikar Day4 Assignment3
 */

abstract class BaseEmployee {
	 /**
     * Abstract Class BaseEmployee contains employee details and abstract methods.
     * @author: Varad Parlikar Created Date: 2019/06/21
     */
	protected String firstName;
	protected String lastName;
	private String basicSalary;
	public String empType;
	 public BaseEmployee(String firstName,String lastName) {
		 this.firstName = firstName ; this.lastName = lastName;
	}
	 abstract void doWork();
}