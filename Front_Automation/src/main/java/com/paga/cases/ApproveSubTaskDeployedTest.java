package com.paga.cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.paga.page.MyWorkbenchPage;
import com.paga.page.PushPage;
import com.paga.util.BaseTest;

import com.paga.util.PublicFunction;
import com.paga.util.PublicTest;

public class ApproveSubTaskDeployedTest extends BaseTest{
	private MyWorkbenchPage myWorkbenchPage;
	
	
	@Test(description = "login")
	public void login(){
		PublicTest.login(driver,"wang","1111");			
	}
	
	@Test(dependsOnMethods = "login",description = "提交Deployed")
	public void approveSubTaskReview() throws InterruptedException{
		//点击  SubTasks for Deployed
//		myWorkbenchPage.click_SubTasks_for_Deployed();
		//点击SubTasks for Deployed列表中第一个条
		myWorkbenchPage = PageFactory.initElements(driver,MyWorkbenchPage.class);
		myWorkbenchPage.click_SubTasks_for_Deployed_list_one();
		//点击comments按钮
		PushPage pushPage= PageFactory.initElements(driver,PushPage.class);
		pushPage.click_comment();
		//输入comments
		pushPage.input_comment("Second comments");
		//点击Comlete
		pushPage.click_comment_button();
		//输入时间
		pushPage.input_data_input(PublicFunction.getStringDate(1L));
		//点击OK
		pushPage.click_ok_button();
		Thread.sleep(3000);
		//获取My_Workbench文本
		String My_Workbench = myWorkbenchPage.getMy_Workbench();
		Assert.assertEquals(My_Workbench, "My Workbench");				
		
	}
	
}
