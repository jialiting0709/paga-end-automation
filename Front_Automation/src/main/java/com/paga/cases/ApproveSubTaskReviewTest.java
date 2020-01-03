package com.paga.cases;

import org.testng.annotations.Test;

import com.paga.util.BaseTest;

import com.paga.util.PublicTest;

public class ApproveSubTaskReviewTest extends BaseTest{
	
	
	@Test(description = "login")
	public void login(){
		PublicTest.login(driver,"wang","1111","My Workbench");		
	}
	
	@Test(dependsOnMethods = "login",description = "Submission Review")
	public void approveSubTaskReview() throws InterruptedException{
		PublicTest.approveSubTaskReview(driver, "first comment", "wang", "My Workbench");

		
	}
}
