package day9_11.assignment1;

/* 
 * Class TestUserInteraction acts as a driver class to implement UserInteraction object methods to test the functionalities  
 * @author: Varad Parlikar
 *  Created Date: 2019/07/02
 */
public class TestUserInteraction {
    public static void main(String[] args) {//main method
        try {
        UserInteraction interaction = new UserInteraction();
        interaction.start();//calls UserInteraction start method and starts the system
    }
        catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
     }
}
