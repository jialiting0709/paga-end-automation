package com.medimpact.paga.front.automation.cases;

import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.medimpact.paga.front.automation.page.MyWorkbenchPage;
import com.medimpact.paga.front.automation.page.TaskReviewPage;
import com.medimpact.paga.front.automation.utils.BaseTest;
import com.medimpact.paga.front.automation.utils.ReuseCase;
@SpringBootTest
public class RejectTaskOnReviewTest extends BaseTest{
	private MyWorkbenchPage myWorkbenchPage;
	
	@Autowired
    private ReuseCase publicTest;
	
	@Test(description = "login")
	public void login(){
		publicTest.login(driver,"wang","1111","My Workbench");			
	}
	
	@Test(dependsOnMethods = "login",description = "退回主任务")
	public void rejectTaskOnReview() throws InterruptedException{
		myWorkbenchPage = PageFactory.initElements(driver,MyWorkbenchPage.class);
		//点击Tasks on the Review列表第一个
		myWorkbenchPage.click_Tasks_on_the_Review_list_one();
		//点击comments操作按钮
		TaskReviewPage taskReviewPage = PageFactory.initElements(driver,TaskReviewPage.class);
		taskReviewPage.click_comment();
		//输入comments
		taskReviewPage.input_comment("task Review Reject");
		//点击Reject按钮
		taskReviewPage.click_Reject_button();
		Thread.sleep(3000);
		//获取My_Workbench文本
		String My_Workbench = myWorkbenchPage.getMy_Workbench();
		Assert.assertEquals(My_Workbench, "My Workbench");				
		
	}
}
