package com.paga.cases;

import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.paga.page.MyWorkbenchPage;
import com.paga.page.TaskPushPage;
import com.paga.util.BaseTest;

import com.paga.util.MultiplexingCase;
@SpringBootTest
public class ApproveTaskDeployedTest extends BaseTest{
	private MyWorkbenchPage myWorkbenchPage;
	
	@Autowired
    private MultiplexingCase publicTest;
	
	@Test(description = "login")
	public void login(){
		publicTest.login(driver,"wang","1111","My Workbench");			
	}
	
	@Test(dependsOnMethods = "login",description = "task done")
	public void approveTaskDeployed() throws InterruptedException{
		//click list one
		myWorkbenchPage = PageFactory.initElements(driver,MyWorkbenchPage.class);
		myWorkbenchPage.click_Tasks_for_Deployed_list_one();
		//click comment
		TaskPushPage taskPushPage = PageFactory.initElements(driver,TaskPushPage.class);
		taskPushPage.click_comment();
		//input comment
		taskPushPage.input_comment("task push comment");
		//click Complete
		taskPushPage.click_comment_button();
		Thread.sleep(2000);
		//get My_Workbench text
		String My_Workbench = myWorkbenchPage.getMy_Workbench();
		Assert.assertEquals(My_Workbench, "My Workbench");	

		
	}
}
