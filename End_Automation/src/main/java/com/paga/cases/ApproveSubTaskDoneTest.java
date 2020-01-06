package com.paga.cases;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.config.CaseRelevanceData;
import com.paga.utils.ConfigBeanPropUrl;
import com.paga.utils.PostGetUtil;

@SpringBootTest
public class ApproveSubTaskDoneTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(ApproveSubTaskDoneTest.class);
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="RulePath", groups="approveSubTaskDone",description = "approve subTask done")
	public void approveSubTask() throws Exception { 
		logger.info("approve subTask done url："+configBeanPropUrl.getApproveSubTask());
		String result = getResult();
		Assert.assertNotNull(result);
		Thread.sleep(3000);
		
	}
	
	private String getResult() throws IOException{
		JSONObject jsonObj = new JSONObject();		
		JSONArray commentsArr = new JSONArray();
		JSONObject commentsJson = new JSONObject();
		commentsJson.put("id", "");//
		commentsJson.put("tkUuid",CaseRelevanceData.taskuuid);
		commentsJson.put("message", "2222");
		commentsArr.put(commentsJson);
		
		JSONObject selfPropsJson = new JSONObject();
		selfPropsJson.put("pkType", "guidlineSubTask");
		selfPropsJson.put("pkValue", CaseRelevanceData.pkValue);
		jsonObj.put("assignee", "");
		jsonObj.put("comments", commentsArr);
		jsonObj.put("defineKey", "SubtaskDone");
		jsonObj.put("selfProps", selfPropsJson);
		jsonObj.put("uuid",CaseRelevanceData.newSubTaskDeployedUuid);
		logger.info(jsonObj.toString());
		
		String returnStr = PostGetUtil.getPosttMethod(configBeanPropUrl.getApproveSubTask(),jsonObj);	
		return returnStr;
		  
	}
	
}
