package day9_11.assignment1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
/* 
 * Class Finder extends Thread class provides functionality to authenticate users based on their roles and provide searching of employees,managers,admin on given parameters. 
 * @author: Varad Parlikar
 *  Created Date: 2019/07/02
 */
public class Finder extends Thread {
    private String userId,userName,userAddress,userRole,userCity,userTelephoneNumber,userSalary;
    private static Scanner scanner;
    private boolean isLoggedIn =false;
    private static File sharedResource = new File("C:\\Users\\Varad\\eclipse-workspace\\Demo\\src\\day9_11\\assignment1\\SharedResource\\SharedFile.txt");
	
    /* 
     * start method which starts the thread execution by calling authenticate process.
     * return type : void
     */
    @Override
	public synchronized void start() {

		super.start();
		
		System.out.println("Finder process started");
		//starting authenticate process to sign in for users
		authenticate();
	}
	
    /* 
     * authenticate method which is used to authenticate user by using username and password by matching them with shared resource data.
     * return type : void
     */
	public synchronized void authenticate() {
	   int countDown = 3;
	   boolean isFound=false;
	   String username,password,line = null;
	   String tokens[];
	   do {
	       scanner = new Scanner(System.in);
	       try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }
	       System.out.println("----------------------------------------------------------------------------------------------------------------------");
	       System.out.println("Enter your user name");
	       username = scanner.next();
	       System.out.println("Enter your password for "+username);
           password = scanner.next();
           try {
            scanner = new Scanner(sharedResource);
            while(scanner.hasNext()) {
                line = scanner.nextLine();
                if(line.contains(username)) {
                    tokens = line.split(",");
                    if(tokens[1].trim().equals(username) && tokens[2].trim().equals(password)) {
                        System.out.println("Authentication is successful");
                        isFound=true;
                        break;
                    }
                }    
            }  
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
           if(isFound==false) {//for invalid username or password
               --countDown;
               System.err.println("Either username or password is wrong. Please try again.");      
           }else {
               break;   
           }
	   }while(countDown != 0);
	   
	      if(countDown == 0) {// invoked after three incorrect trials
	          System.err.println("The System gets closed because the data you have provided is not valid. Please re-confirm it.");
	          System.exit(1);
	      }  
	      //calling displayInfo which displays info of user
	      displayInfo(line);
	}
	
	/* 
     * displayInfo method which displays user information which is currently logged in to the system and displays menu to user.
     * @String userInfo which contains user id to set appropriate user information in the system.
     * return type : void
     */
	public void displayInfo(String userInfo) {
	    isLoggedIn = true;
	    String tokens[] = userInfo.split(",");
	    String userId = tokens[0];
	    for(User user : Loader.users) {
	        if(user.getUserId().toString().equals(userId)) {//sets logged users information to private variables and displays information
	            System.out.println("-------------------------------------------");
	        this.userId = user.getUserId().toString();
	        this.userName = user.getName();
	        this.userAddress = user.getAddress();
	        this.userCity = user.getCity();
	        this.userRole = user.getUserRole();
	        this.userSalary = user.getSalary();
	        this.userTelephoneNumber = user.getTelNumber().toString();
	        //getEmployeeInfo() gets employee information
	        getEmployeeInfo();
	        if(userRole.contains("admin")) {
	            getMenu("admin");
	        }
	        else if(userRole.contains("manager")) {
	            getMenu("manager");
	        }
	        else {
	            getMenu("employee");
	        }
	        
	        
	        }
	    }
	    
	    
	}
	
	/* 
     * getEmployeeInfo method which displays user information.
     * return type : void
     */
	private void getEmployeeInfo() {
	    System.out.println("-------------------------------------------");
        System.out.println("User ID :"+userId);
        System.out.println("User Name :"+userName);
        System.out.println("User Role :"+userRole);
        System.out.println("User Address :"+userAddress);
        System.out.println("User City :"+userCity);
        System.out.println("User Telephone :"+userTelephoneNumber);
        System.out.println("User Salary :"+userSalary);               
        System.out.println("-------------------------------------------");
	}
	
	
	/* 
     * getMenu method which displays menu to the user depending on the different user roles.
     * @String filter which is the value containing user roles to filter the menu depending on the role.
     * return type : void
     */
	private void getMenu(String filter) {
	    if(isLoggedIn == true) {
	    scanner = new Scanner(System.in);
	    System.out.println("-------------------"+filter+" dashboard-------------------------");
	   // if(filter.equals("admin") || filter.equals("manager")) {  
	    do {
	        if(filter.equals("admin") || filter.equals("manager")) {//filtering functionalities based on roles
	        System.out.println("Display a list(Press L) ==> Submenus");
	        System.out.println("Search For Employee(Press S) ==> Submenus");
	        }
	        System.out.println("Display User Information(D)");
	        System.out.println("Log Off (O)");
	        System.out.println("Exit (X)");
	        String input = scanner.next();
	        if(filter.trim().equals("employee")) {//prevents unauthorized actions
	            if(input.trim().equals("L") || input.trim().equals("S")) {
	                input = "default";
	            }
	        }
	        switch(input) {
	        case "L":getSubmenu("list",filter);break; //calling getSubmenu to get sub menu for further actions
	        case "S":getSubmenu("search",filter);break; // calling getSubmenu to get sub menu for further actions
	        case "D":getEmployeeInfo();break;//calling getEmployeeInfo to get logged users information
	        case "O":logOff();break;//calling logOff to log out the user
	        case "X" :System.out.println("Exiting System..."); System.exit(0);break; // to exit the system
	        default:System.out.println("Invalid input provided for role "+filter);break;
	        }	        
	    }while(true);
	    }
	    else { System.out.println("Employee"); }
	    }
//	}
	
