package com.uks.varad.servlet.assignment6;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uks.varad.servlet.DatabaseConnection;

/**
 * Servlet implementation class UpdateUserDetails
 */
@WebServlet("/assignment6/UpdateUserDetails")
public class UpdateUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Intializing the connection
	Connection connection;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {
  	   // Initialization code...
  	connection = null;
  	}

    /*
   	 * method getRowCount returns total number of rows in a table.
   	 * return type : int
   	 */
   	public int getRowCount(ResultSet resultSet){
   		int size = 0;
   		// calculating total resultset size
   		try {
   			resultSet.last();
   			size = resultSet.getRow();
   			resultSet.beforeFirst();

   		} catch (Exception ex) {
   			ex.printStackTrace();
   		}
   		return size;
   	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// For Japanese letter unicode
				request.setCharacterEncoding("utf-8");

				String userId = request.getParameter("userId");

				// getting the user input data from jsp pages using PrintWriter
				PrintWriter out = response.getWriter();
				String sal = request.getParameter("sal1");
				String fname = request.getParameter("firstName");
				String mname = request.getParameter("middleName");
				String lname = request.getParameter("lastName");
				String sex = request.getParameter("gender");
				String email = request.getParameter("emailId");
				String dobYear = request.getParameter("year");
				String dobMonth = request.getParameter("month");



				System.out.println("In Update user details " + dobMonth);
				int month =1;

				if(dobMonth.equals("January")){
				    month = 1;
				}else if(dobMonth.equals("February")){
				    month  = 2;
				}else if(dobMonth.equals("March")){
				   month  = 3;
				}else if(dobMonth.equals("April")){
				   month  = 4;
				}else if(dobMonth.equals("May")){
				   month  = 5;
				}else if(dobMonth.equals("June")){
				   month  = 6;
				}else if(dobMonth.equals("July")){
				   month  = 7;
				}else if(dobMonth.equals("August")){
				   month  = 8;
				}else if(dobMonth.equals("September")){
				   month  = 9;
				}else if(dobMonth.equals("October")){
				   month  = 10;
				}else if(dobMonth.equals("November")){
				   month  = 11;
				}else if(dobMonth.equals("December")){
				   month  = 12;
				}





				String dobDay = request.getParameter("day");
				String dob = dobYear+"/"+month+"/"+dobDay;

				String address = request.getParameter("address");
				String uname = request.getParameter("uname");
				String pass = request.getParameter("pass");






			//	Reader reader = new InputStreamReader(get.openStream(), "UTF-8");

				// Storing multiple interest in array
				String[] interest = request.getParameterValues("interests");
				// Storing interest in local variable
						String allIneterest = "";
						for (int i = 0; i < interest.length; i++) {
							allIneterest += interest[i] + ",".trim();
						}
				String othInterest = request.getParameter("otherInterests");

				DatabaseConnection databaseConnection = new DatabaseConnection();
				try {
					 connection  = databaseConnection.connect();
				} catch (Exception e) {
					  out.println("<script type=\"text/javascript\">");
		       	   out.println("alert('Error occurred while submitting data, Please try again!');");
		       	   out.println("location='Login.jsp';");
		       	   out.println("</script>");
				}


				try {
					// Query fire for insertion operation with column name and values
					String query = "UPDATE userdetails SET salulation=?,firstname=?,middleinitial=?,lastname=?,gender=?,email=?,dob=?,address=?,userid=?,password=?,areaofinterest=?,otherinterest=? WHERE uid=?";

					PreparedStatement prepStmt = connection.prepareStatement(query);

					// Set all variable values in prepared statment



					prepStmt.setString(1, sal);
					prepStmt.setString(2, fname);
					prepStmt.setString(3, mname);
					prepStmt.setString(4, lname);
					prepStmt.setString(5, sex);
					prepStmt.setString(6, email);
					prepStmt.setString(7, dob);
					prepStmt.setString(8, address);
					prepStmt.setString(9, uname);
					prepStmt.setString(10, pass);
					prepStmt.setString(11, allIneterest);
					prepStmt.setString(12, othInterest);
					prepStmt.setString(13, userId);


					// executing the query
					int i = prepStmt.executeUpdate();
					if (i > 0) {
						out.println("<h1 align=\"center\"><b>User Details updated successfully !</b></h1>");



				       	request.getSession().setAttribute("username", uname);
				       	request.getSession().setAttribute("password", pass);

				       	request.getSession().setAttribute("fromUpdate", "true");


				       	System.out.println("In Update Before Removing "+request.getSession().getAttribute("loggedIn"));

				       	request.getSession().removeAttribute("loggedIn");
				    	System.out.println("In Update After removing "+request.getSession().getAttribute("loggedIn"));


					//	out.println("<a type=\"button\" class=\"button\" href=\"Logout\" style=\"text-decoration: none;position:relative;float:right; background: coral;padding: 1em 2em;color: #fff;border: 0;margin:20px;text-decoration:none;display:inline-block;\">Logout</a>");
				    	RequestDispatcher rd = request.getRequestDispatcher("Login");
						rd.forward(request, response);


					} else {

						out.println("<div style=\"background-color: #333;position:fixed;left:0;overflow: hidden;white-space: nowrap;top:0;width:100%\">");

						out.println("<a type=\"button\" class=\"button\" href=\"Logout\" style=\"text-decoration: none;position:relative;float:right; background: coral;padding: 1em 2em;color: #fff;border: 0;margin:20px;text-decoration:none;display:inline-block;\">Logout</a>");

						out.println("<h1 align=\"center\" style=\"color:red;top:200px;\"><b>Can not update user details !</b></h1>");

						out.println("</div>");


					}


				} catch (Exception e) {
					out.println("<div style=\"background-color: #333;position:fixed;left:0;overflow: hidden;white-space: nowrap;top:0;width:100%\">");

					out.println("<a type=\"button\" class=\"button\" href=\"Logout\" style=\"text-decoration: none;position:relative;float:right; background: coral;padding: 1em 2em;color: #fff;border: 0;margin:20px;text-decoration:none;display:inline-block;\">Logout</a>");
					out.print("<h1 align=\"center\" style=\"color:red;\"><b>We cant able to process your request!</b></h1>");

					out.println("</div>");
					System.out.println(e);


				}
				out.close();




	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}



	public void destroy() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
