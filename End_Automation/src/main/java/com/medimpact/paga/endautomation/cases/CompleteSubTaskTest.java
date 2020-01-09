package com.medimpact.paga.endautomation.cases;


import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.medimpact.paga.endautomation.utils.utils.ConfigBeanPropUrl;
import com.medimpact.paga.endautomation.utils.utils.ReuseCase;
import com.paga.config.CaseRelevanceData;


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
		map.put("subtaskuuid",CaseRelevanceData.subtaskuuid);
		String result = ReuseCase.completeSubTask(url, map);		
		Assert.assertNotNull(result);
		Thread.sleep(3000);
	}
	 	
}
