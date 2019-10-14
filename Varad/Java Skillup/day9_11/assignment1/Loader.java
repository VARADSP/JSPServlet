package day9_11.assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/* 
 * Class Loader extends Thread class loades users information from properties file into shared resource and users collection dataset for working of finder functionality  
 * @author: Varad Parlikar
 *  Created Date: 2019/07/02
 */
public class Loader extends Thread {
	private String filePathForUserLoginInfo; // stores user login information file path
	private String filePathForUserInfo;// stores user information file path
	//shared resource file for concurrent access by threads
	private static File sharedResource = new File("C:\\Users\\Varad\\eclipse-workspace\\Demo\\src\\day9_11\\assignment1\\SharedResource\\SharedFile.txt");
	private static Scanner scanner;
	private static String mode;
	private static File fileToRead;// used for reading the file


	public static boolean isUsersListAvailable; // detecting if users list is available or not
	public static ArrayList<User> users = new ArrayList<User>();// users collection data set


	//constructor to load the paths for userInfo and userLoginInfo into the private variables for further use
	public Loader(){
		File propertiesFile = new File("C:\\Users\\Varad\\eclipse-workspace\\Demo\\src\\day9_11\\assignment1\\properties.txt");
		try {
			setMode("READ");
			scanner = new Scanner(propertiesFile);
			filePathForUserInfo = scanner.nextLine();
			filePathForUserLoginInfo = scanner.nextLine();
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}


	}


	/* 
     * start method which starts thread execution process. 
     * return type : void
     */
	@Override
	public synchronized void start() {
		super.start();
		System.out.println("Loader Process Started");		
	}
	
	/* 
     * getMode which returns thread READ or WRITE mode. 
     * return type : String
     */
	public String getMode() {
		return mode;
	}

	/* 
     * setMode which sets thread READ or WRITE mode. 
     * @String mode which can READ or WRITE
     * return type : void
     */
	public void setMode(String mode) {
		Loader.mode = mode;
	}

	/* 
     * getUserInfo which gets user information and stores it in shared resource. 
     * return type : boolean
     */
	public synchronized boolean getUserInfo(){
		if(getMode().equals("READ")){// If it is READ mode
		fileToRead = new File(filePathForUserInfo); // reading users information
		try {
			scanner = new Scanner(fileToRead);
			PrintWriter printToSharedResource = new PrintWriter(sharedResource);
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				printToSharedResource.println(line); // calling printToSharedResource to save data to shared resource
			}
			scanner.close();
			printToSharedResource.close();

			setMode("WRITE");//setting WRITE mode
			return true;

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		}
		return false;// if unsuccessful in getting user information
	}

	/* 
     * getUserLoginInfo which gets user login information from from the file and stores it in shared resource. 
     * return type : void
     */
	public synchronized void getUserLoginInfo(){
		if(getMode().equals("READ")){
			fileToRead = new File(filePathForUserLoginInfo);
			try {
				scanner = new Scanner(fileToRead);
				PrintWriter printToSharedResource = new PrintWriter(sharedResource);
				while(scanner.hasNextLine()){
					String line = scanner.nextLine();
					printToSharedResource.println(line);// calling printToSharedResource to save data to shared resource
				}
				
				scanner.close();
				printToSharedResource.close();
				setMode("READ");

			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			}
	}
	
	/* 
     * getUserRole which returns user roles by using provided user id.
     * @String userId provided for searching the particular user roles. 
     * return type : String
     */
	private String getUserRole(String userId) {
        String result = "";
	    try {
            Scanner scanningForUserRoles = new Scanner(new File(filePathForUserLoginInfo));//reading userLoginInfo file using scanner
            String[] tokens;
            String line;
            while(scanningForUserRoles.hasNextLine()){
                line = scanningForUserRoles.nextLine();
                tokens = line.split(","); // separating tokens on comma separator
                if(tokens[0].equals(userId)) {
                   //getting user roles such as employee , manager, admin
                    result = tokens[3] + ","+ result;
                }
            }
           
            scanningForUserRoles.close();
            
            
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
	    return result; // returning user roles

	    
     
	    
	}

	/* 
     * mergeInfoAsObjects merges the information from shared resource and prepares the user data set. 
     * return type : boolean
     */
	public synchronized boolean mergeInfoAsObjects(){
		if(getMode().equals("WRITE")){
			try{
				scanner = new Scanner(sharedResource); // reading shared resource file using scanner
				String[] tokensForUserInfo;
				String lineForUserInfo;


				while(scanner.hasNextLine()){
					lineForUserInfo = scanner.nextLine();
					tokensForUserInfo = lineForUserInfo.split(","); // getting tokens from shared resource
					String userRole = getUserRole(tokensForUserInfo[0]);
					// preparing user information data in collection set
					users.add(new User(Integer.parseInt(tokensForUserInfo[0]), tokensForUserInfo[1], userRole, tokensForUserInfo[2], tokensForUserInfo[3], tokensForUserInfo[4], Long.parseLong(tokensForUserInfo[5])));
				}
				scanner.close();
				setMode("READ");//setting READ mode for threads
				return true;
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
        return false;//if unsuccessful in creating collection set


	}
	

	/* 
     * run method which starts thread execution. 
     * return type : void
     */
	@Override
	public void run() {

		super.run();
		boolean gotUserInfo = false;


		if(getMode().equals("READ")){ // if mode is set to READ 
			gotUserInfo = getUserInfo(); // calling getUserInfo to get user information
		}
		if(getMode().equals("WRITE") && gotUserInfo==true){
		    isUsersListAvailable = mergeInfoAsObjects(); // calling mergeInfoAsObjects to prepare collection set of user data
		}

		if(getMode().equals("READ")&&isUsersListAvailable == true){
			getUserLoginInfo();// preparing shared resource of user login information
		}
	
	}
}
