package com.uks.varad.servlet.assignment7;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
 * Servlet implementation class Login
 */
@WebServlet("/assignment7/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Intializing the connection
		Connection connection;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		//checking is user already logged in
		HttpSession session = request.getSession();

		String isLoggedIn = (String) session.getAttribute("loggedIn");
		//List Of Users
		ArrayList<User> users = new ArrayList<User>();
		// For Japanese letter unicode
		request.setCharacterEncoding("utf-8");

		if(isLoggedIn != null){

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("error/error.jsp");
			requestDispatcher.forward(request,response);
		}

		// Getting data from user inputs and stored in local variables
				PrintWriter out = response.getWriter();
				String username = null;
				String password = null;

				if(request.getSession().getAttribute("fromUpdate") != null){
					username = (String) request.getSession().getAttribute("username");
					password = (String) request.getSession().getAttribute("password");
					request.getSession().removeAttribute("fromUpdate");
				}
				else{
					 username = request.getParameter("username");
					 password = request.getParameter("password");
				}

				try {
					request.getSession().setAttribute("authentication", null);
					//displaying user information

					if(username.equals("admin") && password.equals("admin")){

						session.setAttribute("admin", "true");

						session.setAttribute("username", "admin");

						// Query fire for insertion operation with column name and values
						PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from userdetails");

						// executing the query for prapared statment
						ResultSet resultSet = preparedStatement.executeQuery();

						if(getRowCount(resultSet) == 0){
							//wrong user id

							request.getSession().setAttribute("authentication", "notAuthenticated");
							response.sendRedirect(request.getContextPath() + "/assignment7/Login.jsp");

						}
						//User object to store users
						User user = null;

						session.setAttribute("loggedIn", "true");
						request.getSession().setAttribute("authentication", "authenticated");


						while (resultSet.next()) {

							String uid = resultSet.getString(1);
							String salutation = resultSet.getString(2);
							String firstName = resultSet.getString(3);
							String middleName = resultSet.getString(4);
							String lastName = resultSet.getString(5);
							String gender = resultSet.getString(6);
							String email = resultSet.getString(7);
							String dateOfBirth = resultSet.getString(8);
							String address = resultSet.getString(9);
							String username1 = resultSet.getString(10);
							String password1 = resultSet.getString(11);
							String interest = resultSet.getString(12);
							String otherInterest="";
							if(!resultSet.getString(13).isEmpty()){
								session.setAttribute("otherInterest", resultSet.getString(13));
								 otherInterest= resultSet.getString(13);
							}

							user = new User(uid,salutation,firstName,middleName,lastName,gender,email
									,dateOfBirth,address,username1,password1,interest,otherInterest);

							users.add(user);

						}
						session.setAttribute("loggedIn", "true");
						request.getSession().setAttribute("authentication", "authenticated");

						session.setAttribute("usersList", users);

						RequestDispatcher requetsDispatcherObj =request.getRequestDispatcher("UserList.jsp");
						requetsDispatcherObj.forward(request, response);


					}else{

						session.setAttribute("username", username);

						// Query fire for insertion operation with column name and values
						PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from userdetails where userid =?");

						preparedStatement.setString(1, username);

						// executing the query for prapared statment
						ResultSet resultSet = preparedStatement.executeQuery();

						if(getRowCount(resultSet) == 0){
							//wrong user id

							request.getSession().setAttribute("authentication", "notAuthenticated");
							response.sendRedirect(request.getContextPath() + "/assignment7/Login.jsp");

						}
						//User object to store users
						User user = null;

					while (resultSet.next()) {
						if (username.equals(resultSet.getString(10)) && password.equals(resultSet.getString(11))) {
							session.setAttribute("loggedIn", "true");
							request.getSession().setAttribute("authentication", "authenticated");

							String uid = resultSet.getString(1);
							String salutation = resultSet.getString(2);
							String firstName = resultSet.getString(3);
							String middleName = resultSet.getString(4);
							String lastName = resultSet.getString(5);
							String gender = resultSet.getString(6);
							String email = resultSet.getString(7);
							String dateOfBirth = resultSet.getString(8);
							String address = resultSet.getString(9);
							String username1 = resultSet.getString(10);
							String password1 = resultSet.getString(11);
							String interest = resultSet.getString(12);
							String otherInterest="";
							if(!resultSet.getString(13).isEmpty()){
								session.setAttribute("otherInterest", resultSet.getString(13));
								 otherInterest= resultSet.getString(13);
							}

							session.setAttribute("loggedIn", "true");
							request.getSession().setAttribute("authentication", "authenticated");

							user = new User(uid,salutation,firstName,middleName,lastName,gender,email
									,dateOfBirth,address,username1,password1,interest,otherInterest);

							users.add(user);

							session.setAttribute("usersList", users);

							RequestDispatcher requetsDispatcherObj =request.getRequestDispatcher("UserList.jsp");
							requetsDispatcherObj.forward(request, response);

						} else {
							// wrong password but right user id

							request.getSession().setAttribute("authentication", "notAuthenticated");
							response.sendRedirect(request.getContextPath() + "/assignment7/Login.jsp");
						}
					}

				}
			} catch (Exception e) {
					out.print("We are unable to process your request !");
					System.out.println(e);
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
