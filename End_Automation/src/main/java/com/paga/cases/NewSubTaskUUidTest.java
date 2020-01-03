package com.paga.cases;

import java.util.HashMap;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.config.CaseRelevanceData;

import com.paga.utils.ConfigBeanPropUrl;
import com.paga.utils.PublicCase;


@SpringBootTest
public class NewSubTaskUUidTest extends AbstractTestNGSpringContextTests{
	
	@Autowired
    private ConfigBeanPropUrl configBeanPropUrl;
	
	@Test(dependsOnGroups="completeSubTask", groups="newSubTaskuuid",description = "new SubTask uuid")	
	public void newSubTaskuuid() throws Exception {  
		String url = configBeanPropUrl.getNewSubTaskuuid();
		System.out.println("taskFlow task url："+url);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("key", "SubtaskReview");
		map.put("pk", "pk");
		map.put("subTask", "subTask");
		map.put("id", "id");
		map.put("subtaskid", CaseRelevanceData.subtaskid);
		map.put("df", "df");
		map.put("uuid", "uuid");
		String result = PublicCase.getNewSubandTaskuuid(url, map);		
		Assert.assertNotNull(result);
		Thread.sleep(3000);
	}
	
//	 private String getResult() throws IOException{
//		 
//		 HttpGet get = new HttpGet(configBeanPropUrl.getNewSubTaskuuid());
//		 get.addHeader("username", TestConfig.username);		 
//		 HttpResponse response = TestConfig.defaultHttpClient.execute(get);
//	     String jsonStr = EntityUtils.toString(response.getEntity(),"utf-8");
//
//	     System.out.println("Interface response results：："+jsonStr);
//	     System.out.println("subtaskid==========="+CaseRelevanceData.subtaskid);
//	     JSONObject resObj = new JSONObject(jsonStr);
//	     String subtaskuuid = null;
//	     JSONArray arr = resObj.getJSONArray("SubtaskReview");	     
//	     for(int i=0;i<arr.length();i++){
//	    	 int subTaskId = arr.getJSONObject(i).getJSONObject("pk").getJSONObject("subTask").getInt("id");
//	    	 if(subTaskId==CaseRelevanceData.subtaskid){
//	    		 subtaskuuid = arr.getJSONObject(i).getJSONObject("df").getString("uuid");
//	    	 }else{
//	    		 continue;
//	    	 }
//	     }
//	     CaseRelevanceData.newReviewSubTaskuuid = subtaskuuid;
//	     System.out.println("subtaskuuid的值为："+subtaskuuid);	     
//	     return subtaskuuid;
//
//	 }
}
