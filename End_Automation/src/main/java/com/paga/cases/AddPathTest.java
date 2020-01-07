package com.paga.cases;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.paga.config.CaseRelevanceData;
import com.paga.utils.ConfigBeanPropUrl;
import com.paga.utils.PostGetUtil;

@SpringBootTest
public class AddPathTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(AddPathTest.class);
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="condition", groups="addPath",description = "add Path")
	public void addPath() throws Exception { 
		logger.info("add path url："+configBeanPropUrl.getAddPathss());
		String result = getResult();
		Assert.assertNotNull(result);
		Thread.sleep(3000);
		
	}
	
	private String getResult() throws IOException{
		ObjectMapper mapper= new ObjectMapper();
		ObjectNode jsonObj = mapper.createObjectNode();
		ArrayNode criteriaGroupsArr = mapper.createArrayNode();
		ObjectNode criteriaJS = mapper.createObjectNode();
		criteriaJS.put("group", 0);
		criteriaJS.put("groupType", "0");
		ArrayNode criteriasArr = mapper.createArrayNode();
		ObjectNode criteriasJSO = mapper.createObjectNode();
		criteriasJSO.put("condition", "is");
		criteriasJSO.put("value", "12");
		criteriasJSO.put("criteriaCode", CaseRelevanceData.criteriaCode);//
		criteriasArr.add(criteriasJSO);
		criteriaJS.set("criterias", criteriasArr);
		criteriaGroupsArr.add(criteriaJS);
		jsonObj.set("criteriaGroups", criteriaGroupsArr);
		
		ObjectNode jsonSubTaskPathVo = mapper.createObjectNode();
		jsonSubTaskPathVo.put("paglsubtaskid", CaseRelevanceData.subtaskid+"");
		jsonSubTaskPathVo.put("pathapprovaltext", "approvaltext");
		jsonSubTaskPathVo.put("pathinitrenewal", 1);
		jsonSubTaskPathVo.put("pathinstruction", "instructions");
		jsonSubTaskPathVo.put("pathname", "path name");
		jsonSubTaskPathVo.put("pathsummary", "summary");
		jsonSubTaskPathVo.put("pathtype", 1);
		jsonSubTaskPathVo.put("statuscode", 1);	
		jsonObj.put("pathseqnum", 1);	
		jsonObj.set("subTaskPathVo",jsonSubTaskPathVo);
		String returnStr = PostGetUtil.getPosttMethod(configBeanPropUrl.getAddPathss(), jsonObj);
		CaseRelevanceData.addPathId = returnStr;
		return returnStr;
		  
	}

}
