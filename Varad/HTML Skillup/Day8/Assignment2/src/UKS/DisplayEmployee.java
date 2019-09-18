package UKS;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;
import java.util.*;


/**
 * Servlet implementation class DisplayEmployee
 */

public class DisplayEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


	      // Setting up the content type of webpage
	      response.setContentType("text/html");

	      // Writing message to the web page
	      PrintWriter out = response.getWriter();

	      out.println("<!DOCTYPE HTML>");
	      out.println("<html>");
	      out.println("<head>");
	      out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">");
	      out.println("<title>Display</title>");
	      out.println("<link rel=\"stylesheet\" href=\"css/style2.css\">");
	      out.println("</head>");
	      out.println("<body>");
	      out.println("<div class=\"container\">");

	      out.println("<h1 align=\"center\">Employee Details</h1>");
	      out.println("<table align=\"center\" >");
	      out.println("<tr>");
	      out.println("<td>");




	      String name=request.getParameter("name1");
	      boolean isConnected = false;


	      	try{


	      	Class.forName("com.mysql.jdbc.Driver");

	      	Connection connection = DriverManager.getConnection("jdbc:mysql://172.16.1.15:3306/northwind_varad","varad","varad@654");
	      	Statement statement=connection.createStatement();
	      	ResultSet resultSet=statement.executeQuery("select * from employees_test where Name='"+name+"'");


	      	int size = 0;
	      	// calculating total resultset size
	      	try {
	      		resultSet.last();
	      		size = resultSet.getRow();
	      		resultSet.beforeFirst();

	      	} catch (Exception ex) {
	      		ex.printStackTrace();
	      	}
	    	if(size!=0){



	    		 while (resultSet.next()) {


	    			 out.println("<div class=\"fetchedData\">");

	    			  out.println(" <p>Name : ");
	    			  out.println(resultSet.getString(2));
	    		      out.println("</p>");
	    		      out.println("</div>");
	    		      out.println("<div class=\"fetchedData\">");
	    		      out.println(" <p>Contact No : ");
	    			  out.println(resultSet.getString(3));
	    		      out.println("</p>");
	    		      out.println("</div>");
	    		      out.println("<div class=\"fetchedData\">");
	    		      out.println(" <p>Role : ");
	    			  out.println(resultSet.getString(4));
	    		      out.println("</p>");
	    		      out.println("</div>");

	    		 }
	    			isConnected = true;
	   	 }else{
	   		 if(!name.isEmpty()){

	   			 out.println("<div class=\"fetchedData\">");
   		      out.println(" <p> ");
   			  out.println("No Data Found !");
   		      out.println("</p>");
   		      out.println("</div>");


	   		 }
	   		 }
	   		}
	   	catch(Exception e){

	   		// if database not availble reading from local storage


	   		String filePath = "D:\\PRTOT\\NEWWSPRTOT\\EmployeesManager\\WebContent\\localstorage\\employees.txt";

	   		File file = new File(filePath);

	   	   	Scanner scanner = new Scanner(file);
	   		boolean isFound = false;
	   	    String[] line;
	   	    String inputName = name;
	   	    while(scanner.hasNextLine()){
	   	    	try{
	   	    		line = scanner.nextLine().split(",");
	   				if(line[0].equalsIgnoreCase(name)){
	   				isFound = true;



	   				out.println("<div class=\"fetchedData\">");

	    			  out.println(" <p>Name : ");
	    			  out.println(line[0]);
	    		      out.println("</p>");
	    		      out.println("</div>");
	    		      out.println("<div class=\"fetchedData\">");
	    		      out.println(" <p>Contact No : ");
	    			  out.println(line[1]);
	    		      out.println("</p>");
	    		      out.println("</div>");
	    		      out.println("<div class=\"fetchedData\">");
	    		      out.println(" <p>Role : ");
	    			  out.println(line[2]);
	    		      out.println("</p>");
	    		      out.println("</div>");





	   				}
				}
	    	catch(Exception e1){
	    		continue;
	    	}




	    	}
	    if(isFound == false){

			// no data found
			if(isConnected == false){
				out.println("No Data Found !");
			}

	    }
	    scanner.close();

	}


	      	out.println("</td>");
	      	out.println("</tr>");
	      	out.println("</table>");
	      	out.println("</div>");
	      	out.println("</body>");
	      	out.println("<br><br><br><br>");

	      	out.println("<a type=\"button\" class=\"button\" href=\"display.jsp\" style=\"text-decoration: none;\">Go Back</a>");

	      	out.println("</html>");


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
