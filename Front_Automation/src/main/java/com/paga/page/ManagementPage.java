package com.paga.page;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManagementPage extends BasePage{

	public ManagementPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//定位menu菜单
	@FindBy(xpath="//button[1]/span[1]/mat-icon[1]")
	private WebElement Task_menu;
	
	//定位Task Management
	@FindBy(xpath="//*[contains(text(),'Task Management')]")
	private WebElement Task_Management;
	
	//定位Task Management
	@FindBy(xpath="//body/div[2]/div[2]/div/div/div/button")
	private WebElement My_Workbench;
	
	
	
//	//定位Task Management
//	@FindBy(xpath="//mat-panel-title")
//	private List<WebElement> lsit;
//	
//	public Boolean list(){
//		System.out.println("============="+lsit.size());
//		for(WebElement ele:lsit){
//			if(ele.getText().equals("SubTasks for Deployed")){
//				return true;
//			}
//			System.out.println(ele.getText());
//		}
//		return false;
//	}
//	
	
	
	//点击My Workbench
	public void click_My_Workbench(){
		this.click(My_Workbench);
	}
		
	//定位添加按钮
	@FindBy(xpath="//mat-toolbar/button[2]/span/mat-icon")
	private WebElement Task_add_button;
	
	
	//点击menu菜单
	public void click_Task_menu(){
		this.click(Task_menu);
	}
	
	//点击Task Management
	public void clic_Task_Management(){
		this.click(Task_Management);
	}
	
	//点击添加按钮
	public void click_Task_add_button(){
		this.click(Task_add_button);
	}
	
	
	
	
}
