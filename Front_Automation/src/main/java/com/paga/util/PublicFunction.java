package com.paga.util;


import java.text.SimpleDateFormat;
import java.util.Date;



public class PublicFunction {
	private final static String xls = "xls";  
	private final static String xlsx = "xlsx"; 
	
	private static Long time = 1L;
	private static String fileName;

	/*
	 * Get current time；yyyy-MM-dd HH:mm:ss
	 */
	public static String getNowDate() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateNowStr = sdf.format(d);
		return dateNowStr;
	}
	
	public static String getStringDate(Long Millisecond){
		long totalMilliSeconds = System.currentTimeMillis()+Millisecond;
        Date date = new Date();
        date.setTime(totalMilliSeconds);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String str = df.format(date);
		return str;
	}

	public static void main(String[] args) {
		getStringDate(432000000L);
		System.out.println(getStringDate(432000000L));		
		System.out.println(getNowDate());	
	}
   		
}
	

