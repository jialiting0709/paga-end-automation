package com.paga.cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.page.LoginPage;
import com.paga.page.MyWorkbenchPage;
import com.paga.page.PushPage;
import com.paga.util.BaseTest;
import com.paga.util.Config;

public class ApproveSubTaskDeployedTest extends BaseTest{
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
	
	@Test(dependsOnMethods = "login",description = "提交Deployed")
	public void approveSubTaskReview() throws InterruptedException{
		//点击  SubTasks for Deployed
//		myWorkbenchPage.click_SubTasks_for_Deployed();
		//点击SubTasks for Deployed列表中第一个条
		myWorkbenchPage.click_SubTasks_for_Deployed_list_one();
		//点击comments按钮
		PushPage pushPage= PageFactory.initElements(driver,PushPage.class);
		pushPage.click_comment();
		//输入comments
		pushPage.input_comment("Second comments");
		//点击Comlete
		pushPage.click_comment_button();
		Thread.sleep(2000);
		//获取My_Workbench文本
		String My_Workbench = myWorkbenchPage.getMy_Workbench();
		Assert.assertEquals(My_Workbench, "My Workbench");				
		
	}
	
}
