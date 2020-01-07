package com.paga.cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.page.MyWorkbenchPage;
import com.paga.page.TaskReviewPage;
import com.paga.util.BaseTest;
import com.paga.util.PublicTest;

public class RejectTaskOnReviewTest extends BaseTest{
	private MyWorkbenchPage myWorkbenchPage;
	
	@Test(description = "login")
	public void login(){
		PublicTest.login(driver,"wang","1111","My Workbench");			
	}
	
	@Test(dependsOnMethods = "login",description = "退回主任务")
	public void rejectTaskOnReview() throws InterruptedException{
		myWorkbenchPage = PageFactory.initElements(driver,MyWorkbenchPage.class);
		//点击Tasks on the Review列表第一个
		myWorkbenchPage.click_Tasks_on_the_Review_list_one();
		//点击comments操作按钮
		TaskReviewPage taskReviewPage = PageFactory.initElements(driver,TaskReviewPage.class);
		taskReviewPage.click_comment();
		//输入comments
		taskReviewPage.input_comment("task Review Reject");
		//点击Reject按钮
		taskReviewPage.click_Reject_button();
		Thread.sleep(3000);
		//获取My_Workbench文本
		String My_Workbench = myWorkbenchPage.getMy_Workbench();
		Assert.assertEquals(My_Workbench, "My Workbench");				
		
	}
}
