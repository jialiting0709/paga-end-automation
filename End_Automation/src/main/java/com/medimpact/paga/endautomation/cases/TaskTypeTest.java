package com.medimpact.paga.endautomation.cases;


import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.medimpact.paga.endautomation.domain.ConfigBeanPropUrl;
import com.medimpact.paga.endautomation.utils.HttpUtils;

@SpringBootTest
public class TaskTypeTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(TaskTypeTest.class);
	
    @Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
    
    @Test(dependsOnGroups="loginTrue",groups="taskType",description="TaskType query")
    public void taskType()throws Exception {
    	logger.info("TaskType url："+configBeanPropUrl.getUri()+configBeanPropUrl.getTaskType());
        String name= HttpUtils.getGetMethod(configBeanPropUrl.getUri()+configBeanPropUrl.getTaskType(), "name");
        Assert.assertEquals(name, "Create");
    }   
	
}
