package com.paga.cases;


import com.paga.config.CaseRelevanceData;
import com.paga.utils.ConfigBeanPropUrl;

import com.paga.utils.CasePublic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

@SpringBootTest
public class UpdateSubTaskTest extends AbstractTestNGSpringContextTests {
	
    @Autowired
    ConfigBeanPropUrl configBeanPropUrl;
    @Test(dependsOnGroups="addPath", groups="updateSubTask",description = "update SubTask")

    private void updateSubTask() throws IOException, InterruptedException {
    	String url = configBeanPropUrl.getUpdateSub();
    	System.out.println("update SubTask url:"+url);
    	HashMap<String,Object> map=new HashMap<String,Object>();
    	map.put("subtaskuuid", CaseRelevanceData.subtaskuuid);
    	map.put("status", 3);
    	String res = CasePublic.updateSubTask(url,map);
        Assert.assertNotNull(res);
        Thread.sleep(2000);

    }
  
}
