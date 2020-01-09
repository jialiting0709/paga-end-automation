package com.medimpact.paga.front.automation.cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import com.medimpact.paga.front.automation.utils.BaseTest;
import com.medimpact.paga.front.automation.utils.ReuseCase;
@SpringBootTest
public class RejectApproveSubTaskReviewTest extends BaseTest{
	
	@Autowired
    private ReuseCase publicTest;
	
	@Test(description = "login")
	public void login(){
		publicTest.login(driver,"wang","1111","My Workbench");		
	}
	
	@Test(dependsOnMethods = "login",description = "Submit the subprocess for review after return")
	public void rejectApproveSubTaskReview() throws InterruptedException{
		publicTest.approveSubTaskReview(driver, "first comment", "wang", "My Workbench");
	
	}
}