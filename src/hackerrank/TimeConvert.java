package hackerrank;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeConvert {
	
	public static void main(String[] args) {
		Date date = new Date();
		Calendar calender = Calendar.getInstance();
	    SimpleDateFormat sdf;
	    sdf = new SimpleDateFormat("hh:mm:ss aaa");
	    System.out.println(sdf.format(date));
	}

}
