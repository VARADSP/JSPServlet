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
import javax.servlet.http.HttpSession;

import com.uks.varad.servlet.DatabaseConnection;

/**
 * Servlet implementation class EditUserDetails
 */
@WebServlet("/assignment6/EditUserDetails")
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
		// TODO Auto-generated method stub
		// Getting data from user inputs and stored in local variables
		PrintWriter out = response.getWriter();

		String userId = (String)request.getParameter("uid");

		//checking is user already logged in
		HttpSession session = request.getSession();

		String isLoggedIn = (String) session.getAttribute("loggedIn");


		// connecting to database and returning the con object
		DatabaseConnection dBConnection = new DatabaseConnection();
		try {
			connection = dBConnection.connect();
		} catch (Exception e) {

			System.out.println(e);
			  out.println("<script type=\"text/javascript\">");
	       	   out.println("alert('Error occurred while submitting data, Please try again!');");
	       	   out.println("location='Login.jsp';");
	       	   out.println("</script>");
		}


		try {


			// Query fire for insertion operation with column name and values
			PreparedStatement prepStmt = connection.prepareStatement("SELECT * from userdetails where uid =?");

			prepStmt.setString(1, userId);


			// executing the query for prapared statment
			ResultSet rs = prepStmt.executeQuery();

			if(getRowCount(rs) == 0){
				//wrong user id
				request.getSession().setAttribute("authentication", "notAuthenticated");
				response.sendRedirect(request.getContextPath() + "/assignment6/Login.jsp");

			}

			while (rs.next()) {

			session.setAttribute("userId", userId);

			session.setAttribute("uname", rs.getString("userid"));
			session.setAttribute("password",rs.getString("password"));

			session.setAttribute("salutation", rs.getString("salulation"));
			session.setAttribute("fname", rs.getString("firstname"));
			session.setAttribute("middle", rs.getString("middleinitial"));
			session.setAttribute("lname", rs.getString("lastname"));
			session.setAttribute("sex", rs.getString("gender"));
			session.setAttribute("email", rs.getString("email"));

			String dateOfBirth = rs.getString("dob");

			String dateNumbers[] = dateOfBirth.split("-|/");

			System.out.println(dateNumbers[1]);

			session.setAttribute("year", dateNumbers[0]);


			int m = Integer.parseInt(dateNumbers[1]);
			String month = null;
			if(m == 1){
			    month = "January";
			}else if(m == 2){
			    month  = "February";
			}else if(m == 3){
			   month  = "March";
			}else if(m == 4){
			   month  = "April";
			}else if(m == 5){
			   month  = "May";
			}else if(m == 6){
			   month  = "June";
			}else if(m == 7){
			   month  = "July";
			}else if(m == 8){
			   month  = "August";
			}else if(m == 9){
			   month  = "September";
			}else if(m == 10){
			   month  = "October";
			}else if(m == 11){
			   month  = "November";
			}else if(m == 12){
			   month  = "December";
			}


			session.setAttribute("month", month);



			session.setAttribute("day", dateNumbers[2]);


			session.setAttribute("birth", rs.getString("dob"));
			session.setAttribute("address", rs.getString("address"));


			String areaOfInterestsArray  = rs.getString("areaofinterest");

			String[] areaOfInterests = areaOfInterestsArray.split(",");
			System.out.println(areaOfInterests[0]);
			System.out.println(areaOfInterests[1]);
			;

			session.setAttribute("interest", areaOfInterests);
			session.setAttribute("othinterest", rs.getString("otherinterest"));







			RequestDispatcher requestDispatcher = request.getRequestDispatcher("/assignment6/EditUserDetails.jsp");
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
