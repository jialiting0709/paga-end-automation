package com.medimpact.paga.front.automation.utils;


import java.text.SimpleDateFormat;
import java.util.Date;



public class DataUtils {

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

//	public static void main(String[] args) {
//		getStringDate(432000000L);
//		System.out.println(getStringDate(432000000L));		
//		System.out.println(getNowDate());	
//	}
   		
}
	

