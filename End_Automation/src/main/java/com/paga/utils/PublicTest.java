package com.paga.utils;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;


import com.paga.config.CaseRelevanceData;
import com.paga.config.TestConfig;

public class PublicTest {	
	public static String updateSubTask(String url,HashMap<String,Object> map) throws InterruptedException, IOException{
		 JSONObject jsonObject = new JSONObject();
	        jsonObject.put("enteredBy","wang");
	        jsonObject.put("glName","qqq");
	        jsonObject.put("glType",1);
	        jsonObject.put("id",1);
	        jsonObject.put("name","");
	        
	        jsonObject.put("status",Integer.parseInt(map.get("status").toString()));
	        jsonObject.put("tkId",CaseRelevanceData.pkValue);
	        jsonObject.put("uniqueKeyInFlow",String.valueOf(map.get("subtaskuuid")));
	        System.out.println(jsonObject.toString());
	        String result = PostGetUtil.getPosttMethod(url,jsonObject);
		    return result;

	}
	
	public static String completeSubTask(String url,java.util.HashMap<String, Object> map) throws InterruptedException, IOException{
		 JSONObject jsonObj = new JSONObject();
		 JSONObject selfPropsObj = new JSONObject();
		 selfPropsObj.put("pkType", "guidlineSubTask");
		 selfPropsObj.put("pkValue",CaseRelevanceData.pkValue);
		 jsonObj.put("assignee", "wang");
		 jsonObj.put("dueDate", "");
		 jsonObj.put("selfProps", selfPropsObj);		 
		 jsonObj.put("uuid",String.valueOf(map.get("subtaskuuid")));
		 System.out.println(jsonObj.toString());
		 String returnStr = PostGetUtil.getPosttMethod(url,jsonObj);
		 JSONObject jsonRest= new JSONObject(returnStr);
		 String uuid = jsonRest.getString("uuid");	 
		 return uuid;

	}
	
	public static String getNewSubandTaskuuid(String url,HashMap<String, Object> map) throws InterruptedException, IOException{		
		 HttpGet get = new HttpGet(url);
		 get.addHeader("username", TestConfig.username);		 
		 HttpResponse response = TestConfig.defaultHttpClient.execute(get);
	     String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");

	     System.out.println("Interface response results："+jsonStr);
	     System.out.println("subtaskid==========="+CaseRelevanceData.subtaskid);
	     JSONObject resObj = new JSONObject(jsonStr);
	     String subtaskuuid = null;
	     JSONArray arr = resObj.getJSONArray(String.valueOf(map.get("key")));	     
	     for(int i=0;i<arr.length();i++){
	    	 int subTaskId = arr.getJSONObject(i).getJSONObject(String.valueOf(map.get("pk"))).getJSONObject(String.valueOf(map.get("subTask"))).getInt(String.valueOf(map.get("id")));
	    	 if(subTaskId==Integer.parseInt(map.get("subtaskid").toString())){
	    		 subtaskuuid = arr.getJSONObject(i).getJSONObject(String.valueOf(map.get("df"))).getString(String.valueOf(map.get("uuid")));
	    	 }else{
	    		 continue;
	    	 }
	     }
	     CaseRelevanceData.newReviewSubTaskuuid = subtaskuuid;
	     System.out.println("subtaskuuid："+subtaskuuid);	     
	     return subtaskuuid;

	 }
	
	public static void main(String[] args) {
		HashMap<String,Object> map = new HashMap<String,Object>();
	    map.put("subtaskuuid","2323324");
	    map.put("status", 1);
		int i =Integer.parseInt(map.get("status").toString());
		String j = String.valueOf(map.get("subtaskuuid"));
		System.out.println(i);
		System.out.println(j);
	}
	
	
	

}
