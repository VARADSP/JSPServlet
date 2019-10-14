/**
 *
 */
package com.uks.varad.struts.commons.utils;
import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 * @author: 	Varad Paralikar
 * Created Date:02/09/2019
 * Assignment:  Day 4
 * Task: 		Struts And Hibernate Skillup
 *
 */


/*
 * Class CommonLogic is used to implement common logic
 * @author: Varad Parlikar
 * Created Date: 2019/08/02
 */
public class CommonLogic {

	/*
	 * method static uploadFile uploads the file to destination directory
	 * @String file which is file object
	 * @String fileName which is file name
	 * @String filesDirectory which is file upload directory
	 * return type : void
	 */
	public static void uploadFile(File file, String fileName, String filesDirectory) throws IOException{

        File dir = new File (filesDirectory);
        if ( !dir.exists() )
           dir.mkdirs();
        // for japanese characters

        String targetPath =  dir.getPath() + File.separator + fileName;
        File destinationFile = new File (targetPath);
		FileUtils.copyFile(file, destinationFile);

	}

}