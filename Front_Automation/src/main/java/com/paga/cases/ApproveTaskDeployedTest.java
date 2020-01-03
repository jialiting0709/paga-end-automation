package com.paga.cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.paga.page.MyWorkbenchPage;
import com.paga.page.TaskPushPage;
import com.paga.util.BaseTest;

import com.paga.util.PublicTest;

public class ApproveTaskDeployedTest extends BaseTest{
	private MyWorkbenchPage myWorkbenchPage;
	
	
	@Test(description = "login")
	public void login(){
		PublicTest.login(driver,"wang","1111");			
	}
	
	@Test(dependsOnMethods = "login",description = "task done")
	public void approveTaskDeployed() throws InterruptedException{
		//点击列表中第一条
		myWorkbenchPage = PageFactory.initElements(driver,MyWorkbenchPage.class);
		myWorkbenchPage.click_Tasks_for_Deployed_list_one();
		//点击comment
		TaskPushPage taskPushPage = PageFactory.initElements(driver,TaskPushPage.class);
		taskPushPage.click_comment();
		//输入comment
		taskPushPage.input_comment("task push comment");
		//点击Complete
		taskPushPage.click_comment_button();
		Thread.sleep(2000);
		//获取My_Workbench文本
		String My_Workbench = myWorkbenchPage.getMy_Workbench();
		Assert.assertEquals(My_Workbench, "My Workbench");	

		
	}
}
