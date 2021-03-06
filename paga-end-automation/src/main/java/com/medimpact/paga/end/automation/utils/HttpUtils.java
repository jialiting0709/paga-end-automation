package com.medimpact.paga.end.automation.utils;

import java.io.IOException;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.medimpact.paga.end.automation.domain.MemoryData;
import com.medimpact.paga.end.automation.domain.UserInfo;

public class HttpUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(HttpUtils.class);
	
	  public static String getGetMethod(String url,String key) throws IOException {	    	
	    	HttpGet get = new HttpGet(url);
	    	get.addHeader("username",MemoryData.getUserInfo().getUsername());
//	    	get.addHeader("access_token",TestConfig.access_token);
//	    	get.addHeader("refresh_token",TestConfig.refresh_token);
//	    	get.addHeader("token_type",TestConfig.token_type);
//	    	get.addHeader("refreshToken_lifeSpan",TestConfig.refreshToken_lifeSpan);
//	    	get.addHeader("jti",TestConfig.jti);
	    	
	    	HttpResponse response = MemoryData.getCaseRelevanceData().getDefaultHttpClient().execute(get);
	    	
	    	String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
	    	logger.info("Interface response results："+jsonStr);
	    	JsonNode arrayNode= new ObjectMapper().readTree(jsonStr);
	    	String name = null;
	    	if(arrayNode.isArray()){
	    		name = arrayNode.get(0).asText(key);
	    	}
	    	return name;
	    }
	  
	  public static String getPosttMethod(String url,ObjectNode param) throws IOException {
		  HttpPost post = new HttpPost(url);
		  post.addHeader("username",MemoryData.getUserInfo().getUsername());
//	      post.addHeader("access_token",TestConfig.access_token);
//	      post.addHeader("refresh_token",TestConfig.refresh_token);
//	      post.addHeader("token_type",TestConfig.token_type);
//	      post.addHeader("refreshToken_lifeSpan",TestConfig.refreshToken_lifeSpan);
//	      post.addHeader("jti",TestConfig.jti);
	      post.setHeader("Content-Type","application/json");
	      StringEntity entity = new StringEntity(param.toString(),"utf-8");
	      logger.info("Parameter value："+param.toString());
	      post.setEntity(entity);
	      HttpResponse response = MemoryData.getCaseRelevanceData().getDefaultHttpClient().execute(post);
	      String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
	      logger.info("Interface response results："+jsonStr);
		  return jsonStr;
		 
	  }    

}
