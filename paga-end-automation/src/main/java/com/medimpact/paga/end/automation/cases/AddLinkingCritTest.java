package com.medimpact.paga.end.automation.cases;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.medimpact.paga.end.automation.domain.ConfigBeanPropUrl;
import com.medimpact.paga.end.automation.domain.MemoryData;
import com.medimpact.paga.end.automation.utils.DateUtils;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

@SpringBootTest
public class AddLinkingCritTest extends AbstractTestNGSpringContextTests {
	private static final Logger logger = LoggerFactory.getLogger(AddLinkingCritTest.class);
	
    @Autowired
    private ConfigBeanPropUrl configBeanPropUrl;

    @Test(dependsOnGroups="startSubtask", groups="addLinkingCrit",description = "add a Linking Crit")
    private void addLinkingCrit() throws IOException {
    	logger.info(configBeanPropUrl.getUri()+configBeanPropUrl.getAddclink());
        String  uuid = test();
        Assert.assertNotNull(uuid);
    }


    private String test() throws IOException {
        HttpPost post = new HttpPost(configBeanPropUrl.getUri()+configBeanPropUrl.getAddclink());
        post.addHeader("username",MemoryData.getUserInfo().getUsername());
//        post.addHeader("access_token",TestConfig.access_token);
//        post.addHeader("refresh_token",TestConfig.refresh_token);
//        post.addHeader("token_type",TestConfig.token_type);
//        post.addHeader("refreshToken_lifeSpan",TestConfig.refreshToken_lifeSpan);
//        post.addHeader("jti",TestConfig.jti);
        post.setHeader("Content-Type","application/json");
        ObjectMapper mapper= new ObjectMapper();
        ArrayNode array = mapper.createArrayNode();
        ObjectNode obj1 = mapper.createObjectNode();
        obj1.put("brand","HAEGARDA");
        obj1.put("critexception","{\"Generic\":true,\"Brand\":true,\"GPID\":true,\"STC\":true,\"Route\":true}");
        obj1.put("critseq",1);
        obj1.put("entered",DateUtils.getStringDate(1L,"yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
        obj1.put("enteredby","");
        obj1.put("generic","");
        obj1.put("gpid","10130");
        obj1.put("hicl","01617");
        obj1.put("paglsubtaskid",MemoryData.getCaseRelevanceData().getSubtaskid());
        obj1.put("route","");
        obj1.put("stc","0455");
        array.add(obj1);
        ObjectNode obj2 = mapper.createObjectNode();
        obj2.put("brand","XANAX");
        obj2.put("critexception","{\"Generic\":true,\"Brand\":true,\"GPID\":true,\"STC\":true,\"Route\":true}");
        obj2.put("critseq",2);
        obj2.put("entered",DateUtils.getStringDate(1L,"yyyy-MM-dd'T'HH:mm:ss.SSSZ"));
        obj2.put("enteredby","");
        obj2.put("generic","10131");
        obj2.put("gpid","FDB");
        obj2.put("hicl","01617");
        obj2.put("paglsubtaskid",MemoryData.getCaseRelevanceData().getSubtaskid());
        obj2.put("route","");
        obj2.put("stc","H228");
        array.add(obj2);
        StringEntity entity = new StringEntity(array.toString(),"utf-8");
        post.setEntity(entity);
        logger.info("Parameter value："+array.toString());
        HttpResponse response =MemoryData.getCaseRelevanceData().getDefaultHttpClient().execute(post);
        String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
        logger.info("Interface response results："+jsonStr);
        JsonNode arrayNode= new ObjectMapper().readTree(jsonStr);
        String brand = null;
        if(arrayNode.isArray()){
        	brand = arrayNode.get(0).path("brand").asText();
        }
        return brand;


    }
}
