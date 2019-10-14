package day4.assignment3;
/*
 * @author Varad Parlikar Day4 Assignment3
 */

public class PLEmployee extends BaseEmployee {
	 /**
     * Class PLEmployee extends BaseEmployee and implements methods to print employee details.
     * @author: Varad Parlikar Created Date: 2019/06/21
     */
	private String mobileNumber;
	//constructor
	PLEmployee(String fN,String lN) { super(fN,lN); firstName = fN; lastName = lN; empType = "PL"; mobileNumber = "+918830468766"; }
	 /**
     * method doWork calls other methods to implement required behaviour
     * return type : void
     */
	@Override public void doWork() { assignTaskToJunior(); collectReportFromJunior(); reportToSenior();  }
	 /**
     * method assignTaskToJunior implements behaviour
     * return type : void
     */
	private void assignTaskToJunior(){ System.out.println("Assigning task to junior");}
	/**
     * method collectReportFromJunior implements behaviour
     * return type : void
     */
	private void collectReportFromJunior(){ System.out.println("Collect Report From Junior");}
	/**
     * method reportToSenior implements behaviour
     * return type : void
     */
	private void reportToSenior(){ System.out.println("Report To Senior " + firstName +" "+lastName);}
}