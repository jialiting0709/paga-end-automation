package com.medimpact.paga.end.automation.cases;


import com.medimpact.paga.end.automation.domain.CaseRelevanceData;
import com.medimpact.paga.end.automation.domain.ConfigBeanPropUrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

@SpringBootTest
public class UpdateSubTaskTest extends AbstractTestNGSpringContextTests {
	private static final Logger logger = LoggerFactory.getLogger(UpdateSubTaskTest.class);
	
    @Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
    @Test(dependsOnGroups="addPath", groups="updateSubTask",description = "update SubTask")

    private void updateSubTask() throws IOException, InterruptedException {
    	String url = configBeanPropUrl.getUri()+configBeanPropUrl.getUpdateSub();
    	logger.info("update SubTask url:"+url);
    	HashMap<String,Object> map=new HashMap<String,Object>();
    	map.put("subtaskuuid", new CaseRelevanceData().getSubtaskuuid());
    	map.put("status", 3);
    	String res = CommonCase.updateSubTask(url,map);
        Assert.assertNotNull(res);
        Thread.sleep(2000);

    }
  
}
