package com.paga.cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;


import com.paga.page.MyWorkbenchPage;

import com.paga.page.SubTasksInProcessPage;
import com.paga.page.TaskProfilePage;
import com.paga.page.AddPathPage;
import com.paga.page.LinkCriteriaPage;
import com.paga.util.BaseTest;

import com.paga.util.PublicTest;

public class CompleteSubtasksTest extends BaseTest{	
	private MyWorkbenchPage myWorkbenchPage;
	
	
	@Test(description = "login")
	public void login(){
		PublicTest.login(driver,"wang","1111");		
	}
		
	@Test(dependsOnMethods = "login",description = "添加linkCriteria")
	public void linkCriteria() throws InterruptedException{  	
	    //点击subtasks in Process
		Thread.sleep(2000);
	    myWorkbenchPage = PageFactory.initElements(driver, MyWorkbenchPage.class);
//	    myWorkbenchPage.click_SubTasks_in_Process();
		//点击SubTasks in Process列表第一个
	    SubTasksInProcessPage subTasksInProcessPage = PageFactory.initElements(driver, SubTasksInProcessPage.class);
	    subTasksInProcessPage.click_SubTasks_in_Process_list_one();	    
	    //点击ADD DRUG  
	    LinkCriteriaPage linkCriteriaPage = PageFactory.initElements(driver, LinkCriteriaPage.class);
	    linkCriteriaPage.click_Add_DRUG();
	    //输入HICL编号
	    linkCriteriaPage.input_HICL("18");
	    Thread.sleep(1000);
	    //选择第一项
	    linkCriteriaPage.click_HICL_list();
	    //点击回车
	    linkCriteriaPage.enter_HICL();
	    //断言
	    Assert.assertEquals(linkCriteriaPage.get_HICL_list_Delete_text(),"Delete");	    
  		
	}
	
	@Test(dependsOnMethods = "linkCriteria",description = "添加addPath")
	public void addPath() throws InterruptedException{	    
	    //点击Add Path table
		TaskProfilePage taskProfilePage = PageFactory.initElements(driver, TaskProfilePage.class);
		taskProfilePage.click_AddPath();
		//点击Add Path
		AddPathPage addPathPage = PageFactory.initElements(driver, AddPathPage.class);
		addPathPage.click_Add_Path();
		//输入PathName
		addPathPage.input_PathName("pathName");
		//点击status
		addPathPage.click_status_select();
		//点选status第一项
		addPathPage.click_status_select_list();
		//点击Initial/Renewal
		addPathPage.click_Initial_Renewal_select();
		//点选Initial/Renewal第一项
		addPathPage.click_nitial_Renewal_select_list();
		//输入summary
		addPathPage.input_Summary("Summary");
		//输入Instructions
		addPathPage.input_Instructions("Instructions");
		//输入Approval Text
		addPathPage.input_Approval_Text("Approval_Text");
		//点击Add按钮
		addPathPage.click_Add_button();
		//点击OK
		addPathPage.click_OK_button();
		//定位Criteria下拉框
		addPathPage.click_Criteria_select();
		//点选Criteria第一项
		addPathPage.click_Criteria_select_list();
		//点击Condition下拉框
		addPathPage.click_Condition_select();
		//点选Condition第一项
		addPathPage.click_Condition_select_list();
		//输入Value
		addPathPage.input_Value("Value");
		//点击Save
		addPathPage.click_Save_button();
		//获取添加后的pathName text
//		String patnNameText = addPathPage.getPatnNameText();
//		Assert.assertEquals(patnNameText, "pathName");
		//点击Complete按钮
		addPathPage.click_Complete_button();
		Thread.sleep(1000);
		//输入Assigon to
		addPathPage.input_Assigon_to("wang");
		Thread.sleep(3000);
		//点击Assigon按钮
		addPathPage.click_Assigon_button();
		Thread.sleep(3000);
		//获取My_Workbench文本
		String My_Workbench = myWorkbenchPage.getMy_Workbench();
		Assert.assertEquals(My_Workbench, "My Workbench");
		
	}
}
