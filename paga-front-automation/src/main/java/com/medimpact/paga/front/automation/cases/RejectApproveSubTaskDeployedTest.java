package com.medimpact.paga.front.automation.cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import com.medimpact.paga.front.automation.utils.BaseTest;
import com.medimpact.paga.front.automation.utils.ReuseCase;
@SpringBootTest
public class RejectApproveSubTaskDeployedTest extends BaseTest{
	
	@Autowired
    private ReuseCase publicTest;
	
	@Test(description = "login")
	public void login(){
		publicTest.login(driver,"wang","1111","My Workbench");			
	}
	
	@Test(dependsOnMethods = "login",description = "Return subprocess to complete deployed")
	public void rejectApproveSubTaskDeployed() throws InterruptedException{
		publicTest.approveSubTaskDeployed(driver, "Second comments", "My Workbench");
	}
}
