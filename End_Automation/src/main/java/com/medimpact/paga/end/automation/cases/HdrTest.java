package com.medimpact.paga.end.automation.cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
public class HdrTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(HdrTest.class);
	
	@Autowired
//    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="allHdr",groups="getHdr",description="HQ Header查询")
	public void getHdr()throws Exception {
		
		
	}

}
