package com.medimpact.paga.front.automation.controlller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.testng.TestNG;
import com.google.common.collect.Lists;


@RestController
@RequestMapping("/Front_Automation")
public class FrontExecutionTestingController {	
	 @RequestMapping(value = "/runFronttest",method = RequestMethod.GET)
	  public String runTest(){
		 TestNG tng = new TestNG();
	     List<String> suites = Lists.newArrayList();
	     //Get project root path
	     String root = System.getProperty("user.dir");
	     suites.add(root+"/src/main/resources/testng.xml");
	     tng.setTestSuites(suites);
	     tng.run();
	     return "完成UI测试";
	 }
}
