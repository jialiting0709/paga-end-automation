package com.paga.cases;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.page.LoginPage;
import com.paga.page.MyWorkbenchPage;
import com.paga.page.SubTaskReviewPage;
import com.paga.util.BaseTest;
import com.paga.util.Config;

public class ApproveSubTaskReviewTest extends BaseTest{
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
	
	@Test(dependsOnMethods = "login",description = "提交Review")
	public void approveSubTaskReview() throws InterruptedException{
		//点击  SubTasks on the Review
//		myWorkbenchPage.click_SubTasks_on_the_Review();
		//点击列表中第一条
		myWorkbenchPage.click_SubTasks_on_the_Review_list_one();
		//点击Path List下拉框
		SubTaskReviewPage subTaskReviewPage = PageFactory.initElements(driver,SubTaskReviewPage.class);
		subTaskReviewPage.click_Path_List();
		//点击操作按钮
		subTaskReviewPage.click_more_vert();
		//点击Preview
		subTaskReviewPage.click_Preview();
		Thread.sleep(1000);
		//鼠标点击空白
		Actions actions = new Actions(driver);
	    actions.moveByOffset(0, 0).click().build().perform();		
		//点击mode_edit按钮
	    subTaskReviewPage.click_mode_edit();
	    //输入comment
	    subTaskReviewPage.input_add_comment("first comment");
	    //点击Complete
	    subTaskReviewPage.click_Complete();
	    Thread.sleep(1000);
	    //输入Assign to
	    subTaskReviewPage.input_Assign_to("wang");
	    //点击Assign
	    subTaskReviewPage.click_Assign();
	    Thread.sleep(2000);
	    //获取My_Workbench文本
	    String My_Workbench = myWorkbenchPage.getMy_Workbench();
		Assert.assertEquals(My_Workbench, "My Workbench");	
		
	}
}
