package com.medimpact.paga.endautomation.cases;


import com.medimpact.paga.endautomation.utils.utils.ConfigBeanPropUrl;
import com.medimpact.paga.endautomation.utils.utils.ReuseCase;
import com.paga.config.CaseRelevanceData;
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
    ConfigBeanPropUrl configBeanPropUrl;
    @Test(dependsOnGroups="addPath", groups="updateSubTask",description = "update SubTask")

    private void updateSubTask() throws IOException, InterruptedException {
    	String url = configBeanPropUrl.getUri()+configBeanPropUrl.getUpdateSub();
    	logger.info("update SubTask url:"+url);
    	HashMap<String,Object> map=new HashMap<String,Object>();
    	map.put("subtaskuuid", CaseRelevanceData.subtaskuuid);
    	map.put("status", 3);
    	String res = ReuseCase.updateSubTask(url,map);
        Assert.assertNotNull(res);
        Thread.sleep(2000);

    }
  
}
