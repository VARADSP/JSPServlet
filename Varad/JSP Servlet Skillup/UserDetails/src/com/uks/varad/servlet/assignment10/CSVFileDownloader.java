package com.uks.varad.servlet.assignment10;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.uks.varad.servlet.DatabaseConnection;
import com.uks.varad.servlet.assignment9.Files;
/**
 * @author: 	Varad Paralikar
 * Created Date:23/08/2019
 * Assignment:  Day 1
 * Task: 		Jsp & servlet
 *
 */
/**
 * Servlet implementation class Login
 */
@WebServlet("/assignment10/CSVFileDownloader")
public class CSVFileDownloader extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Intializing the connection
		Connection connection;
		private final String DOWNLOAD_DIRECTORY = "D:\\PRTOT\\NEWWSPRTOT\\UserDetails\\WebContent\\assignment10\\FilesAvailable";
		ArrayList<User> users;
		/**
     * @see HttpServlet#HttpServlet()
     */
    public CSVFileDownloader() {
        super();
        // TODO Auto-generated constructor stub
    }
    public void init() throws ServletException {
 	   // Initialization code...
 	connection = null;
 	users = new ArrayList<User>();

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
		//List Of Users

		//if directory does not exist
		 File directory = new File(DOWNLOAD_DIRECTORY);
		    if (! directory.exists()){
		    	request.getRequestDispatcher("Error.jsp").forward(request, response);
		    }
		    Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
	        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	        String fileName = timeStamp+".csv";
		// For Japanese letter unicode
		request.setCharacterEncoding("utf-8");
		// Getting data from user inputs and stored in local variables
				PrintWriter out = response.getWriter();
			    String isDownload = request.getParameter("download");
			    if(isDownload == null){
			    	//Display users
			    	users.clear();
			    	try {
						request.getSession().setAttribute("authentication", null);
						//displaying user information
							// Query fire for insertion operation with column name and values
							PreparedStatement preparedStatement = connection.prepareStatement("SELECT * from userdetails");
							// executing the query for prapared statment
							ResultSet resultSet = preparedStatement.executeQuery();
							if(getRowCount(resultSet) == 0){
								//wrong user id
								response.sendRedirect(request.getContextPath() + "/assignment10/Error.jsp");
							}
							int count = 0;
							//User object to store users
							User user = null;
							while (resultSet.next()) {
								count++;

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

								user = new User(Integer.toString(count),uid,salutation,firstName,middleName,lastName,gender,email
										,dateOfBirth,address,username1,password1,interest,otherInterest);

								users.add(user);

							}
				} catch (Exception e) {
						out.print("We are unable to process your request !");
						System.out.println(e);
					}
			    }
			    else{

			    	//Download CSV File
			    	try
			    	{
			    	FileWriter fileWriter = new FileWriter(DOWNLOAD_DIRECTORY+"\\"+fileName);
			    	PrintWriter printWriter = new PrintWriter(fileWriter);
			    	printWriter.print("UserNo");
			    	printWriter.print(',');
			    	printWriter.print("Salutation");
			    	printWriter.print(',');
			    	printWriter.print("FirstName");
			    	printWriter.print(',');
			    	printWriter.print("MiddleName");
			    	printWriter.print(',');
			    	printWriter.print("LastName");
			    	printWriter.print(',');
			    	printWriter.print("Gender");
			    	printWriter.print(',');
			    	printWriter.print("Email");
			    	printWriter.print(',');
			    	printWriter.print("DateOfBirth");
			    	printWriter.print(',');
			    	printWriter.print("Address");
			    	printWriter.print(',');
			    	printWriter.print("Userid");
			    	printWriter.print(',');
			    	printWriter.print("Password");
			    	printWriter.print(',');
			    	printWriter.print("AreaOfInterest");
			    	printWriter.print(',');;
			    	printWriter.print("OtherInterest");
			    	printWriter.println();
			    	String query = "select * from userdetails";

			    	Statement statement = connection.createStatement();
			    	ResultSet resultSet = statement.executeQuery(query);
			    	int count = 0;
			    	while(resultSet.next())
			    	{
			    		count++;
			    		printWriter.print(Integer.toString(count).trim());
				    	printWriter.print(',');
			    		printWriter.print(resultSet.getString(2).trim());
				    	printWriter.print(',');
				    	printWriter.print(resultSet.getString(3).trim());
				    	printWriter.print(',');
				    	printWriter.print(resultSet.getString(4).trim());
				    	printWriter.print(',');
				    	printWriter.print(resultSet.getString(5).trim());
				    	printWriter.print(',');
				    	printWriter.print(resultSet.getString(6).trim());
				    	printWriter.print(',');
				    	printWriter.print(resultSet.getString(7).trim());
				    	printWriter.print(',');
				    	printWriter.print(resultSet.getString(8).trim());
				    	printWriter.print(',');
				    	printWriter.print(resultSet.getString(9).trim());
				    	printWriter.print(',');
				    	printWriter.print(resultSet.getString(10).trim());
				    	printWriter.print(',');
				    	printWriter.print(resultSet.getString(11).trim());
				    	printWriter.print(',');
				    	String[] areaOfInterest = resultSet.getString(12).trim().split(",");

				    	String areaOfInterests="";

				    	for(String interest : areaOfInterest){
				    		areaOfInterests = areaOfInterests + " " + interest;
				    	}
				    	printWriter.print(areaOfInterests);
				    	printWriter.print(',');
				    	String otherInterest = resultSet.getString(13).trim();

				    	printWriter.print(otherInterest!=""?otherInterest:" ");
				    	printWriter.print(',');
				    	printWriter.println();
			    	}

			    	fileWriter.flush();
			    	fileWriter.close();
			    	// set the content type
					response.setContentType("APPLICATION/OCTET-STREAM");





					// setting the file content with the header and file name
					response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

					// creating writer object
					PrintWriter out2 = response.getWriter();
					// file input stream with file path
					FileInputStream fileInputStream = new FileInputStream(DOWNLOAD_DIRECTORY+"\\"+fileName);
					// Getting the file
					int i;
					while ((i = fileInputStream.read()) != -1) {
						out2.write(i);
					}
					fileInputStream.close();
			    	}
			    	catch(Exception e) {
			    		out.print("We are unable to process your request !");
			    		System.out.println(e);
			    	}
			    }
				session.setAttribute("usersList", users);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	public void destroy() {
		users.clear();
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