	/* 
     * logOff method which clears current logged in user's information from the system and logs out the user from the system and calls
     * authenticate method to start the log in process. 
     * return type : void
     */
	private void logOff() {
	    this.isLoggedIn = false;
	    this.userAddress = null;
	    this.userCity = null;
	    this.userId = null;
	    this.userName = null;
	    this.userRole = null;
	    this.userSalary  = null;
	    this.userTelephoneNumber = null;
	    System.out.println("User Logged Off");
	    //calling authenticate to again log in the user
	    authenticate();
	}
	
	/* 
     * getSubmenu method which creates a sub menu for logged user to provide the required functionality to list and search the employee data set. 
     * @String filterForMenu which is used to filter the menu provided to the user
     * @String filterForRole which is used to limit the access given to the users depending on their roles
     * return type : void
     */
	private void getSubmenu(String filterForMenu,String filterForRole) {
	    do {
	        System.out.println("\t 1.Back to Main Menu(B)");
            if(filterForRole.equals("manager") || filterForRole.equals("admin")) {//filtering functionalities based on roles
                System.out.println("\t 2.Press \"E\" for Employees");
            }
            if(filterForRole.equals("admin")) {//filtering functionalities based on roles
                System.out.println("\t 3.\"M\" for Manager");
            } 
            if(filterForRole.equals("admin")) {//filtering functionalities based on roles
                System.out.println("\t 4. \"A\" for Admin");
            }
            if(filterForRole.equals("admin")) {//filtering functionalities based on roles
                System.out.println("\t 5. \"All\" for all"); 
            }
            String input = scanner.next();
            if(filterForRole.trim().equals("manager")) {// prevents unauthorized actions
                if(input.trim().equals("All") || input.trim().equals("A") || input.trim().equals("M")) {
                    input = "default";
                }
            }
            switch(input) {
            case "B":getMenu(filterForRole);break; // calling getMenu to go backward in from submenu to main menu
            //calls getList if logged user chooses to view list of employees and calls search function if searching is required
            case "E" : if(filterForMenu.equals("list")) {getList("employee");} if(filterForMenu.equals("search")) {search("employee");};break;
            //calls getList if logged user chooses to view list of managers and calls search function if searching is required
            case "M" : if(filterForMenu.equals("list")) {getList("manager");} if(filterForMenu.equals("search")) {search("manager");};break;
            //calls getList if logged user chooses to view list of admins and calls search function if searching is required
            case "A" : if(filterForMenu.equals("list")) {getList("admin");} if(filterForMenu.equals("search")) {search("admin");};break;
            //calls getList if logged user chooses to view list of all employees and calls search function if searching is required
            case "All" : if(filterForMenu.equals("list")) {getList("All");} if(filterForMenu.equals("search")) {search("All");};break;
            default:System.out.println("Invalid input provided for role "+filterForRole);break;
            }           
	    }while(true);
	}
	
	
	
	/* 
     * search method provides the search functionality to search user data set and provide search results based on given parameters by the user.
     * @String filter which contains user role to filter the data set limiting the access given to the user logged in 
     * return type : void
     */
	private void search(String filter) {
	    Set<User> sortedSet = new HashSet<User>();   
	    
	    
	    for(User u : Loader.users) {
	        String user = u.toString();
	        if(user.contains(filter.trim())) {
	            sortedSet.add(u); // adding filtered users to HashSet 
	        }
	    }
//	    System.out.println("Prepared Set : ");
//	    System.out.println(sortedSet);
	    System.out.println("Enter name/address/city/telephone/salary to search and filter the results");
	    String filterValue = scanner.next();

	    System.out.println("Search Results : ");
	    Iterator<User> it = sortedSet.iterator();
	    boolean isFound = false;
        while(it.hasNext()) {
          User value = it.next();
          String searchIn = value.toString();
          if(searchIn.contains(filterValue.trim())) { // searching records for provided parameters in hash set
              System.out.println("-------------------------------------------");
              
              System.out.println("Userid : "+value.userId);
              System.out.println("Name : "+value.name);
              System.out.println("Address : "+value.address);
              System.out.println("City: "+value.city);
              System.out.println("Basic Salary : "+value.salary);
              System.out.println("TelNumber: "+value.TelNumber);
              System.out.println("-------------------------------------------");
              
              isFound = true;
          }
         }
        if(isFound==false) {
            System.out.println("No search results found for given parameter!");
        }
	}
	
	/* 
     * getList method lists the data set depending on the provided filter for filtering the list of employees.
     * @String filter which contains user role to limit the data visible to the logged in user 
     * return type : void
     */
	private void getList(String filter) {
	    for(User user : Loader.users) {
	        if(user.getUserRole().contains(filter) || filter.equals("All")) {//filters the list based on provided parameter
	            System.out.println("-------------------------------------------");
	            
	            System.out.println("Userid : "+user.userId);
	            System.out.println("Name : "+user.name);
	            System.out.println("Address : "+user.address);
	            System.out.println("City: "+user.city);
	            System.out.println("Basic Salary : "+user.salary);
	            System.out.println("TelNumber: "+user.TelNumber);
	            System.out.println("-------------------------------------------");
	            
	        }
	    }
	}
	

	/* 
     * run method which starts the thread execution. 
     * return type : void
     */
	@Override
	public void run() {

		super.run();
	
	}

}
