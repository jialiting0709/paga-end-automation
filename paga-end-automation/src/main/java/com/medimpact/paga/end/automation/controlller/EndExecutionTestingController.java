package com.medimpact.paga.end.automation.controlller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.testng.TestNG;
import com.google.common.collect.Lists;


@RestController 
@RequestMapping("/End_Automation")
public class EndExecutionTestingController {
	
	 @RequestMapping(value = "/runEndtest",method = RequestMethod.GET)
	  public String runTest(){
		 TestNG tng = new TestNG();
	     List<String> suites = Lists.newArrayList();
	     //Get project root path
	     String root = System.getProperty("user.dir");
	     suites.add(root+"/src/test/resources/testng.xml");
	     tng.setTestSuites(suites);
	     tng.run();
	     return "完成接口测试";
	 }
}
