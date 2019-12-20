package com.paga.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class AssignTheTaskPage extends BasePage{

	public AssignTheTaskPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//定位Design输入框
	@FindBy(xpath="//*[@ng-reflect-name='design']")
	private WebElement Design;
	
	//定位Design列表第一项
	@FindBy(xpath="/html/body/div[1]/div/div/div/mat-option[1]/span")
	private WebElement Design_list;	
		
	//定位NEXT
	@FindBy(xpath="//app-add-task-step/mat-toolbar/button[2]")
	private WebElement Design_button;
	
	//点击NEXT
	public void click_Design_next(){
		this.click(Design_button);
	}
	
	//点击Design列表第一项
	public void click_Design_list(){
		this.click(Design_list);
	}	
	
	//点击Design输入框
	public void click_Design(){
		this.click(Design);
	}
	
}
