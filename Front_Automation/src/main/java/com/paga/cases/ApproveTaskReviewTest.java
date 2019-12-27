package com.paga.cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.page.LoginPage;
import com.paga.page.MyWorkbenchPage;
import com.paga.page.TaskReviewPage;
import com.paga.util.BaseTest;
import com.paga.util.Config;

public class ApproveTaskReviewTest extends BaseTest{
	private MyWorkbenchPage myWorkbenchPage;

	@Test(description = "登陆")
	public void login(){
		Config config = new Config("config.properties");
		String url = config.getConfig("url");
		driver.get(url);
		//输入User Name
		LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
		loginPage.input_userName("wang");
		//输入userPassword
		loginPage.input_userPassword("1111");
		//点击登陆
		loginPage.click_Log_in();
		//断言登陆成功
		myWorkbenchPage = PageFactory.initElements(driver,MyWorkbenchPage.class);
		String My_Workbench = myWorkbenchPage.getMy_Workbench_h1();
		Assert.assertEquals(My_Workbench, "My Workbench");
	}
	
	@Test(dependsOnMethods = "login",description = "task提交Deployed")
	public void approveTaskReview() throws InterruptedException{
		//点击列表中第一条
		myWorkbenchPage.click_Tasks_on_the_Review_list_one();
		//点击comments操作按钮
		TaskReviewPage taskReviewPage = PageFactory.initElements(driver,TaskReviewPage.class);
		taskReviewPage.click_comment();
		//输入comments
		taskReviewPage.input_comment("task Review Comments");
		//点击Complete
		taskReviewPage.click_comment_button();
		Thread.sleep(1000);
		//输入Assign to
		taskReviewPage.input_Assign_to("wang");
		Thread.sleep(1000);
		//点击Assign
		taskReviewPage.click_Assign_button();
		Thread.sleep(2000);
		//获取My_Workbench文本
		String My_Workbench = myWorkbenchPage.getMy_Workbench();
		Assert.assertEquals(My_Workbench, "My Workbench");	
		
	}

}
