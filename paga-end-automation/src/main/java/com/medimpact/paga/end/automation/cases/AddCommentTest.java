package com.medimpact.paga.end.automation.cases;

import java.io.IOException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.medimpact.paga.end.automation.domain.ConfigBeanPropUrl;
import com.medimpact.paga.end.automation.domain.MemoryData;
import com.medimpact.paga.end.automation.utils.HttpUtils;

@SpringBootTest
public class AddCommentTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(AddCommentTest.class);
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="newSubTaskuuid", groups="addComment",description = "add comment")	
	public void addComment() throws Exception { 	
		logger.info("add comment url："+configBeanPropUrl.getUri()+configBeanPropUrl.getAddComments());
		String result = getResult();		
		Assert.assertNotNull(result);
		Thread.sleep(3000);
	}
	
	 private String getResult() throws IOException{
		 ObjectNode jsonObj = new ObjectMapper().createObjectNode();
		 jsonObj.put("id", "");
		 jsonObj.put("message", "234");	 
		 jsonObj.put("tkUuid",MemoryData.getCaseRelevanceData().getNewReviewSubTaskuuid());
		 String returnStr = HttpUtils.getPosttMethod(configBeanPropUrl.getUri()+configBeanPropUrl.getAddComments(),jsonObj);
		 return returnStr;
	 }

}
