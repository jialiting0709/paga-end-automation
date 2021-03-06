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
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.medimpact.paga.end.automation.domain.ConfigBeanPropUrl;
import com.medimpact.paga.end.automation.domain.MemoryData;
import com.medimpact.paga.end.automation.utils.HttpUtils;

@SpringBootTest
public class TaskMgrSubtaskUpdateTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(TaskMgrSubtaskUpdateTest.class);
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="", groups="taskMgrSubtaskUpdate",description = "TaskMgr Subtask Update")
	public void taskMgrSubtaskUpdate() throws Exception {
		logger.info("TaskMgr Subtask Update url："+configBeanPropUrl.getUri()+configBeanPropUrl.getUpdateSub());
		String result = getResult();		
		Assert.assertNotNull(result);						
	}
	
	 private String getResult() throws IOException{
		ObjectNode jsonObj = new ObjectMapper().createObjectNode();
		jsonObj.put("enteredBy", "wang");
		jsonObj.put("glName", "111");
		jsonObj.put("glType", 123);
		jsonObj.put("id",MemoryData.getCaseRelevanceData().getPkValue());
		jsonObj.put("name", "0");
		jsonObj.put("status", 2);
		jsonObj.put("tkId", MemoryData.getCaseRelevanceData().getPkValue());
		jsonObj.put("uniqueKeyInFlow",MemoryData.getCaseRelevanceData().getTaskuuid());
		String returnStr = HttpUtils.getPosttMethod(configBeanPropUrl.getUri()+configBeanPropUrl.getCompleteSubTask(),jsonObj);
		return returnStr;
	 }
	
}
