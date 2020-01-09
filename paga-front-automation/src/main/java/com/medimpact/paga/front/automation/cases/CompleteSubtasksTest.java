package com.medimpact.paga.front.automation.cases;

import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.medimpact.paga.front.automation.page.AddPathPage;
import com.medimpact.paga.front.automation.page.LinkCriteriaPage;
import com.medimpact.paga.front.automation.page.MyWorkbenchPage;
import com.medimpact.paga.front.automation.page.SubTasksInProcessPage;
import com.medimpact.paga.front.automation.page.TaskProfilePage;
import com.medimpact.paga.front.automation.utils.BaseTest;
import com.medimpact.paga.front.automation.utils.ReuseCase;

@SpringBootTest
public class CompleteSubtasksTest extends BaseTest{	
	private MyWorkbenchPage myWorkbenchPage;
	
	@Autowired
    private ReuseCase publicTest;
	
	
	@Test(description = "login")
	public void login(){
		publicTest.login(driver,"wang","1111","My Workbench");		
	}
		
	@Test(dependsOnMethods = "login",description = "Save linkCriteria")
	public void linkCriteria() throws InterruptedException{  	
	    //click subtasks in Process
		Thread.sleep(2000);
	    myWorkbenchPage = PageFactory.initElements(driver, MyWorkbenchPage.class);
		//click SubTasks in Process list one
	    SubTasksInProcessPage subTasksInProcessPage = PageFactory.initElements(driver, SubTasksInProcessPage.class);
	    subTasksInProcessPage.click_SubTasks_in_Process_list_one();	    
	    //click ADD DRUG  
	    LinkCriteriaPage linkCriteriaPage = PageFactory.initElements(driver, LinkCriteriaPage.class);
	    linkCriteriaPage.click_Add_DRUG();
	    //input HICLcode
	    linkCriteriaPage.input_HICL("18");
	    Thread.sleep(1000);
	    //Select first
	    linkCriteriaPage.click_HICL_list();
	    //Click enter
	    linkCriteriaPage.enter_HICL();
	    Assert.assertEquals(linkCriteriaPage.get_HICL_list_Delete_text(),"Delete");	    
  		
	}
	
	@Test(dependsOnMethods = "linkCriteria",description = "save addPath")
	public void addPath() throws InterruptedException{	    
	    //click Add Path table
		TaskProfilePage taskProfilePage = PageFactory.initElements(driver, TaskProfilePage.class);
		taskProfilePage.click_AddPath();
		//click Add Path
		AddPathPage addPathPage = PageFactory.initElements(driver, AddPathPage.class);
		addPathPage.click_Add_Path();
		Thread.sleep(2000);
		//input PathName
		addPathPage.input_PathName("pathName");
		//click status
		addPathPage.click_status_select();
		//Click the first item of status
		addPathPage.click_status_select_list();
		//click Initial/Renewal
		addPathPage.click_Initial_Renewal_select();
		//Click the first item of initial / Renewal
		addPathPage.click_nitial_Renewal_select_list();
		//input summary
		addPathPage.input_Summary("Summary");
		//input Instructions
		addPathPage.input_Instructions("Instructions");
		//input Approval Text
		addPathPage.input_Approval_Text("Approval_Text");
		//click Addbutton
		addPathPage.click_Add_button();
		//click OK
		addPathPage.click_OK_button();
		//Locate the criteria drop-down box
		addPathPage.click_Criteria_select();
		//Click on the first item of criteria
		addPathPage.click_Criteria_select_list();
		//Click the condition drop-down box
		addPathPage.click_Condition_select();
		//Click condition first
		addPathPage.click_Condition_select_list();
		//input Value
		addPathPage.input_Value("Value");
		//click Save
		addPathPage.click_Save_button();
		//input Guideline Name
		addPathPage.input_Guideline_Name("22");
		//click Guideline Type
		addPathPage.click_Guideline_Type_sele();
		Thread.sleep(1000);
		//Click the first item of the dropdown
		addPathPage.click_Guideline_Type_sele_one();
		//Click the complete button
		addPathPage.click_Complete_button();
		Thread.sleep(1000);
		//input Assigon to
		addPathPage.input_Assigon_to("wang");
		Thread.sleep(3000);
		//click Assigonbutton
		addPathPage.click_Assigon_button();
		Thread.sleep(3000);
		String My_Workbench = myWorkbenchPage.getMy_Workbench();
		Assert.assertEquals(My_Workbench, "My Workbench");
		
	}
}
