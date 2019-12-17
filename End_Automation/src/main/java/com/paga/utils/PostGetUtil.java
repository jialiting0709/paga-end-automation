package com.paga.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;

import com.paga.config.TestConfig;

public class PostGetUtil {
	
	  public static List<String> getGetMethod(String url,String key) throws IOException {
	    	
	    	HttpGet get = new HttpGet(url);
	    	get.addHeader("token",TestConfig.jwtToken);
	    	HttpResponse response = TestConfig.defaultHttpClient.execute(get);
	    	String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
	    	System.out.println("接口的响应结果："+jsonStr);
	    	JSONArray jsonArray = new JSONArray(jsonStr);
	    	List<String> list = new ArrayList<String>();
	    	for(int i=0;i<jsonArray.length();i++){
	    		String name = jsonArray.getJSONObject(i).getString(key);
	    		list.add(name);   		
	    	}
	    	return list;   	
	    }
	    

}
