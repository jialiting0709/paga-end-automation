package com.paga.cases;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.config.CaseRelevanceData;
import com.paga.utils.ConfigBeanPropUrl;
import com.paga.utils.PostGetUtil;

@SpringBootTest
public class ApproveTaskDoneTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(ApproveTaskDoneTest.class);
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="newTaskDoneUUid", groups="approveTaskDone",description = " approve task done")
	public void approveSubTask() throws Exception { 
		logger.info("approve Task review url："+configBeanPropUrl.getApproveTask());
		String result = getResult();
		Assert.assertNotNull(result);
		Thread.sleep(3000);		
	}
	
	private String getResult() throws IOException{
		
		JSONObject jsonObj = new JSONObject();		
		JSONArray commentsArr = new JSONArray();
		JSONObject commentsJson = new JSONObject();
		commentsJson.put("id", "");
		commentsJson.put("tkUuid",CaseRelevanceData.newDonetaskuuid);
		commentsJson.put("message", "2222");
		commentsArr.put(commentsJson);
		
		JSONObject selfPropsJson = new JSONObject();
		selfPropsJson.put("pkType", "guidlineTask");
		selfPropsJson.put("pkValue", CaseRelevanceData.pkValue);
		jsonObj.put("assignee", "");
		jsonObj.put("comments", commentsArr);
		jsonObj.put("defineKey", "TaskDone");
		jsonObj.put("selfProps", selfPropsJson);
		jsonObj.put("uuid",CaseRelevanceData.newDonetaskuuid);
		logger.info(jsonObj.toString());
		
		String returnStr = PostGetUtil.getPosttMethod(configBeanPropUrl.getApproveTask(),jsonObj);	
		return returnStr;
		  
	}

}
