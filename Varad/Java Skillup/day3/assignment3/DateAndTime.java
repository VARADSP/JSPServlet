package day3.assignment3;
import java.text.DateFormat;
/**
 * @author Varad Parlikar Day3 Assignment3
 */
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class DateAndTime {
    /**
     * Class DateAndTime which contains methods to show date in specified format
     * @author: Varad Parlikar Created Date: 2019/06/20
     */
	 /**
     * method showDate used to show date in format type
     * @String
     * @String return type : void
     */
    public void showDate(String outputFormatType, String date)throws Exception {
    	 DateTimeFormatter dtf = DateTimeFormatter.ofPattern(outputFormatType);
    	 Integer year,month,day;
    	 String[] args = date.split("/");
    	 year = Integer.parseInt(args[0]);
    	 month = Integer.parseInt(args[1]);
    	 day = Integer.parseInt(args[2]);
    	 LocalDate ld = LocalDate.of( year , month , day );
        System.out.println(dtf.format(ld));
    }
    /**
     * method showDate prints today's date in given format
     * @String return type : void
     */
    public void showDate(String outputFormatType) throws Exception {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(outputFormatType);
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
}