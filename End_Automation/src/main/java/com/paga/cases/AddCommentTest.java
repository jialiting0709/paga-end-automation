package com.paga.cases;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.config.CaseRelevanceData;
import com.paga.utils.ConfigBeanPropUrl;
import com.paga.utils.PostGetUtil;

@SpringBootTest
public class AddCommentTest extends AbstractTestNGSpringContextTests{
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="newSubTaskuuid", groups="addComment",description = "add comment")	
	public void addComment() throws Exception { 	
		System.out.println("add comment url："+configBeanPropUrl.getAddComments());
		String result = getResult();		
		Assert.assertNotNull(result);
		Thread.sleep(3000);
	}
	
	 private String getResult() throws IOException{
		 JSONObject jsonObj = new JSONObject();
		 jsonObj.put("id", "");
		 jsonObj.put("message", "234");	 
		 jsonObj.put("tkUuid",CaseRelevanceData.newReviewSubTaskuuid);
		 System.out.println(jsonObj.toString());
		 String returnStr = PostGetUtil.getPosttMethod(configBeanPropUrl.getAddComments(),jsonObj);
		 return returnStr;
	 }

}
