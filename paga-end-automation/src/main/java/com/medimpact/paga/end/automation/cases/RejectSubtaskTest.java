package com.medimpact.paga.end.automation.cases;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.medimpact.paga.end.automation.domain.CaseRelevanceData;
import com.medimpact.paga.end.automation.domain.ConfigBeanPropUrl;
import com.medimpact.paga.end.automation.utils.HttpUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@SpringBootTest
public class RejectSubtaskTest extends AbstractTestNGSpringContextTests {
	private static final Logger logger = LoggerFactory.getLogger(RejectSubtaskTest.class);
	
    @Autowired
    private ConfigBeanPropUrl configBeanPropUrl;

    @Test(dependsOnGroups = "commentsId",groups = "rejectTask",description = "reject a subtask")
   
    public void rejectTask() throws Exception{
    	logger.info("reject a subtask url:"+configBeanPropUrl.getUri()+configBeanPropUrl.getRejectSubTask());   	
    	String result = getResult();
        JsonNode res = new ObjectMapper().readTree(result); 
        Assert.assertNotNull(res);
        Thread.sleep(3000);
    }
    private String getResult() throws IOException {
    	ObjectMapper mapper= new ObjectMapper();
        ObjectNode jsonObject = mapper.createObjectNode();
        jsonObject.put("assignee","");
        jsonObject.put("defineKey","SubtaskReview");
        ArrayNode array = mapper.createArrayNode();
        ObjectNode subObj = mapper.createObjectNode();
        subObj.put("id",new CaseRelevanceData().getCommentId());
        subObj.put("tkUuid",new CaseRelevanceData().getNewReviewSubTaskuuid());
        subObj.put("message","234");
        array.add(subObj);
        jsonObject.set("comments",array);
        ObjectNode sObj = mapper.createObjectNode();
        sObj.put("pkType","guidlineSubTask");
        sObj.put("pkValue",new CaseRelevanceData().getPkValue());
        jsonObject.set("selfProps",sObj);
        jsonObject.put("uuid", new CaseRelevanceData().getNewReviewSubTaskuuid());
        
        return HttpUtils.getPosttMethod(configBeanPropUrl.getUri()+configBeanPropUrl.getRejectSubTask(),jsonObject);

    }
}
