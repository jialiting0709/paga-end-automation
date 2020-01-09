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
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.medimpact.paga.end.automation.domain.CaseRelevanceData;
import com.medimpact.paga.end.automation.domain.ConfigBeanPropUrl;
import com.medimpact.paga.end.automation.utils.HttpUtils;

@SpringBootTest
public class AddPathTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(AddPathTest.class);
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="condition", groups="addPath",description = "add Path")
	public void addPath() throws Exception { 
		logger.info("add path url："+configBeanPropUrl.getUri()+configBeanPropUrl.getAddPaths());
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
		criteriasJSO.put("criteriaCode", new CaseRelevanceData().getCriteriaCode());//
		criteriasArr.add(criteriasJSO);
		criteriaJS.set("criterias", criteriasArr);
		criteriaGroupsArr.add(criteriaJS);
		jsonObj.set("criteriaGroups", criteriaGroupsArr);
		
		ObjectNode jsonSubTaskPathVo = mapper.createObjectNode();
		jsonSubTaskPathVo.put("paglsubtaskid", new CaseRelevanceData().getSubtaskid()+"");
		jsonSubTaskPathVo.put("pathapprovaltext", "approvaltext");
		jsonSubTaskPathVo.put("pathinitrenewal", 1);
		jsonSubTaskPathVo.put("pathinstruction", "instructions");
		jsonSubTaskPathVo.put("pathname", "path name");
		jsonSubTaskPathVo.put("pathsummary", "summary");
		jsonSubTaskPathVo.put("pathtype", 1);
		jsonSubTaskPathVo.put("statuscode", 1);	
		jsonObj.put("pathseqnum", 1);	
		jsonObj.set("subTaskPathVo",jsonSubTaskPathVo);
		String returnStr = HttpUtils.getPosttMethod(configBeanPropUrl.getUri()+configBeanPropUrl.getAddPaths(), jsonObj);
		new CaseRelevanceData().setAddPathId(returnStr);
		return returnStr;
		  
	}

}
