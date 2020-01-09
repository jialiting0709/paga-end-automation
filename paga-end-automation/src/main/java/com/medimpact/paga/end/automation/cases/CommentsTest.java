package com.medimpact.paga.end.automation.cases;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.medimpact.paga.end.automation.domain.CaseRelevanceData;
import com.medimpact.paga.end.automation.domain.ConfigBeanPropUrl;
import com.medimpact.paga.end.automation.domain.UserInfo;

@SpringBootTest
public class CommentsTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(CommentsTest.class);
	
    @Autowired
    ConfigBeanPropUrl configBeanPropUrl;
    
    @Test(dependsOnGroups = "addComment", groups = "commentsId",description = "query comments id")
    private void test() throws IOException, InterruptedException {
        String res = run();
        Assert.assertNotNull(res);
        Thread.sleep(3000);
    }
    private String run() throws IOException {
        StringBuilder sb =new StringBuilder(configBeanPropUrl.getUri()+configBeanPropUrl.getComments());
        sb.append("/");
        sb.append(CaseRelevanceData.pkValue);
        sb.append("/");
        sb.append(CaseRelevanceData.subtaskid);
        HttpGet get = new HttpGet(sb.toString());
        logger.info("query comments id: "+sb.toString());
        get.addHeader("username", UserInfo.username);
//        get.addHeader("access_token",TestConfig.access_token);
//        get.addHeader("refresh_token",TestConfig.refresh_token);
//        get.addHeader("token_type",TestConfig.token_type);
//        get.addHeader("refreshToken_lifeSpan",TestConfig.refreshToken_lifeSpan);
//        get.addHeader("jti",TestConfig.jti);

        HttpResponse response = UserInfo.defaultHttpClient.execute(get);
        String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
        logger.info("Results of the interface："+jsonStr);
        JsonNode resJson = new ObjectMapper().readTree(jsonStr); 
        ArrayNode an = (ArrayNode)resJson.path("SubtaskReview");
        String commentId = null;
        for(int j=0;j<an.size();j++){
        	commentId = an.get(j).path("id").asText();
        }
        CaseRelevanceData.commentId = commentId; 
        logger.info("commentId:"+commentId);
        return commentId;

    }

}
