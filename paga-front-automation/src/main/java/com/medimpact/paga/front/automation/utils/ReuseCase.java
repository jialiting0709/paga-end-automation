package com.medimpact.paga.front.automation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.testng.Assert;

import com.medimpact.paga.front.automation.page.LoginPage;
import com.medimpact.paga.front.automation.page.MyWorkbenchPage;
import com.medimpact.paga.front.automation.page.PushPage;
import com.medimpact.paga.front.automation.page.SubTaskReviewPage;

@Component
public class ReuseCase {
	
	@Value("${webUrl}")
	private String webUrl;
	
	public void login(WebDriver driver,String userName,String userPassword,String expected){
		driver.get(webUrl);
		//input User Name
		LoginPage loginPage = PageFactory.initElements(driver,LoginPage.class);
		loginPage.input_userName(userName);
		//input userPassword
		loginPage.input_userPassword(userPassword);
		//click login
		loginPage.click_Log_in();
		//Assert successful login
		MyWorkbenchPage myWorkbenchPage = PageFactory.initElements(driver,MyWorkbenchPage.class);
		String My_Workbench = myWorkbenchPage.getMy_Workbench_h1();
		Assert.assertEquals(My_Workbench, expected);
	}
	
	public void approveSubTaskReview(WebDriver driver,String comment,String Assign_to,String expected) throws InterruptedException{
		//Click the first item in the list
		MyWorkbenchPage myWorkbenchPage = PageFactory.initElements(driver,MyWorkbenchPage.class);
		myWorkbenchPage.click_SubTasks_on_the_Review_list_one();
		//Click the path list drop-down box
		SubTaskReviewPage subTaskReviewPage = PageFactory.initElements(driver,SubTaskReviewPage.class);
		subTaskReviewPage.click_Path_List();
		//Click the operation button
		subTaskReviewPage.click_more_vert();
		//click Preview
		subTaskReviewPage.click_Preview();
		//Click blank
		Actions actions = new Actions(driver);
	    actions.moveByOffset(0, 0).click().build().perform();		
		//click mode_edit button
	    subTaskReviewPage.click_mode_edit();
	    //input comment
	    subTaskReviewPage.input_add_comment(comment);
	    //click Complete
	    subTaskReviewPage.click_Complete();
	    Thread.sleep(1000);
	    //input Assign to
	    subTaskReviewPage.input_Assign_to(Assign_to);
	    //click Assign
	    subTaskReviewPage.click_Assign();
	    Thread.sleep(2000);
	    String My_Workbench = myWorkbenchPage.getMy_Workbench();
		Assert.assertEquals(My_Workbench, expected);
	}
	
	public void approveSubTaskDeployed(WebDriver driver,String comment,String expected) throws InterruptedException{
		MyWorkbenchPage myWorkbenchPage = PageFactory.initElements(driver,MyWorkbenchPage.class);
		myWorkbenchPage.click_SubTasks_for_Deployed_list_one();
		//click comments button 
		PushPage pushPage= PageFactory.initElements(driver,PushPage.class);
		pushPage.click_comment();
		//input comments
		pushPage.input_comment(comment);
		//click Comlete
		pushPage.click_comment_button();
		//input date
		pushPage.input_data_input(DataUtils.getStringDate(1L));
		//click OK
		pushPage.click_ok_button();
		Thread.sleep(3000);
		String My_Workbench = myWorkbenchPage.getMy_Workbench();
		Assert.assertEquals(My_Workbench, expected);	
	}	
	
}
