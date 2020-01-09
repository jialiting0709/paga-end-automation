package com.medimpact.paga.end.automation.cases;

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
import com.medimpact.paga.end.automation.domain.CaseRelevanceData;
import com.medimpact.paga.end.automation.domain.ConfigBeanPropUrl;
import com.medimpact.paga.end.automation.domain.UserInfo;

@SpringBootTest
public class NewSubTaskDeployedUUidTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(NewSubTaskDeployedUUidTest.class);

	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="approveSubTask", groups="newSubTaskDeployedUuid",description = "new SubTask uuid")	
	public void newSubTaskDeployedUuid() throws Exception { 	
		logger.info("taskFlow task url："+configBeanPropUrl.getUri()+configBeanPropUrl.getNewSubTaskuuid());
		String result = getResult();		
		Assert.assertNotNull(result);
		Thread.sleep(3000);
	}
	
	 private String getResult() throws IOException{
		 
		 HttpGet get = new HttpGet(configBeanPropUrl.getUri()+configBeanPropUrl.getNewSubTaskuuid());
		 get.addHeader("username", new UserInfo().getUsername());		 
		 HttpResponse response =new UserInfo().getDefaultHttpClient().execute(get);
	     String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");

	     logger.info("Interface response results："+jsonStr);

	     JsonNode resJson = new ObjectMapper().readTree(jsonStr); 
	     String newSubTaskDeployedUuid = null;
	     ArrayNode arr = (ArrayNode)resJson.path("SubtaskDone");
	     for(int i=0;i<arr.size();i++){
	    	 int subTaskId = arr.get(i).path("pk").path("subTask").path("id").asInt();
	    	 if(subTaskId==new CaseRelevanceData().getSubtaskid()){
	    		 newSubTaskDeployedUuid = arr.get(i).path("df").path("uuid").asText();
	    	 }else{
	    		 continue;
	    	 }
	     }
	     new CaseRelevanceData().setNewSubTaskDeployedUuid(newSubTaskDeployedUuid);
	     return newSubTaskDeployedUuid;

	 }
}