package com.paga.cases;

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

import com.paga.config.CaseRelevanceData;
import com.paga.config.TestConfig;
import com.paga.utils.ConfigBeanPropUrl;
import com.paga.utils.GetDateUtil;

@SpringBootTest
public class RulePathTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(RulePathTest.class);
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="newSubTaskDeployedUuid", groups="RulePath",description = "rule path")
	private void RulePath() throws IOException, InterruptedException {
		logger.info("rule path url:"+configBeanPropUrl.getRulePath());		
		String result = getResult();
		Assert.assertNotNull(result);
		Thread.sleep(3000);
		
	}
	
	  private String getResult() throws IOException {
	        StringBuilder sb =new StringBuilder(configBeanPropUrl.getRulePath());
	        sb.append("/");
	        sb.append(CaseRelevanceData.subtaskid);
	        sb.append("/");
	        sb.append(GetDateUtil.getStringDate(0L,"yyyyMMdd"));
	        HttpGet get = new HttpGet(sb.toString());
	        logger.info("rule path url: "+sb.toString());
//	        get.addHeader("access_token",TestConfig.access_token);
//	        get.addHeader("refresh_token",TestConfig.refresh_token);
//	        get.addHeader("token_type",TestConfig.token_type);
//	        get.addHeader("refreshToken_lifeSpan",TestConfig.refreshToken_lifeSpan);
//	        get.addHeader("jti",TestConfig.jti);
	        get.addHeader("username",TestConfig.username);
	        HttpResponse response = TestConfig.defaultHttpClient.execute(get);
	        String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
	        return jsonStr;

	    }	
}
