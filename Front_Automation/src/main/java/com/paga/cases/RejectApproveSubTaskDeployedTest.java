package com.paga.cases;

import org.testng.annotations.Test;

import com.paga.util.BaseTest;
import com.paga.util.PublicTest;

public class RejectApproveSubTaskDeployedTest extends BaseTest{
	@Test(description = "login")
	public void login(){
		PublicTest.login(driver,"wang","1111","My Workbench");			
	}
	
	@Test(dependsOnMethods = "login",description = "Return subprocess to complete deployed")
	public void rejectApproveSubTaskDeployed() throws InterruptedException{
		PublicTest.approveSubTaskDeployed(driver, "Second comments", "My Workbench");
	}
}
