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
import javax.websocket.Session;

import com.uks.varad.servlet.DatabaseConnection;

/**
 * @author: 	Varad Paralikar
 * Created Date:19/08/2019
 * Assignment:  Day 1
 * Task: 		Jsp & servlet
 *
 */
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
	DatabaseConnection databaseConnection = new DatabaseConnection();
	try {
		 connection  = databaseConnection.connect();
	} catch (Exception e) {
		System.out.println(e);
	}
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
				String salutation = request.getParameter("sal1");
				String firstName = request.getParameter("firstName");
				String middleName = request.getParameter("middleName");
				String lastName = request.getParameter("lastName");
				String sex = request.getParameter("gender");
				String email = request.getParameter("emailId");
				String dobYear = request.getParameter("year");
				String dobMonth = request.getParameter("month");

				int month =1;

				switch(dobMonth){
				case "January" : month = 1;break;
				case "February" : month = 2;break;
				case "March" : month = 3;break;
				case "April" : month = 4;break;
				case "May" : month = 5;break;
				case "June" : month = 6;break;
				case "July" : month = 7;break;
				case "August" : month = 8;break;
				case "September" : month = 9;break;
				case "October" : month = 10;break;
				case "November" : month = 11;break;
				case "December" : month = 12;break;
				}
				String dobDay = request.getParameter("day");
				String dateOfBirth = dobYear+"/"+month+"/"+dobDay;

				String address = request.getParameter("address");
				String userName = request.getParameter("uname");
				String password = request.getParameter("pass");

			//	Reader reader = new InputStreamReader(get.openStream(), "UTF-8");

				// Storing multiple interest in array
				String[] interest = request.getParameterValues("interests");
				// Storing interest in local variable
						String allIneterest = "";
						for (int i = 0; i < interest.length; i++) {
							allIneterest += interest[i] + ",".trim();
						}
				String othInterest = request.getParameter("otherInterests");

				try {
					// Query fire for insertion operation with column name and values
					String query = "UPDATE userdetails SET salulation=?,firstname=?,middleinitial=?,lastname=?,gender=?,email=?,dob=?,address=?,userid=?,password=?,areaofinterest=?,otherinterest=? WHERE uid=?";

					PreparedStatement preparedStatement = connection.prepareStatement(query);

					// Set all variable values in prepared statment
					preparedStatement.setString(1, salutation);
					preparedStatement.setString(2, firstName);
					preparedStatement.setString(3, middleName);
					preparedStatement.setString(4, lastName);
					preparedStatement.setString(5, sex);
					preparedStatement.setString(6, email);
					preparedStatement.setString(7, dateOfBirth);
					preparedStatement.setString(8, address);
					preparedStatement.setString(9, userName);
					preparedStatement.setString(10, password);
					preparedStatement.setString(11, allIneterest);
					preparedStatement.setString(12, othInterest);
					preparedStatement.setString(13, userId);

					// executing the query
					int i = preparedStatement.executeUpdate();
					if (i > 0) {
						out.println("<h1 align=\"center\"><b>User Details updated successfully !</b></h1>");

				       	request.getSession().setAttribute("username", userName);
				       	request.getSession().setAttribute("password", password);
				       	request.getSession().setAttribute("fromUpdate", "true");
				       	request.getSession().removeAttribute("loggedIn");

				       	request.getSession().setAttribute("isUpdated", "true");

				   //	out.println("<a type=\"button\" class=\"button\" href=\"Logout\" style=\"text-decoration: none;position:relative;float:right; background: coral;padding: 1em 2em;color: #fff;border: 0;margin:20px;text-decoration:none;display:inline-block;\">Logout</a>");
				    	RequestDispatcher requestDispatcher = request.getRequestDispatcher("Login");
						requestDispatcher.forward(request, response);
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
