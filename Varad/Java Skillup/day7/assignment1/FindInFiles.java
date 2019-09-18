package day7.assignment1;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* Class FindInFiles contains methods to search a specific word in single or multiple files in a directory and return the results
 * @author: Varad Parlikar
 *  Created Date: 2019/06/26
 */
public class FindInFiles {
	/* method readFromFile reads from the file and performs the required search
	 * @String searchName which is the word to be searched
	 * @String filepath file path to be searched
	 * return type : void
	 */
	public void readFromFile(String searchName, String filepath) throws IOException {
		FileInputStream fin = new FileInputStream(filepath);
		String nameToBeSearched = searchName;
		boolean isFound = false;
		boolean check = false;
		FileChannel inChannel = fin.getChannel();
		MappedByteBuffer mappedByteBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
		byte[] buffer = new byte[(int) inChannel.size()];
		mappedByteBuffer.get(buffer);
		fin.close();
		BufferedReader in = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(buffer)));
		int linenumber = 0;
		for (String line = in.readLine(); line != null; line = in.readLine()) {
			linenumber++;
			isFound = searchFromFile(filepath, linenumber, nameToBeSearched, line);
			
			if(isFound == true) {
			    check = true;
			}
		}
		if(check == false) {
		    System.out.println("No record found for "+filepath);
		}
		in.close();
	}

	/* method readFromDirectory reads from the directory files and performs the required search
	 * @String searchName which is the word to be searched
	 * @String filepath directory path to be searched
	 * return type : void
	 */
	public void readFromDirectory(String searchName, String directoryPath) throws IOException {
		File dir = new File(directoryPath);
		String[] children = dir.list();
		if (children == null) {
			System.out.println("does not exist or is not a directory");
		} else {
			for (int i = 0; i < children.length; i++) {
				String filename = children[i];
				readFromFile(searchName, directoryPath + "/" + filename);
			}
		}
	}

	/* method searchFromFile searches for the word in the file and provides its details such as line number,file name etc
	 * @String filepath provides path for the file to be searched
	 * @int linenumber provides line number
	 * @String searchName provides name to be searched
	 * @String line provides line to be searched for the searchName parameter
	 * return type : void
	 */
	public boolean searchFromFile(String filepath, int linenumber, String searchName, String line) throws IOException {
		if (line.matches(searchName) || line.contains(searchName)) {
			System.out.println(filepath + "\t" + linenumber + ":" + searchName);
			return true;
		}
		else {
		    return false;    
		}
        
	}
}