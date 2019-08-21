package com.uks.varad.servlet.assignment5;

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
 * Created Date:14/08/2019
 * Assignment:  Day 1
 * Task: 		Jsp & servlet
 *
 */

/**
 * Servlet implementation class Login
 */
@WebServlet("/assignment5/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Intializing the connection
		private Connection connection;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();

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
		// For Japanese letter unicode
		request.setCharacterEncoding("utf-8");


		//checking is user already logged in
		HttpSession session = request.getSession();


		String isLoggedIn = (String) session.getAttribute("loggedIn");
		if(isLoggedIn != null){

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("error/error.jsp");
			requestDispatcher.forward(request,response);
		}
		// Getting data from user inputs and stored in local variables
				PrintWriter out = response.getWriter();
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				try {
					request.getSession().setAttribute("authentication", null);

					// Query fire for insertion operation with column name and values
					PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from userdetails where userid =?");

					preparedStatement.setString(1, username);

					// executing the query for prapared statment
					ResultSet resultSet = preparedStatement.executeQuery();

					if(getRowCount(resultSet) == 0){
						//wrong user id

						request.getSession().setAttribute("authentication", "notAuthenticated");
						response.sendRedirect(request.getContextPath() + "/assignment5/Login.jsp");

					}
					//displaying user information from database
					while (resultSet.next()) {
						if (username.equals(resultSet.getString(10)) && password.equals(resultSet.getString(11))) {
							session.setAttribute("salutation", resultSet.getString(2));
							session.setAttribute("firstName", resultSet.getString(3));
							session.setAttribute("middleName", resultSet.getString(4));
							session.setAttribute("lastName", resultSet.getString(5));
							session.setAttribute("gender", resultSet.getString(6));
							session.setAttribute("email", resultSet.getString(7));
							session.setAttribute("dateOfBirth", resultSet.getString(8));
							session.setAttribute("address", resultSet.getString(9));
							session.setAttribute("username", resultSet.getString(10));
							session.setAttribute("password", resultSet.getString(11));
							session.setAttribute("interest", resultSet.getString(12));
							if(!resultSet.getString(13).isEmpty()){
								session.setAttribute("otherInterest", resultSet.getString(13));
							}
							else{
								session.setAttribute("otherInterest", "");
							}
							//setting session variables
							session.setAttribute("loggedIn", "true");
							request.getSession().setAttribute("authentication", "authenticated");

							RequestDispatcher requetsDispatcherObj =request.getRequestDispatcher("Display.jsp");
							requetsDispatcherObj.forward(request, response);
						} else {
							// wrong password but right user id

							request.getSession().setAttribute("authentication", "notAuthenticated");
							response.sendRedirect(request.getContextPath() + "/assignment5/Login.jsp");
						}
					}

				} catch (Exception e) {
					out.print("We cant able to process your request");
					System.out.println(e);
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
