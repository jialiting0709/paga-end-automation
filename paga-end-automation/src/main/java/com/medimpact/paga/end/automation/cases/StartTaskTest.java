package com.medimpact.paga.end.automation.cases;

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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.medimpact.paga.end.automation.domain.CaseRelevanceData;
import com.medimpact.paga.end.automation.domain.ConfigBeanPropUrl;
import com.medimpact.paga.end.automation.utils.DateUtils;
import com.medimpact.paga.end.automation.utils.HttpUtils;

@SpringBootTest
public class StartTaskTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(StartTaskTest.class);
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="addTask", groups="startTask",description = "start a new task in workbench")
	public void startTask() throws Exception { 
		logger.info("start task url："+configBeanPropUrl.getUri()+configBeanPropUrl.getStartTask());
		String result = getResult();
		JsonNode root = new ObjectMapper().readTree(result); 
		new CaseRelevanceData().setTaskuuid(root.path("uuid").asText());
		Assert.assertEquals("TaskNew", root.path("defineKey").asText());
		Thread.sleep(5000);				
//		CaseRelevanceData.taskuuid  = jsonRes.getString("uuid");
//		Assert.assertEquals("TaskNew", jsonRes.getString("defineKey"));
				
	}
	
	 private String getResult() throws IOException{
	     ObjectNode entity = new ObjectMapper().createObjectNode();
	     ObjectNode selfPropsObj = new ObjectMapper().createObjectNode();
	     ArrayNode jsonArr = new ObjectMapper().createArrayNode();
		 selfPropsObj.set("comments", jsonArr);
		 selfPropsObj.put("deadLine",DateUtils.getStringDate(864000000L,"yyyy-MM-dd'T'HH:mm:ss.SSSZ"));//到期时间
		 selfPropsObj.put("owner", "wang");
		 selfPropsObj.put("pkType", "guidlineTask");
		 selfPropsObj.put("pkValue",new CaseRelevanceData().getPkValue());//taskId	
		 entity.set("selfProps",selfPropsObj);
		 		 
		 String returnStr = HttpUtils.getPosttMethod(configBeanPropUrl.getUri()+configBeanPropUrl.getStartTask(), entity);	 		 
		 return returnStr;
	 }
	

}
