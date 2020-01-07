package com.paga.cases;


import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.paga.config.TestConfig;

import com.paga.utils.ConfigBeanPropUrl;

import java.io.IOException;


@SpringBootTest
public class LoginTest extends AbstractTestNGSpringContextTests {
	private static final Logger logger = LoggerFactory.getLogger(LoginTest.class);

    @Autowired
    private ConfigBeanPropUrl configBeanPropUrl;

    @BeforeTest(groups = "loginTrue",description = "Test preparation, get httpclient object",alwaysRun=true)
    public void beforeTest(){
        TestConfig.defaultHttpClient = HttpClients.createDefault();
    }

    @Test(groups = "loginTrue",description = "login")
    public void loginTrue() throws Exception {
        String actual = getResult();
        Assert.assertNotNull(actual);
    }

    private String getResult() throws IOException {
    	logger.info("login url："+configBeanPropUrl.getUri()+configBeanPropUrl.getLogin());
        HttpPost post = new HttpPost(configBeanPropUrl.getUri()+configBeanPropUrl.getLogin());
        StringEntity entity = new StringEntity("username=wang&password=1111@ssword-7&grant_type=password", ContentType.APPLICATION_JSON);
        post.addHeader("authorization", "123");
        post.setEntity(entity);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
        logger.info("Interface response results："+jsonStr);
        ObjectMapper mapper = new ObjectMapper();  
	    JsonNode root = mapper.readTree(jsonStr); 
	    JsonNode data = root.path("username");
        String username = data.asText();  
        if(username != null || username.length()!= 0){
              TestConfig.username = username;
//              TestConfig.access_token = jsonObject.getString("access_token");
//              TestConfig.refresh_token = jsonObject.getString("refresh_token");
//              TestConfig.token_type = jsonObject.getString("token_type");
//              TestConfig.refreshToken_lifeSpan = jsonObject.getString("refreshToken_lifeSpan");
//              TestConfig.jti = jsonObject.getString("jti");

        }
        
        return username;
    }
}
