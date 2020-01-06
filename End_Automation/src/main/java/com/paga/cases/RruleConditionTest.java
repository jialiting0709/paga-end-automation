package com.paga.cases;

import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.config.CaseRelevanceData;
import com.paga.config.TestConfig;
import com.paga.utils.ConfigBeanPropUrl;

@SpringBootTest
public class RruleConditionTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(RruleConditionTest.class);
	
    @Autowired
    ConfigBeanPropUrl configBeanPropUrl;
    
    @Test(dependsOnGroups = "addLinkingCrit", groups = "condition",description = "condition")
    private void test() throws IOException, InterruptedException {
    	logger.info("condition url："+configBeanPropUrl.getCondition());
        String res = run();
        Assert.assertNotNull(res);
        Thread.sleep(3000);
        
        
    }
    
    private String run() throws IOException {

        HttpGet get = new HttpGet(configBeanPropUrl.getCondition());
        get.addHeader("username", TestConfig.username);
//        get.addHeader("access_token",TestConfig.access_token);
//        get.addHeader("refresh_token",TestConfig.refresh_token);
//        get.addHeader("token_type",TestConfig.token_type);
//        get.addHeader("refreshToken_lifeSpan",TestConfig.refreshToken_lifeSpan);
//        get.addHeader("jti",TestConfig.jti);

        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
        String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
        logger.info("Interface response results："+jsonStr);
        JSONArray resJA = new JSONArray(jsonStr);
        int criteriaCode = resJA.getJSONObject(0).getInt("criteriaCode");
        CaseRelevanceData.criteriaCode = criteriaCode;       
        return jsonStr;

    }

}
