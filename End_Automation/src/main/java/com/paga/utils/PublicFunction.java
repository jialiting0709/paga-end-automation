package com.paga.utils;

import java.text.SimpleDateFormat;
import java.util.Date;


public class PublicFunction {
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

	public static void main(String[] args) {
		System.out.println(getStringDate(432000000L,"yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
		System.out.println(getStringDate(432000000L,"yyyyMMdd"));

	}
	
	

}
