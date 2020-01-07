package com.paga.cases;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.paga.config.CaseRelevanceData;
import com.paga.config.TestConfig;
import com.paga.utils.ConfigBeanPropUrl;


@SpringBootTest
public class NewTaskDoneUUidTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(NewTaskDoneUUidTest.class);
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="approveTaskReview", groups="newTaskDoneUUid",description = "task Done new uuid")
	public void newTaskDoneUUid() throws Exception { 
		logger.info("approve Task review url："+configBeanPropUrl.getApproveTask());
		String result = getResult();
		Assert.assertNotNull(result);
		Thread.sleep(3000);
		
	}
	
	private String getResult() throws IOException{		 
		 HttpGet get = new HttpGet(configBeanPropUrl.getNewSubTaskuuid());
		 get.addHeader("username", TestConfig.username);		 
		 HttpResponse response = TestConfig.defaultHttpClient.execute(get);
	     String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");

	     logger.info("Interface response results："+jsonStr);
	     JsonNode resJson = new ObjectMapper().readTree(jsonStr); 
	     String newDonetaskuuid = null;
	     ArrayNode arr = (ArrayNode)resJson.path("TaskDone");
	     for(int i=0;i<arr.size();i++){
	    	 int taskId = arr.get(i).path("pk").path("task").path("id").asInt();
	    	 if(taskId==CaseRelevanceData.pkValue){
	    		 newDonetaskuuid = arr.get(i).path("df").path("uuid").asText();
	    	 }else{
	    		 continue;
	    	 }
	     }
	     CaseRelevanceData.newDonetaskuuid = newDonetaskuuid;     
	     return newDonetaskuuid;

	 }
	

}
