package com.paga.cases;

import java.io.IOException;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.config.CaseRelevanceData;
import com.paga.utils.ConfigBeanPropUrl;
import com.paga.utils.ReuseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@SpringBootTest
public class UpdateSubTaskReJTest extends AbstractTestNGSpringContextTests{
	 private static final Logger logger = LoggerFactory.getLogger(UpdateSubTaskReJTest.class);
	
	 @Autowired
	 ConfigBeanPropUrl configBeanPropUrl;
	 @Test(dependsOnGroups="NewSubTaskReJUUid", groups="UpdateSubTaskReJ",description = "update SubTaskRej")

	 private void test() throws IOException, InterruptedException {
		String url = configBeanPropUrl.getUri()+configBeanPropUrl.getUpdateSub();
		logger.info("update SubTask url:"+url);
		HashMap<String,Object> map = new HashMap<String,Object>();
	    map.put("subtaskuuid",CaseRelevanceData.subtaskRejuuid);
	    map.put("status", 1);
	    String res = ReuseCase.updateSubTask(url,map);
	    Assert.assertNotNull(res);
	    Thread.sleep(2000);

	   }
	

}
