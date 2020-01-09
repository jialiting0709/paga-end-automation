package com.medimpact.paga.front.automation.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class MyWorkbenchPage extends BasePage{

	public MyWorkbenchPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//mat-accordion/mat-expansion-panel[4]/mat-expansion-panel-header")
	private WebElement SubTasks_in_Process;
	
	@FindBy(xpath="//app-my-sub-task-list/div/table/tbody/tr")
	private List<WebElement> subtask_names_tr;
	
	@FindBy(xpath="//app-my-workbench/app-header/mat-toolbar/h1")
	private WebElement My_Workbench_h1;
	
	@FindBy(xpath="//app-my-task-home/div/mat-accordion/mat-expansion-panel[5]/mat-expansion-panel-header")
	private WebElement SubTasks_on_the_Review;
	
	@FindBy(xpath="//app-my-task-home/div/mat-accordion/mat-expansion-panel[5]/div/div/app-my-sub-task-list/div/table/tbody/tr/td")
	private WebElement SubTasks_on_the_Review_list_one;
	
	@FindBy(xpath="//h1")
	private WebElement My_Workbench;
	
	@FindBy(xpath="//app-my-task-home/div/mat-accordion/mat-expansion-panel[6]/mat-expansion-panel-header")
	private WebElement SubTasks_for_Deployed;
	
	@FindBy(xpath="//app-my-task-home/div/mat-accordion/mat-expansion-panel[6]/div/div/app-my-sub-task-list/div/table/tbody/tr/td")
	private WebElement SubTasks_for_Deployed_list_one;
	
	@FindBy(xpath="//app-my-task-home/div/mat-accordion/mat-expansion-panel[2]/div/div/app-my-task-list/div/table/tbody/tr/td")
	private WebElement Tasks_on_the_Review_list_one;
	
	@FindBy(xpath="//app-my-task-home/div/mat-accordion/mat-expansion-panel[3]/div/div/app-my-task-list/div/table/tbody/tr/td")
	private WebElement  Tasks_for_Deployed_list_one;
	
	@FindBy(xpath="//app-my-task-home/div/mat-accordion/mat-expansion-panel[4]/div/div/app-my-sub-task-list/div/table/tbody/tr/td")
	private WebElement  SubTasks_in_Process_list_one;
	
	public void click_SubTasks_in_Process_list_one(){
		this.click(SubTasks_in_Process_list_one);
	}	
	
	
	public void click_Tasks_for_Deployed_list_one(){
		this.click(Tasks_for_Deployed_list_one);
	}	
	
	public void click_Tasks_on_the_Review_list_one(){
		this.click(Tasks_on_the_Review_list_one);
	}	
	
	public void click_SubTasks_for_Deployed_list_one(){
		this.click(SubTasks_for_Deployed_list_one);
	}	
		
	public void click_SubTasks_for_Deployed(){
		this.click(SubTasks_for_Deployed);
	}	
	
	public String getMy_Workbench(){
		return My_Workbench.getText();
	}
	
	public void click_SubTasks_on_the_Review_list_one(){
		this.click(SubTasks_on_the_Review_list_one);
	}	
	
	public void click_SubTasks_on_the_Review(){
		this.click(SubTasks_on_the_Review);
	}	
	
	public String getMy_Workbench_h1(){
		return My_Workbench_h1.getText();
	}
	
	//Loop subtask_Names
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
	
	public void click_SubTasks_in_Process(){
		this.click(SubTasks_in_Process);
	}	
}
