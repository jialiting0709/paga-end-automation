package com.medimpact.paga.endautomation.cases;

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
import com.medimpact.paga.endautomation.domain.CaseRelevanceData;
import com.medimpact.paga.endautomation.domain.ConfigBeanPropUrl;
import com.medimpact.paga.endautomation.domain.UserInfo;


@SpringBootTest
public class SubtasktkIdTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(SubtasktkIdTest.class);
	
    @Autowired
    ConfigBeanPropUrl configBeanPropUrl;

    @Test(dependsOnGroups="startSubtask", groups="subtasktkId",description = "subtask tkId")
	private void subtasktkId() throws IOException, InterruptedException {
		int result = getResult();
		Assert.assertNotNull(result);
		Thread.sleep(3000);
		
	}
	  private int getResult() throws IOException {
	        
	        String url = configBeanPropUrl.getUri()+configBeanPropUrl.getSubtasktkId()+"/"+CaseRelevanceData.pkValue;
	        HttpGet get = new HttpGet(url);	        
	        logger.info("subtask tkId url: "+url);
	        get.addHeader("username", UserInfo.username);
	        
//	        get.addHeader("access_token",TestConfig.access_token);
//	        get.addHeader("refresh_token",TestConfig.refresh_token);
//	        get.addHeader("token_type",TestConfig.token_type);
//	        get.addHeader("refreshToken_lifeSpan",TestConfig.refreshToken_lifeSpan);
//	        get.addHeader("jti",TestConfig.jti);
	        
	        HttpResponse response = UserInfo.defaultHttpClient.execute(get);
	        String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
	        logger.info("Interface response results："+jsonStr);
	        JsonNode jsonRest = new ObjectMapper().readTree(jsonStr); 
	        int subTaskId = jsonRest.path("subTask").path("id").asInt();
	        CaseRelevanceData.subtaskid = subTaskId;
	        return subTaskId;

	    }	

}
