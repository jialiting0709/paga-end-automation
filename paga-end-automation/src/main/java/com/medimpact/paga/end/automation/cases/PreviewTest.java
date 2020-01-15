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

import com.medimpact.paga.end.automation.domain.ConfigBeanPropUrl;
import com.medimpact.paga.end.automation.domain.MemoryData;
import com.medimpact.paga.end.automation.domain.UserInfo;

@SpringBootTest
public class PreviewTest extends AbstractTestNGSpringContextTests{
	 private static final Logger logger = LoggerFactory.getLogger(PreviewTest.class);
	 
	 @Autowired
	    ConfigBeanPropUrl configBeanPropUrl;
	    
	    @Test(dependsOnGroups = "addPath", groups = "preview",description = "rule preview")
	    private void preview() throws IOException, InterruptedException {
	        String res = run();
	        Assert.assertNotNull(res);
	        Thread.sleep(3000);
	    }
	    private String run() throws IOException {
	        StringBuilder sb =new StringBuilder(configBeanPropUrl.getUri()+configBeanPropUrl.getPreview());
	        sb.append("/");
	        sb.append(MemoryData.getCaseRelevanceData().getAddPathId());
	        HttpGet get = new HttpGet(sb.toString());
	        logger.info("rule preview url: "+sb.toString());
	        get.addHeader("username", new UserInfo().getUsername());
//	        get.addHeader("username","wang");
//	        get.addHeader("access_token",TestConfig.access_token);
//	        get.addHeader("refresh_token",TestConfig.refresh_token);
//	        get.addHeader("token_type",TestConfig.token_type);
//	        get.addHeader("refreshToken_lifeSpan",TestConfig.refreshToken_lifeSpan);
//	        get.addHeader("jti",TestConfig.jti);

	        HttpResponse response = MemoryData.getCaseRelevanceData().getDefaultHttpClient().execute(get);
	        String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
	        logger.info("Interface response results："+jsonStr);

	        return jsonStr;	        

	    }
}
