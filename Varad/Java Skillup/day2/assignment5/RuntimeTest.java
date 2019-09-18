package day2.assignment5;
/**
 * @author Varad Parlikar Day2 Assignment5
 */
import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 *RuntimeTest class for implementing methods of process builder class and runtime class
 * @author: Varad Parlikar
 * Created Date: 2019/06/19
 */
public class RuntimeTest {//
	 /**
     * method openNotepadWithProcessBuilderClass is used to open notepad by using ProcessBuilder class
     * return type : void
     */
    public void openNotepadWithProcessBuilderClass() {//
        ProcessBuilder pb = new ProcessBuilder("Notepad.exe");
        try {
            pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * method with runtime class
     * return type : void
     */
    public void openNotepadWithRuntimeClass() {//
        Runtime runtime = Runtime.getRuntime();
        try {
             runtime.exec("notepad C:\\test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * methodprinting environment variables
     * return type : void
     */
    public void printEnvironmentVariables() {//
        ProcessBuilder pb = new ProcessBuilder();
        Map<String, String> envMap = pb.environment();
        Set<String> keys = envMap.keySet();
        for (String key : keys) {
            System.out.println(key + " ==> " + envMap.get(key));
        }
    }
    public static void main(String[] args) { // main method
        RuntimeTest runtimeTest = new RuntimeTest();
        runtimeTest.openNotepadWithProcessBuilderClass();
       // runtimeTest.openNotepadWithRuntimeClass();
        runtimeTest.printEnvironmentVariables();
    }
}