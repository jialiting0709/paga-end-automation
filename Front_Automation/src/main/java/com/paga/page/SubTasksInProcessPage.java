package com.paga.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubTasksInProcessPage extends BasePage{

	public SubTasksInProcessPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//定位SubTasks in Process列表第一个
	@FindBy(xpath="//app-my-sub-task-list/div/table/tbody/tr[1]/td")
	private WebElement SubTasks_in_Process_list_one;
	
	//点击SubTasks in Process列表第一个
	public void click_SubTasks_in_Process_list_one(){
		this.click(SubTasks_in_Process_list_one);
	}
	
	

}

 