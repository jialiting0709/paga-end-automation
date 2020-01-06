package com.paga.cases;


import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.paga.utils.ConfigBeanPropUrl;
import com.paga.utils.PostGetUtil;

@SpringBootTest
public class TaskTypeTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(TaskTypeTest.class);
	
    @Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
    
    @Test(dependsOnGroups="loginTrue",groups="taskType",description="TaskType query")
    public void taskType()throws Exception {
    	logger.info("TaskType url："+configBeanPropUrl.getTaskType());
        String name= PostGetUtil.getGetMethod(configBeanPropUrl.getTaskType(), "name");
        Assert.assertEquals(name, "Create");
    }   
	
}
