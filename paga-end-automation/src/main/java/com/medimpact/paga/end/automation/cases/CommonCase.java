package com.medimpact.paga.end.automation.cases;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashMap;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.medimpact.paga.end.automation.domain.CaseRelevanceData;
import com.medimpact.paga.end.automation.domain.UserInfo;
import com.medimpact.paga.end.automation.utils.HttpUtils;
public class CommonCase {
	private static final Logger logger = LoggerFactory.getLogger(CommonCase.class);
	
	public static String updateSubTask(String url,HashMap<String,Object> map) throws InterruptedException, IOException{
		ObjectNode jsonObject = new ObjectMapper().createObjectNode();
	        jsonObject.put("enteredBy","wang");
	        jsonObject.put("glName","qqq");
	        jsonObject.put("glType",1);
	        jsonObject.put("id",1);
	        jsonObject.put("name","");
	        
	        jsonObject.put("status",Integer.parseInt(map.get("status").toString()));
	        jsonObject.put("tkId",new CaseRelevanceData().getPkValue());
	        jsonObject.put("uniqueKeyInFlow",String.valueOf(map.get("subtaskuuid")));
	        String result = HttpUtils.getPosttMethod(url,jsonObject);
		    return result;

	}
	
	public static String completeSubTask(String url,java.util.HashMap<String, Object> map) throws InterruptedException, IOException{
		 ObjectMapper mapper= new ObjectMapper();
		 ObjectNode jsonObj = mapper.createObjectNode();
		 ObjectNode selfPropsObj = mapper.createObjectNode();
		 selfPropsObj.put("pkType", "guidlineSubTask");
		 selfPropsObj.put("pkValue",new CaseRelevanceData().getPkValue());
		 jsonObj.put("assignee", "wang");
		 jsonObj.put("dueDate", "");
		 jsonObj.set("selfProps", selfPropsObj);		 
		 jsonObj.put("uuid",String.valueOf(map.get("subtaskuuid")));
		 String returnStr = HttpUtils.getPosttMethod(url,jsonObj);
		 
		 JsonNode jsonRest = mapper.readTree(returnStr); 
		 String uuid = jsonRest.path("uuid").asText();
		 return uuid;

	}
	
	public static String getNewSubandTaskuuid(String url,HashMap<String, Object> map) throws InterruptedException, IOException{		
		 HttpGet get = new HttpGet(url);
		 get.addHeader("username", new UserInfo().getUsername());		 
		 HttpResponse response = new UserInfo().getDefaultHttpClient().execute(get);
	     String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");

	     logger.info("Interface response results："+jsonStr);
	     JsonNode resObj = new ObjectMapper().readTree(jsonStr); 
	     String subtaskuuid = null;
	     ArrayNode arr = (ArrayNode)resObj.path(String.valueOf(map.get("key")));
	     for(int i=0;i<arr.size();i++){
	    	 int subTaskId = arr.get(i).path(String.valueOf(map.get("pk"))).path(String.valueOf(map.get("subTask"))).path(String.valueOf(map.get("id"))).asInt();
	    	 if(subTaskId==Integer.parseInt(map.get("subtaskid").toString())){
	    		 subtaskuuid = arr.get(i).path(String.valueOf(map.get("df"))).path(String.valueOf(map.get("uuid"))).asText();
	    	 }else{
	    		 continue;
	    	 }
	     } 
	     new CaseRelevanceData().setNewReviewSubTaskuuid(subtaskuuid);
	     return subtaskuuid;

	 }	

}
