package com.paga.cases;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.config.CaseRelevanceData;
import com.paga.config.TestConfig;
import com.paga.utils.ConfigBeanPropUrl;
import com.paga.utils.GetDateUtil;

@SpringBootTest
public class StartSubtaskTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(StartSubtaskTest.class);
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="startTask", groups="startSubtask",description = "Assign the user to a subTask")
	public void startTask() throws Exception { 
		logger.info("start subtask url："+configBeanPropUrl.getStartSubtask());
		String result = getResult();
		Assert.assertNotNull(result);
		Thread.sleep(3000);
		
	}
	
	private String getResult() throws IOException, InterruptedException{
		Thread.sleep(3000);
		HttpPost post = new HttpPost(configBeanPropUrl.getStartSubtask());
		post.addHeader("username",TestConfig.username);
//	    post.addHeader("access_token",TestConfig.access_token);
//	    post.addHeader("refresh_token",TestConfig.refresh_token);
//	    post.addHeader("token_type",TestConfig.token_type);
//	    post.addHeader("refreshToken_lifeSpan",TestConfig.refreshToken_lifeSpan);
//	    post.addHeader("jti",TestConfig.jti);
	    post.setHeader("Content-Type","application/json");
	    	    	    
		JSONArray jsA  = new JSONArray();		
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("assignee", "wang");
		jsonObj.put("dueDate", GetDateUtil.getStringDate(432000000L,"yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
		
		JSONObject jsonSelfProps= new JSONObject();
		JSONArray jsAComments  = new JSONArray();
		jsonSelfProps.put("comments",jsAComments);	
		jsonSelfProps.put("pkType","guidlineSubTask");		
		jsonSelfProps.put("pkValue",CaseRelevanceData.pkValue);
		jsonObj.put("selfProps",jsonSelfProps);
		jsA.put(jsonObj);
		
		StringEntity entity = new StringEntity(jsA.toString(),"utf-8");
		post.setEntity(entity);
		HttpResponse response = TestConfig.defaultHttpClient.execute(post);
		String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
		logger.info("Interface response results："+jsonStr);
	    JSONArray REsA = new JSONArray(jsonStr);	    
	    JSONObject jsonRest= REsA.getJSONObject(0);
	    CaseRelevanceData.subtaskuuid = jsonRest.getString("uuid");
	    return jsonRest.getString("defineKey");	
		
	}
}
