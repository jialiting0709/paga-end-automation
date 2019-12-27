package com.paga.util;

import java.text.SimpleDateFormat;

import java.util.Date;

import org.sqlite.date.DateFormatUtils;



/*
 * 封装了公共的方法
 */
public class PublicFunction {
	private final static String xls = "xls";  
	private final static String xlsx = "xlsx"; 
	
	private static Long time = 1L;
	private static String fileName;

	/*
	 * 获取当前时间；格式为yyyy-MM-dd HH:mm:ss
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
        String format = DateFormatUtils.format(date, "yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		return format;
	}

	public static void main(String[] args) {
//		getStringDate(432000000L);
//		getStringDate(864000000L);
		

	}
   		
}
	

