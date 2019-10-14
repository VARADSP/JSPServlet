package day5.assignment5;
/* @author Varad Parlikar Day5 Assignment1*/

import java.io.File;
import java.io.FileFilter;
/* Class DirectoryListing contains methods to filter out files from directory recursively based on extensions provided
 * @author: Varad Parlikar
 * Created Date: 2019/06/25 */

public class DirectoryListing implements FileFilter {
	 private String[] allowedExtensions;
	 public DirectoryListing(String[] ext) {
		 allowedExtensions = ext;
	}

	 /* method searchFilesWithExtensions searches files and filters them based on given inputs
	  * @String file path to read the file
	  * @String[] list of extensions to filter the files
	  * @int recursively search or not
  * return type : void*/

	public void searchFilesWithExtensions(String path,String[] ext,int recursive){
		 File dir = new File(path);
		 	if(dir.exists() && dir.isDirectory()){
		 		if(ext[0].equals("*")){
		 			list(dir,ext);
		 		}else{
		 			File[] files = dir.listFiles(new DirectoryListing(ext));
		 			for (File f : files)
					{
			 		if(recursive==1){
			 			list(f,ext);
			 		}
			 		else{
						System.out.println(f.isDirectory()?"":"file: " + f.getName());
			 		}
					}
		 		}
		 		}
		 	else{
		 		System.out.println("Not a directory");
		 	}

	}

	 /* method list searches recursively and prints file names
	  * @File
 * return type : void*/

	public void list(File file,String[] ext){
		 System.out.println(file.getName());
		 	if(file.isDirectory()){
		 		 File[] children = file.listFiles(new DirectoryListing(ext));
				    for (File child : children) {
				        list(child,ext);
				    }
		 	}
		 	else{
		 		return;
		 	}
	}

	 /* method accept checks if the file found is matched with given extensions
	  * @File
 * return type : boolean*/

	@Override
	public boolean accept(File file) {
			for (String extension : allowedExtensions)
		    {
		      if (file.getName().toLowerCase().endsWith(extension) || file.isDirectory())
		      {
		        return true;
		      }
		    }
		 return false;
	}
}