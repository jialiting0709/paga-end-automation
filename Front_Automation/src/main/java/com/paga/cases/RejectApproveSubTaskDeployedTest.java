package com.paga.cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import com.paga.util.BaseTest;
import com.paga.util.PublicTest;
@SpringBootTest
public class RejectApproveSubTaskDeployedTest extends BaseTest{
	
	@Autowired
    private PublicTest publicTest;
	
	@Test(description = "login")
	public void login(){
		publicTest.login(driver,"wang","1111","My Workbench");			
	}
	
	@Test(dependsOnMethods = "login",description = "Return subprocess to complete deployed")
	public void rejectApproveSubTaskDeployed() throws InterruptedException{
		publicTest.approveSubTaskDeployed(driver, "Second comments", "My Workbench");
	}
}
