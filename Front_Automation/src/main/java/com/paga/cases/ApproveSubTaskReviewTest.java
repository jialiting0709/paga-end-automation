package com.paga.cases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.annotations.Test;

import com.paga.util.BaseTest;

import com.paga.util.MultiplexingCase;
@SpringBootTest
public class ApproveSubTaskReviewTest extends BaseTest{
	
	@Autowired
    private MultiplexingCase publicTest;
	
	
	@Test(description = "login")
	public void login(){
		publicTest.login(driver,"wang","1111","My Workbench");		
	}
	
	@Test(dependsOnMethods = "login",description = "Submission Review")
	public void approveSubTaskReview() throws InterruptedException{
		publicTest.approveSubTaskReview(driver, "first comment", "wang", "My Workbench");

		
	}
}
