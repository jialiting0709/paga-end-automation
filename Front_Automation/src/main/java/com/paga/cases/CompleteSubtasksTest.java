package com.paga.cases;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.page.LoginPage;
import com.paga.page.MyWorkbenchPage;
import com.paga.page.PathDetailPage;
import com.paga.page.SubTasksInProcessPage;
import com.paga.page.TaskProfilePage;
import com.paga.util.BaseTest;
import com.paga.util.Config;

public class CompleteSubtasksTest extends BaseTest{	
	private TaskProfilePage taskProfilePage;
	
	
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
		MyWorkbenchPage myWorkbenchPage = PageFactory.initElements(driver,MyWorkbenchPage.class);
		String My_Workbench = myWorkbenchPage.getMy_Workbench_h1();
		Assert.assertEquals(My_Workbench, "My Workbench");
	}
		
	@Test(dependsOnMethods = "login",description = "添加linkCriteria")
	public void linkCriteria() throws InterruptedException{  	
	    //点击subtasks in Process
	    MyWorkbenchPage myWorkbenchPage = PageFactory.initElements(driver, MyWorkbenchPage.class);
	    myWorkbenchPage.click_SubTasks_in_Process();
		//点击SubTasks in Process列表第一个
	    SubTasksInProcessPage subTasksInProcessPage = PageFactory.initElements(driver, SubTasksInProcessPage.class);
	    subTasksInProcessPage.click_SubTasks_in_Process_list_one();
	    //输入Guideline Name
	    taskProfilePage = PageFactory.initElements(driver, TaskProfilePage.class);
	    taskProfilePage.input_Guideline_Name("baodan");
	    //点击Guideline Type按钮
	    taskProfilePage.click_Guideline_Type();
	    //点击Guideline Type下拉第一项
	    taskProfilePage.click_Guideline_Type_span();
	    //点击Assign To按钮
	    taskProfilePage.click_Assign_To();
	    //点击Assign To列表第一项
	    taskProfilePage.click_Assign_To_span();
  		
	}
	
	@Test(dependsOnMethods = "linkCriteria",description = "添加addPath")
	public void addPath(){	    
	    //点击Add Path
	    taskProfilePage.click_Add_Path();
	    //点击AddPath按钮
	    taskProfilePage.click_Add_Path_button();
	    //输入Path_Name
	    PathDetailPage pathDetailPage = PageFactory.initElements(driver, PathDetailPage.class);
	    pathDetailPage.input_Path_Name("papa");
	    //点击Status下拉列表
	    pathDetailPage.click_status();
	    //点击Status下拉列表第一项
	    pathDetailPage.click_status_list_one();
	    //点击Initial/Renewal
	    pathDetailPage.click_Initial_Renewal();
	    //点击Initial/Renewal下拉列表第一项
	    pathDetailPage.click_status_list_one();
	    //输入summary input
	    pathDetailPage.input_summary("sad dasd dasd dad");
	    //点击save 
	    pathDetailPage.click_save();
	    
	}
}
