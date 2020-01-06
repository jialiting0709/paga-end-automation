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
import com.paga.utils.GetDateUtil;

@SpringBootTest
public class StartTaskTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(StartTaskTest.class);
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="addTask", groups="startTask",description = "start a new task in workbench")
	public void startTask() throws Exception { 
		logger.info("start task url："+configBeanPropUrl.getStartTask());
		String result = getResult();
		JSONObject jsonRes = new JSONObject(result);
		CaseRelevanceData.taskuuid  = jsonRes.getString("uuid");
		Assert.assertEquals("TaskNew", jsonRes.getString("defineKey"));
		Thread.sleep(5000);
				
	}
	
	 private String getResult() throws IOException{
		 JSONObject jsonObj = new JSONObject();
		 JSONObject selfPropsObj = new JSONObject();
		 JSONArray jsonArr = new JSONArray();
		 selfPropsObj.put("comments", jsonArr);
		 selfPropsObj.put("deadLine",GetDateUtil.getStringDate(864000000L,"yyyy-MM-dd'T'HH:mm:ss.SSSZ"));//到期时间
		 selfPropsObj.put("owner", "wang");
		 selfPropsObj.put("pkType", "guidlineTask");
		 selfPropsObj.put("pkValue", CaseRelevanceData.pkValue);//taskId	
		 jsonObj.put("selfProps",selfPropsObj);
		 		 
		 String returnStr = PostGetUtil.getPosttMethod(configBeanPropUrl.getStartTask(), jsonObj);	 		 
		 return returnStr;
	 }
	

}
