package ie.ucc.bis.supportinglife.utilities;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * 
 * Class providing Date/Time utility methods 
 * 
 * @author timothyosullivan
 */
public class DateUtilities {
	
	private static final String DATE_TIME_CUSTOM_FORMAT = "dd MMMM yyyy";
	private static final Locale LOCALE = Locale.UK;

	
	/**
	 * Utility method to return today's date
	 * 
	 * @return String - TimeStamp in milliseconds
	 * 
	 */
	public static Date getTodaysDate() {
		Calendar cal = Calendar.getInstance(Locale.UK);
		SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_TIME_CUSTOM_FORMAT, LOCALE);
		Date todayDate = null;
		
		try {
			todayDate = dateFormat.parse(dateFormat.format(cal.getTime()));
		} catch (ParseException e) {
			System.out.println("Exception Thrown: Attempting to produce today's date in correct format");
			e.printStackTrace();
		}
		return todayDate;
	}
	
}
