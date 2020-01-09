package com.medimpact.paga.front.automation.cases;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.medimpact.paga.front.automation.page.AddTaskPage;
import com.medimpact.paga.front.automation.page.AddTheClientDetailsPage;
import com.medimpact.paga.front.automation.page.AssignTheTaskPage;
import com.medimpact.paga.front.automation.page.ManagementPage;
import com.medimpact.paga.front.automation.page.SubTasksPage;
import com.medimpact.paga.front.automation.page.TaskDetailPage;
import com.medimpact.paga.front.automation.utils.DataUtils;

@SpringBootTest
public class CreateTaskTest extends BaseTest{
	
	private TaskDetailPage taskDetailPage;
	private SubTasksPage subTasksPage;
	private ManagementPage managementPage;
	
	@Autowired
    private CommonCase publicTest;
		
	
	@Test(description = "login")
	public void login(){
		publicTest.login(driver,"wang","1111","My Workbench");		
	}
		
	@Test(dependsOnMethods = {"login"},description = "Create tasks")
	public void createTask() throws InterruptedException{		
		managementPage = PageFactory.initElements(driver,ManagementPage.class);
		//click menu
		managementPage.click_Task_menu();
		Thread.sleep(1000);
		//click Task Management
		managementPage.clic_Task_Management();
		Thread.sleep(1000);
		//Click add task
		managementPage.click_Task_add_button();	
		Thread.sleep(1000);
		AddTaskPage addTaskPage = PageFactory.initElements(driver, AddTaskPage.class);
		//Click create or update drop-down list
		addTaskPage.click_create_update_select();
		//click create
		addTaskPage.click_select_create();
		//Enter task expiration time
		String dueDate = DataUtils.getStringDate(432000000L);
    	String effective = DataUtils.getStringDate(864000000L);
		addTaskPage.input_mat("10");
		//Click requested by drop-down box
		addTaskPage.click_requested_by();
		//click NA
		addTaskPage.click_NA();
//		//input sales Force Case Number
//		addTaskPage.input_sales_Force_Case_Number("123456");
		
		//input Requested Email
		addTaskPage.input_Requested_Email("123@qq.com");
		//inputtask Due
		addTaskPage.input_task_Due(dueDate);
		//click 
		//inputtask Description
		addTaskPage.input_task_Description("test a task_jia");
		//click Next
		addTaskPage.click_next_button();
		//click HQ header
		AddTheClientDetailsPage addTheClientDetailsPage = PageFactory.initElements(driver, AddTheClientDetailsPage.class);	
		addTheClientDetailsPage.click_HQ_header();
		//input
		addTheClientDetailsPage.input_HQ_header("H");
		//Select first
		addTheClientDetailsPage.clisk_MDT();
		
		//Click the HQ code search box
		addTheClientDetailsPage.click_HQ_code();
		//Select first
		addTheClientDetailsPage.click_mat_option_code();
		
		Actions actions = new Actions(driver);
	    actions.moveByOffset(0, 0).click().build().perform();
	    Thread.sleep(2000);
	    
		//Click guide set drop-down list
		addTheClientDetailsPage.click_Guideline_Set();
		Thread.sleep(1000);
		//Select first
		addTheClientDetailsPage.click_Guideline_Set_mat_option();
		//Click guideline code drop-down list
		addTheClientDetailsPage.click_Guideline_Code();
		//Select first
		addTheClientDetailsPage.click_Guideline_Code_mat_option();
		//input number Of Guidelines
		addTheClientDetailsPage.send_number_Of_Guidelines("1");
		//input effectiveDate
		addTheClientDetailsPage.send_effective_Date(effective);
		//click NEXT
		addTaskPage.click_next_button();
		//Design输入wang
		AssignTheTaskPage assignTheTaskPage = PageFactory.initElements(driver, AssignTheTaskPage.class);	
		assignTheTaskPage.input_Design("wang");
		Thread.sleep(2000);
		//Click Next
		assignTheTaskPage.click_Design_next();
		taskDetailPage = PageFactory.initElements(driver, TaskDetailPage.class);
		taskDetailPage.getMat_card_title();
		String text = taskDetailPage.getMat_card_title();
		Assert.assertEquals(text, "Init");		

	}
	
	@Test(dependsOnMethods = {"createTask"},description = "Editing task")
	public void editTask() throws InterruptedException{
		//click Edit
		taskDetailPage.click_detail_edit_button();
		//input taskDescription
		taskDetailPage.input_taskDescription("222");
		//Click save
		taskDetailPage.click_detail_save_button();
		String taskDetailPageText = taskDetailPage.getTaskDescription_span();
		Assert.assertEquals(taskDetailPageText, "222");			
		
	}
	
	//@Test(dependsOnMethods = {"editTask"},description = "Edit subtask")
	public void editSubTasks() throws InterruptedException{
		//Pull down scroll bar
		subTasksPage = PageFactory.initElements(driver, SubTasksPage.class);		
		subTasksPage.scroll();
		//Click the operation button
		subTasksPage.click_sub_mat_icon();
		//Click Edit
		subTasksPage.click_sub_edit();
		//Input for editing
		subTasksPage.input_sub_name("321");
		//Click the operation button
		subTasksPage.click_sub_mat_icon();
		//Click save
		subTasksPage.click_sub_save();
		Thread.sleep(2000);
		//Get the edited input
		String sub_name = subTasksPage.get_sub_name();
		Assert.assertEquals(sub_name, "321");		
	}
		
	@Test(dependsOnMethods = {"editTask"},description = "Submit subtasks")
	public void submitTask() throws InterruptedException{
		//Scroll bar to submit
		taskDetailPage.scrollSubmit();
		//click Submit
		taskDetailPage.click_Submit_button();	
	}
	
	@Test(dependsOnMethods = {"submitTask"},description = "Distribution sub process")
	public void assign_to() throws InterruptedException{	
		subTasksPage = PageFactory.initElements(driver, SubTasksPage.class);
		
		//Click the operation button
		subTasksPage.click_caozuo();
		//click Assign to
		subTasksPage.click_Assign_to();
		Thread.sleep(1000);
		//input Assign to
		subTasksPage.input_Assign_to("wang");
		Thread.sleep(1000);
		//click Assign
		subTasksPage.click_Assign_button();	
//		Thread.sleep(1000);
//		//Click the back button
//		taskDetailPage.click_arrow_back();		
//		//Click menu menu
//		managementPage.click_Task_menu();
//		//click My Workbench
//		managementPage.click_My_Workbench();
//		//click subtasks in Process
//		MyWorkbenchPage myWorkbenchPage = PageFactory.initElements(driver, MyWorkbenchPage.class);
//		myWorkbenchPage.click_SubTasks_in_Process();
//		String result = myWorkbenchPage.subtask_names("321");
//		Assert.assertEquals(result, "1");
	}
	
}
	
	
