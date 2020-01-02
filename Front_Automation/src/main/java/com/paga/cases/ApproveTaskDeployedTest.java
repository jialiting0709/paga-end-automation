package com.paga.cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.page.LoginPage;
import com.paga.page.MyWorkbenchPage;
import com.paga.page.TaskPushPage;
import com.paga.util.BaseTest;
import com.paga.util.Config;

public class ApproveTaskDeployedTest extends BaseTest{
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
	
	@Test(dependsOnMethods = "login",description = "task done")
	public void approveTaskDeployed() throws InterruptedException{
		//点击列表中第一条
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
