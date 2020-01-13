package com.medimpact.paga.end.automation.cases;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.medimpact.paga.end.automation.domain.CaseRelevanceData;
import com.medimpact.paga.end.automation.domain.ConfigBeanPropUrl;
import com.medimpact.paga.end.automation.utils.HttpUtils;

@SpringBootTest
public class ApproveSubTaskDoneTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(ApproveSubTaskDoneTest.class);
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="RulePath", groups="approveSubTaskDone",description = "approve subTask done")
	public void approveSubTask() throws Exception { 
		logger.info("approve subTask done url："+configBeanPropUrl.getUri()+configBeanPropUrl.getApproveSubTask());
		String result = getResult();
		Assert.assertNotNull(result);
		Thread.sleep(3000);
		
	}
	
	private String getResult() throws IOException{
		ObjectMapper mapper= new ObjectMapper();
		ObjectNode jsonObj = mapper.createObjectNode();
		ArrayNode commentsArr = mapper.createArrayNode();
		ObjectNode commentsJson = mapper.createObjectNode();
		commentsJson.put("id", "");
		commentsJson.put("tkUuid",CaseRelevanceData.getInstance().getTaskuuid());
		commentsJson.put("message", "2222");
		commentsArr.add(commentsJson);
		
		ObjectNode selfPropsJson = mapper.createObjectNode();
		selfPropsJson.put("pkType", "guidlineSubTask");
		selfPropsJson.put("pkValue", CaseRelevanceData.getInstance().getPkValue());
		jsonObj.put("assignee", "");
		jsonObj.set("comments", commentsArr);
		jsonObj.put("defineKey", "SubtaskDone");
		jsonObj.set("selfProps", selfPropsJson);
		jsonObj.put("uuid",CaseRelevanceData.getInstance().getNewSubTaskDeployedUuid());
		
		String returnStr = HttpUtils.getPosttMethod(configBeanPropUrl.getUri()+configBeanPropUrl.getApproveSubTask(),jsonObj);	
		return returnStr;
		  
	}
	
}
