package day6.assignment2;

/* Class TestExceptionDemo tests the ExceptionDemo class
 * @author: Varad Parlikar
 * Created Date: 2019/06/25
 * */
public class TestExceptionDemo {
	public static void main(String[] args) {
		ExceptionDemo demo = new ExceptionDemo();
		demo.generateIOException();
		demo.generateFileNotFoundException();
		demo.generateException();
	}

}
