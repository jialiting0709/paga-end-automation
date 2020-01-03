package com.paga.cases;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.page.AddTaskPage;
import com.paga.page.AddTheClientDetailsPage;
import com.paga.page.AssignTheTaskPage;

import com.paga.page.ManagementPage;

import com.paga.page.SubTasksPage;
import com.paga.page.TaskDetailPage;
import com.paga.util.BaseTest;

import com.paga.util.PublicFunction;
import com.paga.util.PublicTest;

public class CreateTaskTest extends BaseTest{
	
	private TaskDetailPage taskDetailPage;
	private SubTasksPage subTasksPage;
	private ManagementPage managementPage;
	
	
	@Test(description = "login")
	public void login(){
		PublicTest.login(driver,"wang","1111");		
	}
		
	@Test(dependsOnMethods = {"login"},description = "创建任务")
	public void createTask() throws InterruptedException{		
		//初始化页面
		managementPage = PageFactory.initElements(driver,ManagementPage.class);
		//点击menu菜单
		managementPage.click_Task_menu();
		Thread.sleep(1000);
		//点击Task Management
		managementPage.clic_Task_Management();
		Thread.sleep(1000);
		//点击添加task
		managementPage.click_Task_add_button();	
		Thread.sleep(1000);
		AddTaskPage addTaskPage = PageFactory.initElements(driver, AddTaskPage.class);
		//点击创建或更新下拉列表
		addTaskPage.click_create_update_select();
		//点击create
		addTaskPage.click_select_create();
		//输入任务过期时间
		String dueDate = PublicFunction.getStringDate(432000000L);
    	String effective = PublicFunction.getStringDate(864000000L);
		addTaskPage.input_mat("10");
		//点击requested by下拉框
		addTaskPage.click_requested_by();
		//点击NA
		addTaskPage.click_NA();
//		//输入sales Force Case Number内容
//		addTaskPage.input_sales_Force_Case_Number("123456");
		
		//输入Requested Email内容
		addTaskPage.input_Requested_Email("123@qq.com");
		//输入task Due
		addTaskPage.input_task_Due(dueDate);
		//输入task Description内容
		addTaskPage.input_task_Description("test a task_jia");
		//点击Next
		addTaskPage.click_next_button();
		//点击HQ header搜索按钮
		AddTheClientDetailsPage addTheClientDetailsPage = PageFactory.initElements(driver, AddTheClientDetailsPage.class);	
		addTheClientDetailsPage.click_HQ_header();
		//输入
		addTheClientDetailsPage.input_HQ_header("H");
		//选择第一项
		addTheClientDetailsPage.clisk_MDT();
		
		//点击HQ code搜索框
		addTheClientDetailsPage.click_HQ_code();
		//选择第一项
		addTheClientDetailsPage.click_mat_option_code();
		
		Actions actions = new Actions(driver);
	    actions.moveByOffset(0, 0).click().build().perform();
	    
		//点击Guideline Set下拉列表
		addTheClientDetailsPage.click_Guideline_Set();
		Thread.sleep(1000);
		//选择第一项
		addTheClientDetailsPage.click_Guideline_Set_mat_option();
		//点击Guideline Code下拉列表
		addTheClientDetailsPage.click_Guideline_Code();
		//选择第一项
		addTheClientDetailsPage.click_Guideline_Code_mat_option();
		//输入number Of Guidelines
		addTheClientDetailsPage.send_number_Of_Guidelines("1");
		//输入effectiveDate
		addTheClientDetailsPage.send_effective_Date(effective);
		//点击NEXT
		addTaskPage.click_next_button();
		//Design输入wang
		AssignTheTaskPage assignTheTaskPage = PageFactory.initElements(driver, AssignTheTaskPage.class);	
		assignTheTaskPage.input_Design("wang");
		Thread.sleep(2000);
		//点击Design列表第一项		
//		assignTheTaskPage.click_Design_list();	
		//点击下一个
		assignTheTaskPage.click_Design_next();
		//获取任务详情页文本
		taskDetailPage = PageFactory.initElements(driver, TaskDetailPage.class);
		taskDetailPage.getMat_card_title();
		String text = taskDetailPage.getMat_card_title();
		Assert.assertEquals(text, "Init");		

	}
	
	@Test(dependsOnMethods = {"createTask"},description = "编辑任务")
	public void editTask() throws InterruptedException{
		//点击Edit
		taskDetailPage.click_detail_edit_button();
		//输入taskDescription更改内容
		taskDetailPage.input_taskDescription("222");
		//点击保存
		taskDetailPage.click_detail_save_button();
		//断言taskDescription是否更改
		String taskDetailPageText = taskDetailPage.getTaskDescription_span();
		Assert.assertEquals(taskDetailPageText, "222");			
		
	}
	
	//@Test(dependsOnMethods = {"editTask"},description = "编辑子任务")
	public void editSubTasks() throws InterruptedException{
		//下拉滚动条
		subTasksPage = PageFactory.initElements(driver, SubTasksPage.class);		
		subTasksPage.scroll();
		//点击操作按钮
		subTasksPage.click_sub_mat_icon();
		//点击编辑
		subTasksPage.click_sub_edit();
		//输入编辑的input
		subTasksPage.input_sub_name("321");
		//点击操作按钮
		subTasksPage.click_sub_mat_icon();
		//点击保存
		subTasksPage.click_sub_save();
		Thread.sleep(2000);
		//获取编辑后的input
		String sub_name = subTasksPage.get_sub_name();
		//断言编辑是否成功
		Assert.assertEquals(sub_name, "321");		
	}
		
	@Test(dependsOnMethods = {"editTask"},description = "提交任务")
	public void submitTask() throws InterruptedException{
		//滚动条滚动到Submit
		taskDetailPage.scrollSubmit();
		//点击Submit
		taskDetailPage.click_Submit_button();	
	}
	
	@Test(dependsOnMethods = {"submitTask"},description = "分配子流程")
	public void assign_to() throws InterruptedException{	
		subTasksPage = PageFactory.initElements(driver, SubTasksPage.class);
		//点击操作按钮
//		subTasksPage.click_sub_mat_icon();		
		//点击assign to me按钮
//		subTasksPage.click_assign_to_me();
		
		//点击操作按钮
		subTasksPage.click_caozuo();
		//点击Assign to
		subTasksPage.click_Assign_to();
		Thread.sleep(1000);
		//输入Assign to
		subTasksPage.input_Assign_to("wang");
		Thread.sleep(1000);
		//点击Assign
		subTasksPage.click_Assign_button();	
//		Thread.sleep(1000);
//		//点击返回按钮
//		taskDetailPage.click_arrow_back();		
//		//点击menu菜单
//		managementPage.click_Task_menu();
//		//点击My Workbench
//		managementPage.click_My_Workbench();
//		//点击subtasks in Process
//		MyWorkbenchPage myWorkbenchPage = PageFactory.initElements(driver, MyWorkbenchPage.class);
//		myWorkbenchPage.click_SubTasks_in_Process();
//		String result = myWorkbenchPage.subtask_names("321");
//		Assert.assertEquals(result, "1");
	}
	
}
	
	
