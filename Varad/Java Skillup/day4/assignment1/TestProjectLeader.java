package day4.assignment1;
/*
 * @author Varad Parlikar Day4 Assignment1
 */
public class TestProjectLeader {
	 /**
     * Class TestProjectLeader used to test the ProjectLeader Class.
     * @author: Varad Parlikar Created Date: 2019/06/21
     */
	public static void main(String[] args) {//main method
		try{
			new ProjectLeader(args[0],args[1],args[2],args[3]).print();
		}
		catch(Exception e){
			System.out.println("Please Enter value from command line");
		}
	}
}