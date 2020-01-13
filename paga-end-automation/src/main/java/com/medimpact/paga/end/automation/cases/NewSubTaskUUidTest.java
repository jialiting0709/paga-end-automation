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
public class NewSubTaskUUidTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(NewSubTaskUUidTest.class);
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	@Test(dependsOnGroups="completeSubTask", groups="newSubTaskuuid",description = "new SubTask uuid")	
	public void newSubTaskuuid() throws Exception {  
		String url = configBeanPropUrl.getUri()+configBeanPropUrl.getNewSubTaskuuid();
		logger.info("taskFlow task url："+url);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("key", "SubtaskReview");
		map.put("pk", "pk");
		map.put("subTask", "subTask");
		map.put("id", "id");
		map.put("subtaskid",CaseRelevanceData.getInstance().getSubtaskid());
		map.put("df", "df");
		map.put("uuid", "uuid");
		String result = CommonCase.getNewSubandTaskuuid(url, map);		
		Assert.assertNotNull(result);
		Thread.sleep(3000);
	}
	
}
