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
