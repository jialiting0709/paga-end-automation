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
import com.medimpact.paga.end.automation.utils.ReuseCase;


@SpringBootTest
public class CompleteSubTaskReJTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(CompleteSubTaskReJTest.class);
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="UpdateSubTaskReJ", groups="CompleteSubTaskReJ",description = "Complete a SubTaskrej")
	public void completeSubTaskREj() throws Exception { 	
		String url = configBeanPropUrl.getUri()+configBeanPropUrl.getCompleteSubTask();
		logger.info("complete subTask url："+url);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("subtaskuuid",new CaseRelevanceData().getSubtaskRejuuid());
		String result = ReuseCase.completeSubTask(url, map);		
		Assert.assertNotNull(result);
		Thread.sleep(3000);
	}
			
}
