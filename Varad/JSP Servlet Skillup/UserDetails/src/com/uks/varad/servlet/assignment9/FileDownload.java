package com.uks.varad.servlet.assignment9;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author: 	Varad Paralikar
 * Created Date:22/08/2019
 * Assignment:  Day 5
 * Task: 		Jsp & servlet
 *
 */
/**
 * Servlet implementation class FileDownload
 */
@WebServlet("/assignment9/FileDownload")
public class FileDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String DOWNLOAD_DIRECTORY = "D:\\PRTOT\\NEWWSPRTOT\\UserDetails\\WebContent\\assignment9\\FilesAvailable";
	private ArrayList<Files> files;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownload() {
        super();
        // TODO Auto-generated constructor stub
    }

	@Override
	public void init() throws ServletException {
		super.init();
		files = new ArrayList<Files>();
	}

	/**
     * List all files from a directory and its subdirectories
     * @param directoryName to be listed
     * return type:void
     */
    public void listFiles(String directoryName){
    	files.clear();
        File directory = new File(directoryName);
        //get all the files from a directory
        File[] fileList = directory.listFiles();
        Files fileObject = null;
        int count=0;
        for (File file : fileList){
            if (file.isFile()){
                System.out.println(file.getAbsolutePath());
                count++;
                fileObject = new Files(Integer.toString(count),file.getName(), file.getAbsolutePath(), Long.toString(file.length()));
                files.add(fileObject);


            } else if (file.isDirectory()){
                listFiles(file.getAbsolutePath());
            }
        }
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//if directory does not exist
		 File directory = new File(DOWNLOAD_DIRECTORY);
		    if (! directory.exists()){
		    	request.getRequestDispatcher("Error.jsp").forward(request, response);
		    }
		    String fileUrl = request.getParameter("fileUrl");
		    if(fileUrl == null){
		    	//listing files
			    listFiles(DOWNLOAD_DIRECTORY);
		    }
		    else{
		    	// For Japanese letter unicode
				request.setCharacterEncoding("utf-8");
				response.setCharacterEncoding("utf-8");

		    	 String fileName1 = request.getParameter("fileName");

		    	 String fileName = URLEncoder.encode(fileName1, "UTF-8");
		    	 response.setHeader("Content-Disposition","attachment; filename="+fileName );

		    	// set the content type
				response.setContentType("APPLICATION/OCTET-STREAM");
				// setting the file content with the header and file name
				response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

				// creating writer object
				PrintWriter out = response.getWriter();
				// file input stream with file path
				FileInputStream fileInputStream = new FileInputStream(fileUrl);
				// Getting the file
				int i;
				while ((i = fileInputStream.read()) != -1) {
					out.write(i);
				}
				fileInputStream.close();
		    }
		    request.getSession().setAttribute("fileList", files);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	@Override
	public void destroy() {
		super.destroy();
		files.clear();
	}
}
