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
 * Servlet implementation class Login
 */
@WebServlet("/assignment6/Login")
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



		//checking is user already logged in
		HttpSession session = request.getSession();

		String isLoggedIn = (String) session.getAttribute("loggedIn");




		System.out.println("In login " + isLoggedIn);




		if(isLoggedIn != null){

			RequestDispatcher requestDispatcher = request.getRequestDispatcher("error/error.jsp");
			requestDispatcher.forward(request,response);
		}


		String cssUrl = request.getContextPath() + "/css/table.css";

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
					request.getSession().setAttribute("authentication", null);



					// Query fire for insertion operation with column name and values
					PreparedStatement prepStmt = connection.prepareStatement("SELECT * from userdetails where userid =?");

					prepStmt.setString(1, username);

					// executing the query for prapared statment
					ResultSet rs = prepStmt.executeQuery();

					if(getRowCount(rs) == 0){
						//wrong user id

						request.getSession().setAttribute("authentication", "notAuthenticated");
						response.sendRedirect(request.getContextPath() + "/assignment6/Login.jsp");

					}

					while (rs.next()) {
						if (username.equals(rs.getString(10)) && password.equals(rs.getString(11))) {
							session.setAttribute("loggedIn", "true");
							request.getSession().setAttribute("authentication", "authenticated");
							out.println("<html>");
							out.println("<head>");
							out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/table.css\"");

							out.println("</head>");

							out.println("<body>");
							out.println("<div style=\"background-color: #333;position:fixed;left:0;overflow: hidden;white-space: nowrap;top:0;width:100%\">");

							out.println("<a type=\"button\" class=\"button\" href=\"Logout\" style=\"text-decoration: none;position:relative;float:right; background: coral;padding: 1em 2em;color: #fff;border: 0;margin:20px;text-decoration:none;display:inline-block;\">Logout</a>");

							out.println("</div>");

							out.println("<div style=\"margin-left:0;margin-top:100px;left:0;clear:both\" class=\"table-wrapper\">");
							out.println("<table class=\"fl-table\">");
							out.println("<thead>");


							out.println("<tr>");
							out.println("<th>");
							out.println("Salutation");
							out.println("</th>");
							out.println("<th>");
							out.println("FirstName");
							out.println("</th>");
							out.println("<th>");
							out.println("MiddleName");
							out.println("</th>");
							out.println("<th>");
							out.println("LastName");
							out.println("</th>");
							out.println("<th>");
							out.println("Gender");
							out.println("</th>");
							out.println("<th>");
							out.println("Email");
							out.println("</th>");
							out.println("<th>");
							out.println("Date Of Birth");
							out.println("</th>");

							out.println("<th>");
							out.println("Address");
							out.println("</th>");
							out.println("<th>");
							out.println("Username");
							out.println("</th>");
							out.println("<th>");
							out.println("Password");
							out.println("</th>");
							out.println("<th>");
							out.println("Interests");
							out.println("</th>");
							out.println("<th>");
							out.println("Other Interests");
							out.println("</th>");
							out.println("<th>");
							out.println("Action");
							out.println("</th>");

							out.println("</tr>");



							out.println("</thead>");
							out.println("</tbody>");
							out.println("<tr>");

							out.println("<td>");
							out.println(rs.getString(2));
							out.println("</td>");
							out.println("<td>");
							out.println(rs.getString(3));
							out.println("</td>");
							out.println("<td>");
							out.println(rs.getString(4));
							out.println("</td>");
							out.println("<td>");
							out.println(rs.getString(5));
							out.println("</td>");
							out.println("<td>");
							out.println(rs.getString(6));
							out.println("</td>");
							out.println("<td>");
							out.println(rs.getString(7));
							out.println("</td>");
							out.println("<td>");
							out.println(rs.getString(8));
							out.println("</td>");
							out.println("<td>");
							out.println(rs.getString(9));
							out.println("</td>");
							out.println("<td>");
							out.println(rs.getString(10));
							out.println("</td>");
							out.println("<td>");
							out.println(rs.getString(11));
							out.println("</td>");
							out.println("<td>");
							out.println(rs.getString(12));
							out.println("</td>");
							out.println("<td>");
							if(!rs.getString(4).isEmpty()){
								out.println(rs.getString(13));

							}
							else{
								out.println("");
							}
							out.println("</td>");

							out.println("<td>");
							out.println("<a type=\"button\" class=\"button\" href=\"EditUserDetails?uid="+rs.getString(1)+"\" style=\"text-decoration: none;position:relative;float:right; background: green;color:fff;padding: 1em 2em;border: 0;\">Edit</a>");
							out.println("</td>");
							out.println("</tr>");

							out.println("</tbody>");
							out.println("</table>");
							// printing the information on web page

							out.println("</div>");
							out.print("<h2 align=\"center\">Successfully logged In </h2>");

							out.println("<div style=\" background-color: #577;padding: 10px;text-align: center;color: white;bottom:0;left:0;position:fixed;width:100%;clear:both;\">");
							out.println("<h1>Unikaihatsu Software Pvt Ltd. Copyright &copy; All rights reserved</h1>");
							out.println("</div>");






							out.println("</html>");






							session.setAttribute("loggedIn", "true");
							request.getSession().setAttribute("authentication", "authenticated");
						} else {
							// wrong password but right user id

							request.getSession().setAttribute("authentication", "notAuthenticated");
							response.sendRedirect(request.getContextPath() + "/assignment6/Login.jsp");
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
