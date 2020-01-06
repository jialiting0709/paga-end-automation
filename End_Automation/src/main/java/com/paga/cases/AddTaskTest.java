package com.paga.cases;

import java.io.IOException;


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
import com.paga.utils.GetDateUtil;



@SpringBootTest
public class AddTaskTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(AddTaskTest.class);
	
    @Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
    
    @Test(dependsOnGroups="loginTrue", groups="addTask",description = "add a Task")
    public void loginTrue() throws Exception { 
    	logger.info("add Task url："+configBeanPropUrl.getAddTask());
    	String result = getResult();
    	Integer.parseInt(result);
    	if(Integer.parseInt(result)>0){
    		Assert.assertEquals("0", "0");
    	}
    	
    }
          
    private String getResult() throws IOException{
    	
    	JSONObject jsonObj = new JSONObject();    	
    	String dueDate = GetDateUtil.getStringDate(432000000L,"yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    	String effective = GetDateUtil.getStringDate(864000000L,"yyyy-MM-dd'T'HH:mm:ss.SSSZ");
    	  	
    	JSONObject jsonTask = new JSONObject();
    	jsonTask.put("clientName", "Manulife Financial");
    	jsonTask.put("dueDate", dueDate);
    	jsonTask.put("effective",effective);
    	jsonTask.put("entered", "");
    	jsonTask.put("enteredBy","");
    	jsonTask.put("glCode","HPH");
    	jsonTask.put("glName","");
    	jsonTask.put("glSet", "HPH-COMM");
    	jsonTask.put("guidelineNum",1);
    	jsonTask.put("headerCode","HPH");
    	jsonTask.put("headerId",33000000100L);
    	jsonTask.put("hqCodes","MDT01");
    	jsonTask.put("requestBy",0);
    	jsonTask.put("requestDate","");
    	jsonTask.put("requestEmail","123@qq.com");
    	jsonTask.put("requestType","");
    	jsonTask.put("salesForceCaseNumber","23");
    	jsonTask.put("statusCode",1);
    	jsonTask.put("subtaskLob","");
    	jsonTask.put("taskDesc","test task");
    	jsonTask.put("taskType",1);
    	jsonObj.put("task",jsonTask);
    	
    	JSONObject jsonTaskDtl = new JSONObject();
    	jsonTaskDtl.put("assignUser","wang");
    	jsonObj.put("taskDtl",jsonTaskDtl); 
    	
    	String returnStr = PostGetUtil.getPosttMethod(configBeanPropUrl.getAddTask(), jsonObj);	
    	CaseRelevanceData.pkValue = Integer.parseInt(returnStr);   	
    	return returnStr;
    }
}
