package day4.assignment4;
/*
 * @author Varad Parlikar Day4 Assignment4
 */

public class TLEmployee extends PLEmployee{
	 /**
     * Class TLEmployee class contains methods extended from PLEmployee to print the messages .
     * @author: Varad Parlikar Created Date: 2019/06/21
     */
	TLEmployee(String fN, String lN) {
		super(fN, lN);
	}
	 /**
     * method doWork calls other methods to implement required behaviour
     * return type : void
     */
	@Override public void doWork() { assignTaskToJunior(); collectReportFromJunior(); reportToSenior();  }
	 /**
     * method assignTaskToJunior implements behaviour
     * return type : void
     */
	private void assignTaskToJunior(){ System.out.println("TL Employee Assigning task to junior");}
	/**
     * method collectReportFromJunior implements behaviour
     * return type : void
     */
	private void collectReportFromJunior(){ System.out.println("TL Employee Collect Report From Junior");}
	/**
     * method reportToSenior implements behaviour
     * return type : void
     */
	public void reportToSenior(){ System.out.println("TL Employee Report To Senior " + firstName +" "+lastName);}

}
