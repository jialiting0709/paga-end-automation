package com.paga.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyWorkbenchPage extends BasePage{

	public MyWorkbenchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//定位 SubTasks in Process 
	@FindBy(xpath="//mat-accordion/mat-expansion-panel[4]/mat-expansion-panel-header")
	private WebElement SubTasks_in_Process;
	
	//定位所有subtask name
	@FindBy(xpath="//app-my-sub-task-list/div/table/tbody/tr")
	private List<WebElement> subtask_names_tr;
	
	//定位My Workbench
	@FindBy(xpath="//app-my-workbench/app-header/mat-toolbar/h1")
	private WebElement My_Workbench_h1;
	
	//定位   SubTasks on the Review
	@FindBy(xpath="//app-my-task-home/div/mat-accordion/mat-expansion-panel[5]/mat-expansion-panel-header")
	private WebElement SubTasks_on_the_Review;
	
	//定位SubTasks on the Review列表中第一条
	@FindBy(xpath="//app-my-task-home/div/mat-accordion/mat-expansion-panel[5]/div/div/app-my-sub-task-list/div/table/tbody/tr/td")
	private WebElement SubTasks_on_the_Review_list_one;
	
	//定位My Workbench
	@FindBy(xpath="//h1")
	private WebElement My_Workbench;
	
	//定位 
	@FindBy(xpath="//app-my-task-home/div/mat-accordion/mat-expansion-panel[6]/mat-expansion-panel-header")
	private WebElement SubTasks_for_Deployed;
	
	//定位SubTasks on the Review列表中第一条
	@FindBy(xpath="//app-my-task-home/div/mat-accordion/mat-expansion-panel[6]/div/div/app-my-sub-task-list/div/table/tbody/tr/td")
	private WebElement SubTasks_for_Deployed_list_one;
	
	//定位 Tasks on the Review列表中第一条
	@FindBy(xpath="//app-my-task-home/div/mat-accordion/mat-expansion-panel[2]/div/div/app-my-task-list/div/table/tbody/tr/td")
	private WebElement Tasks_on_the_Review_list_one;
	
	//定位 Tasks for Deployed列表中第一条
	@FindBy(xpath="//app-my-task-home/div/mat-accordion/mat-expansion-panel[3]/div/div/app-my-task-list/div/table/tbody/tr/td")
	private WebElement  Tasks_for_Deployed_list_one;
	
	//定位  SubTasks in Process列表中第一条
	@FindBy(xpath="//app-my-task-home/div/mat-accordion/mat-expansion-panel[4]/div/div/app-my-sub-task-list/div/table/tbody/tr/td")
	private WebElement  SubTasks_in_Process_list_one;
	
	//点击SubTasks in Process列表中第一条
	public void click_SubTasks_in_Process_list_one(){
		this.click(SubTasks_in_Process_list_one);
	}	
	
	
	//点击Tasks for Deployed列表中第一条
	public void click_Tasks_for_Deployed_list_one(){
		this.click(Tasks_for_Deployed_list_one);
	}	
	
	//点击Tasks on the Review列表中第一条
	public void click_Tasks_on_the_Review_list_one(){
		this.click(Tasks_on_the_Review_list_one);
	}	
	
	//点击SubTasks on the Review列表中第一条
	public void click_SubTasks_for_Deployed_list_one(){
		this.click(SubTasks_for_Deployed_list_one);
	}	
		
	//点击 SubTasks for Deployed
	public void click_SubTasks_for_Deployed(){
		this.click(SubTasks_for_Deployed);
	}	
	
	//获取My_Workbench文本
	public String getMy_Workbench(){
		return My_Workbench.getText();
	}
	
	
	//点击列表中第一条
	public void click_SubTasks_on_the_Review_list_one(){
		this.click(SubTasks_on_the_Review_list_one);
	}	
	
	//点击 SubTasks on the Review
	public void click_SubTasks_on_the_Review(){
		this.click(SubTasks_on_the_Review);
	}	
	
	
	//获取My Workbench text
	public String getMy_Workbench_h1(){
		return My_Workbench_h1.getText();
	}
	
	//循环subtask_names
	public String subtask_names(String s){		
		int number = subtask_names_tr.size();		
		for(int i=1;i<=number;i++){
			String ele = driver.findElement(By.xpath("//app-my-sub-task-list/div/table/tbody/tr["+i+"]/td[1]")).getText();
			if(ele.equals(s)){
				return "1";
			}			
		}
		return "2";
	}
	
	//点击SubTasks in Process
	public void click_SubTasks_in_Process(){
		this.click(SubTasks_in_Process);
	}	
}
