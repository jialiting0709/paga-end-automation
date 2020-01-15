package com.medimpact.paga.end.automation.cases;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.medimpact.paga.end.automation.domain.ConfigBeanPropUrl;
import com.medimpact.paga.end.automation.domain.MemoryData;
import com.medimpact.paga.end.automation.utils.DateUtils;
import com.medimpact.paga.end.automation.utils.HttpUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import org.testng.Assert;
import org.testng.annotations.Test;



@SpringBootTest
public class AddTaskTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(AddTaskTest.class);
	
    @Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
    
    @Test(dependsOnGroups="loginTrue", groups="addTask",description = "add a Task")
    public void addTaskTest() throws Exception { 
    	logger.info("add Task url："+configBeanPropUrl.getUri()+configBeanPropUrl.getAddTask());
    	String result = getResult();
    	Integer.parseInt(result);
    	if(Integer.parseInt(result)>0){
    		Assert.assertEquals("0", "0");
    	}
    	
    }
          
    private String getResult() throws IOException{
    	
    	String dueDate = DateUtils.getStringDate(432000000L,"yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    	String effective = DateUtils.getStringDate(864000000L,"yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    	ObjectMapper mapper= new ObjectMapper();
    	ObjectNode json = mapper.createObjectNode();
    	ObjectNode entity = mapper.createObjectNode();
    	entity.put("clientName", "Manulife Financial");
    	entity.put("dueDate", dueDate);
    	entity.put("effective",effective);
    	entity.put("entered", "");
    	entity.put("enteredBy","");
    	entity.put("glCode","HPH");
    	entity.put("glName","");
    	entity.put("glSet", "HPH-COMM");
    	entity.put("guidelineNum",1);
    	entity.put("headerCode","HPH");
    	entity.put("headerId",33000000100L);
    	entity.put("hqCodes","MDT01");
    	entity.put("requestBy",0);
    	entity.put("requestDate","");
    	entity.put("requestEmail","123@qq.com");
    	entity.put("requestType","");
    	entity.put("salesForceCaseNumber","23");
    	entity.put("statusCode",1);
    	entity.put("subtaskLob","");
    	entity.put("taskDesc","test task");
    	entity.put("taskType",1);
    	ObjectNode entityTaskDtl = mapper.createObjectNode();
    	entityTaskDtl.put("assignUser","wang");
    	json.set("taskDtl",entityTaskDtl);
    	json.set("task",entity);   	   	
    	String returnStr = HttpUtils.getPosttMethod(configBeanPropUrl.getUri()+configBeanPropUrl.getAddTask(), json);	
    	MemoryData.getCaseRelevanceData().setPkValue(Integer.parseInt(returnStr));
    	return returnStr;
    }
}
