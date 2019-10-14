package day4.assignment4;
/*
 * @author Varad Parlikar Day4 Assignment4
 */

public class TestTLEmployee {
	 /**
     * Class TestTLEmployee used to test the interfaces and classes.
     * @author: Varad Parlikar Created Date: 2019/06/21
     */
	public static void main(String[] args) {
		IWork PL1,TL1;
		IReport PL2,TL2;
		PLEmployee plEmployee = new PLEmployee("Alex_PL", "Richard_Pl");
		TLEmployee tlEmployee = new TLEmployee("Alex_TL", "Richard_TL");

		PL1 = plEmployee;
		PL1.doWork();
		TL1 = tlEmployee;
		TL1.doWork();

		PL2 = plEmployee;
		PL2.reportToSenior();
		TL2 = tlEmployee;
		TL2.reportToSenior();

	}
}