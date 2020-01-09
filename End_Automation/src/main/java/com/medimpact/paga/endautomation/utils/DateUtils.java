package com.medimpact.paga.endautomation.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class DateUtils {
	/**
	 * "yyyy-MM-dd'T'HH:mm:ss.SSSZ"
	 * "yyyyMMdd"
	 */
	
	public static String getStringDate(Long Millisecond,String formatDate){
		long totalMilliSeconds = System.currentTimeMillis()+Millisecond;
        Date date = new Date();
        date.setTime(totalMilliSeconds);
        SimpleDateFormat df = new SimpleDateFormat(formatDate);
        String format = df.format(date);
		return format;
	}
	
	

}
