package day4.assignment1;
/*
 * @author Varad Parlikar Day4 Assignment1
 */
public class ProjectLeader extends Employee {
	 /**
     * Class ProjectLeader which extends Employee and implements methods to print employee details.
     * @author: Varad Parlikar Created Date: 2019/06/21
     */
		private String mobileNumber;
		public ProjectLeader() { empType="PL"; mobileNumber="+918830256843";	}//constructor
		public ProjectLeader(String firstName,String lastName,String empType,String mobileNumber) {
			super(firstName,lastName,empType);
			this.empType=empType; this.mobileNumber=mobileNumber;
							}//constructor
		 /**
         * method print prints details of employee
         * return type : void
         */
		public void print(){ System.out.println("Employee First Name = "+firstName + "\nEmployee Last Name = "+lastName + "\nEmployee Type = "+empType + "\nEmployee Mobile Number = "+mobileNumber); }
}