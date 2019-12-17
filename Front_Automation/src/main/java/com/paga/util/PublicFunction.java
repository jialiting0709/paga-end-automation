package com.paga.util;

import java.text.SimpleDateFormat;

import java.util.Date;



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
   		
}
	

