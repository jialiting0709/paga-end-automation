package com.medimpact.paga.end.automation.cases;


import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.medimpact.paga.end.automation.domain.CaseRelevanceData;
import com.medimpact.paga.end.automation.domain.ConfigBeanPropUrl;

@SpringBootTest
public class CompleteSubTaskTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(CompleteSubTaskTest.class);
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="updateSubTask", groups="completeSubTask",description = "Complete a SubTask")
	public void completeSubTask() throws Exception { 
		String url = configBeanPropUrl.getUri()+configBeanPropUrl.getCompleteSubTask();
		logger.info("complete subTask url："+url);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("subtaskuuid",CaseRelevanceData.getInstance().getSubtaskuuid());
		String result = CommonCase.completeSubTask(url, map);		
		Assert.assertNotNull(result);
		Thread.sleep(3000);
	}
	 	
}
