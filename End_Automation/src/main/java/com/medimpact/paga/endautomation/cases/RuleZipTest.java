package com.medimpact.paga.endautomation.cases;

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

import com.medimpact.paga.endautomation.domain.CaseRelevanceData;
import com.medimpact.paga.endautomation.domain.ConfigBeanPropUrl;
import com.medimpact.paga.endautomation.domain.UserInfo;

@SpringBootTest
public class RuleZipTest extends AbstractTestNGSpringContextTests{
	private static final Logger logger = LoggerFactory.getLogger(RuleZipTest.class);
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="newSubTaskDeployedUuid", groups="ruleZip",description = "rule zip")
	private void ruleZip() throws IOException, InterruptedException {
		String result = getResult();
		Assert.assertNotNull(result);
		Thread.sleep(3000);
		
	}
	  private String getResult() throws IOException {
	        StringBuilder sb =new StringBuilder(configBeanPropUrl.getUri()+configBeanPropUrl.getRuleZip());
	        sb.append("/");
	        sb.append(CaseRelevanceData.pkValue);
	        sb.append("/");
	        sb.append(CaseRelevanceData.subtaskid);
	        HttpGet get = new HttpGet(sb.toString());
	        logger.info("rule zip url: "+sb.toString());
	        get.addHeader("username", UserInfo.username);
//	        get.addHeader("access_token",TestConfig.access_token);
//	        get.addHeader("refresh_token",TestConfig.refresh_token);
//	        get.addHeader("token_type",TestConfig.token_type);
//	        get.addHeader("refreshToken_lifeSpan",TestConfig.refreshToken_lifeSpan);
//	        get.addHeader("jti",TestConfig.jti);

	        HttpResponse response = UserInfo.defaultHttpClient.execute(get);
	        String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
	        logger.info(jsonStr);
	        return jsonStr;

	    }	
}
	

