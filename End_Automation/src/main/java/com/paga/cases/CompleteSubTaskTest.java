package com.paga.cases;


import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.paga.config.CaseRelevanceData;

import com.paga.utils.ConfigBeanPropUrl;

import com.paga.utils.CasePublic;


@SpringBootTest
public class CompleteSubTaskTest extends AbstractTestNGSpringContextTests{
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="updateSubTask", groups="completeSubTask",description = "Complete a SubTask")
	public void completeSubTask() throws Exception { 
		String url = configBeanPropUrl.getCompleteSubTask();
		System.out.println("complete subTask url："+url);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("subtaskuuid",CaseRelevanceData.subtaskuuid);
		String result = CasePublic.completeSubTask(url, map);		
		Assert.assertNotNull(result);
		Thread.sleep(3000);
	}
			
//	 private String getResult() throws IOException{
//		 JSONObject jsonObj = new JSONObject();
//		 JSONObject selfPropsObj = new JSONObject();
//		 selfPropsObj.put("pkType", "guidlineSubTask");
//		 selfPropsObj.put("pkValue",CaseRelevanceData.pkValue);
//		 jsonObj.put("assignee", "wang");
//		 jsonObj.put("dueDate", "");
//		 jsonObj.put("selfProps", selfPropsObj);		 
//		 jsonObj.put("uuid",CaseRelevanceData.subtaskuuid);
//		 System.out.println(jsonObj.toString());
//		 String returnStr = PostGetUtil.getPosttMethod(configBeanPropUrl.getCompleteSubTask(),jsonObj);
//		 JSONObject jsonRest= new JSONObject(returnStr);
//		 String uuid = jsonRest.getString("uuid");	 
//		 return uuid;
//	 }
	 	
}
