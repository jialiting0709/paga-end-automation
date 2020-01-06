package com.paga.controlller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.testng.TestNG;
import com.google.common.collect.Lists;


@RestController 
public class ExecutionTestingController {
	
	 @RequestMapping(value = "/runtest",method = RequestMethod.GET)
	  public void runTest(){
//		 System.out.println("1111111");
		 TestNG tng = new TestNG();
	     List<String> suites = Lists.newArrayList();
	     //Get project root path
	     String root = System.getProperty("user.dir");
	     suites.add(root+"/config/testng.xml");
	     tng.setTestSuites(suites);
	     tng.run();
	 }
}
