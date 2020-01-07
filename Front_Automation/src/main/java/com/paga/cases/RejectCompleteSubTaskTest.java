package com.paga.cases;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.paga.page.AddPathPage;
import com.paga.page.MyWorkbenchPage;

import com.paga.util.BaseTest;
import com.paga.util.PublicTest;

public class RejectCompleteSubTaskTest extends BaseTest {
	private MyWorkbenchPage myWorkbenchPage;
	
	@Test(description = "login")
	public void login(){
		PublicTest.login(driver,"wang","1111","My Workbench");		
	}
	
	@Test(dependsOnMethods = "login",description = "Submit returned subtasks")
	public void rejectCompleteSubTaskToReview() throws InterruptedException{  	
	    //click SubTasks in Process list one
		myWorkbenchPage = PageFactory.initElements(driver, MyWorkbenchPage.class);
		myWorkbenchPage.click_SubTasks_in_Process_list_one();
		//click Complete button
		AddPathPage addPathPage = PageFactory.initElements(driver, AddPathPage.class);
		addPathPage.click_Complete_button();
		Thread.sleep(1000);
		//input Assigon to
		addPathPage.input_Assigon_to("wang");
		Thread.sleep(3000);
		//click Assigon button
		addPathPage.click_Assigon_button();
		Thread.sleep(3000);
		String My_Workbench = myWorkbenchPage.getMy_Workbench();
		Assert.assertEquals(My_Workbench, "My Workbench");
  		
	}
}
