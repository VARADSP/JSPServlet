/**
 *
 */
package com.uks.varad.struts.commons.utils;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

/**
 * @author: 	Varad Paralikar
 * Created Date:02/08/2019
 * Assignment:  Day 4
 * Task: 		Struts And Hibernate Skillup
 *
 */


/*
 * Class CommonLogic is used to implement common logic
 * @author: Varad Parlikar
 * Created Date: 2019/08/29
 */
public class CommonLogic {

	public static void saveFile(File file, String fileName, String filesDirectory) throws IOException{

        File dir = new File (filesDirectory);
        if ( !dir.exists() )
           dir.mkdirs();

        String targetPath =  dir.getPath() + File.separator + fileName;
        File destinationFile = new File (targetPath);
		FileUtils.copyFile(file, destinationFile);


	}


}