package com.paga.cases;

import org.testng.annotations.Test;


import com.paga.util.BaseTest;


public class DemoCase extends BaseTest{
	
	@Test
	public void test1(){
		driver.get("http://www.baidu.com");
		
	}

}
