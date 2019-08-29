package com.uks.varad.servlet.assignment7;

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
import javax.servlet.http.HttpSession;

import com.uks.varad.servlet.DatabaseConnection;
/**
 * @author: 	Varad Paralikar
 * Created Date:19/08/2019
 * Assignment:  Day 1
 * Task: 		Jsp & servlet
 *
 */

/**
 * Servlet implementation class EditUserDetails
 */
@WebServlet("/assignment7/EditUserDetails")
public class EditUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Intializing the connection
			Connection connection;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init() throws ServletException {
  	   // Initialization code...
  	connection = null;

 // connecting to database and returning the con object
 		DatabaseConnection databaseConnection = new DatabaseConnection();
 		try {
 			connection = databaseConnection.connect();
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

		// Getting data from user inputs and stored in local variables
		PrintWriter out = response.getWriter();

		String userId = (String)request.getParameter("uid");

		//checking is user already logged in
		HttpSession session = request.getSession();


		// For Japanese letter unicode
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		try {
			// Query fire for insertion operation with column name and values
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from userdetails where uid =?");

			preparedStatement.setString(1, userId);
			// executing the query for prapared statment
			ResultSet resultSet = preparedStatement.executeQuery();

			if(getRowCount(resultSet) == 0){
				//wrong user id
				request.getSession().setAttribute("authentication", "notAuthenticated");
				response.sendRedirect(request.getContextPath() + "/assignment7/Login.jsp");

			}


			//entering user information into session variables
			while (resultSet.next()) {
			session.setAttribute("userId", userId);
			session.setAttribute("uname", resultSet.getString("userid").trim());
			session.setAttribute("password",resultSet.getString("password").trim());
			session.setAttribute("salutation", resultSet.getString("salulation"));
			session.setAttribute("fname", resultSet.getString("firstname").trim());
			session.setAttribute("middle", resultSet.getString("middleinitial").trim());
			session.setAttribute("lname", resultSet.getString("lastname").trim());
			session.setAttribute("sex", resultSet.getString("gender").trim());
			session.setAttribute("email", resultSet.getString("email").trim());

			String dateOfBirth = resultSet.getString("dob");

			String dateNumbers[] = dateOfBirth.split("-|/");

			System.out.println(dateNumbers[1]);

			session.setAttribute("year", dateNumbers[0]);


			int m = Integer.parseInt(dateNumbers[1]);
			String month = null;


			switch(m){
			case 1: month = "January";break;
			case 2 : month  = "February";break;
			case 3 :  month  = "March";break;
			case 4 :  month  = "April";break;
			case 5 : month  = "May";break;
			case 6 :month  = "June";break;
			case 7 : month  = "July";break;
			case 8 :month  = "August";break;
			case 9 :month  = "September";break;
			case 10 :month  = "October";break;
			case 11 : month  = "November";break;
			case 12 :month  = "December";break;
			default:month  = "December";break;
			}

			session.setAttribute("month", month);
			session.setAttribute("day", dateNumbers[2]);
			session.setAttribute("birth", resultSet.getString("dob"));
			session.setAttribute("address", resultSet.getString("address").trim());

			String areaOfInterestsArray  = resultSet.getString("areaofinterest");
			String[] areaOfInterests = areaOfInterestsArray.split(",");

			session.setAttribute("interest", areaOfInterests);
			session.setAttribute("othinterest", resultSet.getString("otherinterest"));

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/assignment7/EditUserDetails.jsp");
			requestDispatcher.forward(request, response);
			}

		} catch (Exception e) {
			out.print("We are unable to process your request !");
			e.printStackTrace();
		}
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
