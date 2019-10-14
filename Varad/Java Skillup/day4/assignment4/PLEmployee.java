package day4.assignment4;
/*
 * @author Varad Parlikar Day4 Assignment4
 */
public class PLEmployee extends BaseEmployee implements IReport {
	 /**
     * Class PLEmployee implements IReport and its methods to print employee data.
     * @author: Varad Parlikar Created Date: 2019/06/21
     */
	String mobileNumber;
	//constructor
	PLEmployee(String fN,String lN) { firstName = fN; lastName = lN; empType = "PL"; mobileNumber = "+918830468766"; }
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
	public void reportToSenior(){ System.out.println("Report To Senior " + getFirstName() +" "+getLastName());}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}