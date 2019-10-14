package day1.assignment4;
/**
 * @author Varad Parlikar Day1 Assignment4
 */
public class MultiCommandLine {//
    /**
     * Class MultiCommandLine containing doOperation method
     * @author: Varad Parlikar
     * Created Date: 2019/06/18
     */
    Integer sum=0;
    public void doOperation(String[] args) { //
        /**
         * method for calculating sum and converting argument to lowercase
         * return type : void
         */
        if (args[0].equals("1")) {
            for (int i = 1; i < args.length; i++) {
                try {// try catch for validating strings or numbers
                    sum=sum+Integer.parseInt(args[i]);
                } catch (NumberFormatException e) {
                    continue; // if it is string,not adding it to sum variable
                }
                catch(Exception e) {
                    continue;
                }
            }
            System.out.println("Sum=" + sum);
        }
        if (args[0].equals("2")) {
            for (int i=1; i < args.length; i++) {
                try {
                    Integer.parseInt(args[i]);
                    continue; // ignoring if it is number
                } catch (NumberFormatException e) {
                    System.out.println(args[i].toLowerCase());
                }
                catch(Exception e) {
                    continue;
                }
            }
        }
    }
}