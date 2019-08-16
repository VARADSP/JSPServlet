package com.uks.varad.servlet.assignment5;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.uks.varad.servlet.DatabaseConnection;

/**
 * Servlet implementation class Login
 */
@WebServlet("/assignment5/Login")
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


		String cssUrl = request.getContextPath() + "/css/table.css";

		// Getting data from user inputs and stored in local variables
				PrintWriter out = response.getWriter();


				String username = request.getParameter("username");
				String password = request.getParameter("password");
				// connecting to database and returning the con object
				DatabaseConnection dBConnection = new DatabaseConnection();
				try {
					connection = dBConnection.connect();
				} catch (Exception e) {

					System.out.println(e);
					  out.println("<script type=\"text/javascript\">");
			       	   out.println("alert('Error occurred while submitting data, Please try again!');");
			       	   out.println("location='index.jsp';");
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
						response.sendRedirect(request.getContextPath() + "/assignment5/Login.jsp");

					}

					while (rs.next()) {
						if (username.equals(rs.getString(10)) && password.equals(rs.getString(11))) {
							out.println("<html>");
							out.println("<head>");
							out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"css/table.css\"");
							out.println("</head>");

							out.println("<body>");
							out.println("<div class=\"table-wrapper\">");
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

							out.println("</tr>");

							out.println("</tbody>");
							out.println("</table>");
							out.println("</div>");

							out.println("</html>");


							// printing the information on web page
							out.print("<h2 align=\"center\">Successfully login user </h2>");
							request.getSession().setAttribute("authentication", "authenticated");
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
