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
public class RequestBYTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(RequestBYTest.class);
	
    @Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
    
    @Test(dependsOnGroups="taskType",groups="allHdr",description ="query HQ Header")
    public void allHdr() throws Exception {
    	logger.info("HQ Header url："+configBeanPropUrl.getUri()+configBeanPropUrl.getAllHdr());
        String name = PostGetUtil.getGetMethod(configBeanPropUrl.getUri()+configBeanPropUrl.getAllHdr(),"name");
        Assert.assertEquals(name, "N/A");
    }
    

}
