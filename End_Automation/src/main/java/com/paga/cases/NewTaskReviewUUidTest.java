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
public class NewTaskReviewUUidTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(NewTaskReviewUUidTest.class);
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="approveSubTaskDone", groups="newTaskReviewUUid",description = "new Task uuid")
	public void newTaskReviewUUid() throws Exception { 	
		logger.info("taskFlow task url："+configBeanPropUrl.getNewSubTaskuuid());
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
	     String newReviewtaskuuid = null;
	     ArrayNode arr = (ArrayNode)resJson.path("TaskReview");
	     for(int i=0;i<arr.size();i++){
	    	 int taskId = arr.get(i).path("pk").path("task").path("id").asInt();
	    	 if(taskId==CaseRelevanceData.pkValue){
	    		 newReviewtaskuuid = arr.get(i).path("df").path("uuid").asText();
	    	 }else{
	    		 continue;
	    	 }
	     }
	     CaseRelevanceData.newReviewtaskuuid = newReviewtaskuuid;    
	     return newReviewtaskuuid;

	 }

}
