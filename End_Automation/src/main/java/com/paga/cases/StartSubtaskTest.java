package com.paga.cases;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
		logger.info("start subtask url："+configBeanPropUrl.getUri()+configBeanPropUrl.getStartSubtask());
		String result = getResult();
		Assert.assertNotNull(result);
		Thread.sleep(3000);
		
	}
	
	private String getResult() throws IOException, InterruptedException{
		Thread.sleep(3000);
		HttpPost post = new HttpPost(configBeanPropUrl.getUri()+configBeanPropUrl.getStartSubtask());
		post.addHeader("username",TestConfig.username);
//	    post.addHeader("access_token",TestConfig.access_token);
//	    post.addHeader("refresh_token",TestConfig.refresh_token);
//	    post.addHeader("token_type",TestConfig.token_type);
//	    post.addHeader("refreshToken_lifeSpan",TestConfig.refreshToken_lifeSpan);
//	    post.addHeader("jti",TestConfig.jti);
	    post.setHeader("Content-Type","application/json");
	    
	    ObjectMapper mapper= new ObjectMapper();
	    ArrayNode jsA  = mapper.createArrayNode();		
	    ObjectNode jsonObj = mapper.createObjectNode();
		jsonObj.put("assignee", "wang");
		jsonObj.put("dueDate", GetDateUtil.getStringDate(432000000L,"yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
		
		ObjectNode jsonSelfProps= mapper.createObjectNode();
		ArrayNode jsAComments  = mapper.createArrayNode();
		jsonSelfProps.set("comments",jsAComments);	
		jsonSelfProps.put("pkType","guidlineSubTask");		
		jsonSelfProps.put("pkValue",CaseRelevanceData.pkValue);
		jsonObj.set("selfProps",jsonSelfProps);
		jsA.add(jsonObj);
		
		StringEntity entity = new StringEntity(jsA.toString(),"utf-8");
		post.setEntity(entity);
		logger.info("Parameter value："+jsA.toString());
		HttpResponse response = TestConfig.defaultHttpClient.execute(post);
		String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
		logger.info("Interface response results："+jsonStr);
		JsonNode arrayNode= new ObjectMapper().readTree(jsonStr);
		String defineKey = null;
		if(arrayNode.isArray()){
			CaseRelevanceData.subtaskuuid = arrayNode.get(0).path("uuid").asText();
			defineKey = arrayNode.get(0).path("defineKey").asText();
		}
//	    JSONArray REsA = new JSONArray(jsonStr);	    
//	    JSONObject jsonRest= REsA.getJSONObject(0);
//	    CaseRelevanceData.subtaskuuid = jsonRest.getString("uuid");
//	    return jsonRest.getString("defineKey");	
		return defineKey;
		
	}
}
