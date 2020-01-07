package com.paga.cases;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.paga.config.CaseRelevanceData;
import com.paga.config.TestConfig;
import com.paga.utils.ConfigBeanPropUrl;
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
    	logger.info(configBeanPropUrl.getAddclink());
        String  uuid = test();
        Assert.assertNotNull(uuid);
    }


    private String test() throws IOException {
        HttpPost post = new HttpPost(configBeanPropUrl.getAddclink());
        post.addHeader("username", TestConfig.username);
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
        obj1.put("generic","C1 ESTERASE INHIBITOR");
        obj1.put("gpid","N/A");
        obj1.put("hicl","18568");
        obj1.put("ndccode",57894006002L);
        obj1.put("paglsubtaskid",CaseRelevanceData.subtaskid);
        obj1.put("route","ORAL");
        obj1.put("stc","N/A");
        array.add(obj1);
        ObjectNode obj2 = mapper.createObjectNode();
        obj2.put("brand","HAEGARDA");
        obj2.put("critexception","{\"Generic\":true,\"Brand\":true,\"GPID\":true,\"STC\":true,\"Route\":true}");
        obj2.put("critseq",2);
        obj2.put("generic","BERINERT");
        obj2.put("gpid","N/A");
        obj2.put("hicl","18568");
        obj2.put("ndccode",57894006003L);
        obj2.put("paglsubtaskid",CaseRelevanceData.subtaskid);
        obj2.put("route","Intravenous of Subcutaneous");
        obj2.put("stc","N/A");
        array.add(obj2);
        StringEntity entity = new StringEntity(array.toString(),"utf-8");
        post.setEntity(entity);
        HttpResponse response = TestConfig.defaultHttpClient.execute(post);
        String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
        logger.info("Interface response results："+jsonStr);
        JsonNode arrayNode= new ObjectMapper().readTree(jsonStr);
//        JSONArray REsA = new JSONArray(jsonStr);
        String brand = null;
        if(arrayNode.isArray()){
        	brand = arrayNode.get(0).path("brand").asText();
        }
//        JSONObject jsonRest= REsA.getJSONObject(0);
        return brand;


    }
}
