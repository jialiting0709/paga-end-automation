package com.paga.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddTaskPage extends BasePage{

	public AddTaskPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//定位创建或更新下拉列表
	@FindBy(xpath="//*[@id='mat-select-1']/div/div[2]")
	private WebElement select_create_update;
	
	//定位create  
	@FindBy(xpath="//body/div[2]/div[2]/div/div/div/mat-option")
	private WebElement select_create;
	
	//定位时间input
	@FindBy(xpath="//app-add-task/div/form/p/mat-form-field[2]/div/div/div[3]/input")
	private WebElement mat_input;
	
	//定位task Description输入框
	@FindBy(xpath="//form/p[4]/mat-form-field/div/div/div[3]/input")
	private WebElement task_Description_input;
	
	//定位sales Force Case Number
	@FindBy(xpath="//form/p[4]/mat-form-field/div/div/div[3]/input")
	private WebElement sales_Force_Case_Number_input;
	
	//定位NEXT按钮
	@FindBy(xpath="//app-add-task-step/mat-toolbar/button[2]")
	private WebElement next_button;
	
	//定位requested by下拉框
	@FindBy(xpath="//form/p[2]/mat-form-field/div/div/div[3]/mat-select/div/div[2]/div")
	private WebElement requested_by;
	
	//定位N/A
	@FindBy(xpath="//*[contains(text(),'N/A')]")
	private WebElement NA;
	
	//定位Requested Email 
	@FindBy(xpath="//form/p[2]/mat-form-field[2]/div/div/div[3]/input")
	private WebElement Requested_Email;
	
	//定位task Due
	@FindBy(xpath="//form/p[3]/mat-form-field/div/div/div[3]/input")
	private WebElement task_Due;
	
	//输入task Due
	public void input_task_Due(String input){
		this.sendkeys(task_Due, input);
	}
	
	
	//输入Requested Email
	public void input_Requested_Email(String input){
		this.sendkeys(Requested_Email, input);
	}
	
	
	//点击N/A下拉框
	public void click_NA(){
		this.click(NA);
	}
	
	//点击requested by下拉框
	public void click_requested_by(){
		this.click(requested_by);
	}
	
	//点击NEXT按钮
	public void click_next_button(){
		this.click(next_button);
	}
	
	//输入sales Force Case Number内容
	public void input_sales_Force_Case_Number(String input){
		this.sendkeys(sales_Force_Case_Number_input,input);
	}
	
	
	//输入task Description内容
	public void input_task_Description(String input){
		this.sendkeys(task_Description_input, input);
	}
	
	//输入时间input
	public void input_mat(String input){
		this.sendkeys(mat_input, input);
	}
	
	//点击create
	public void click_select_create(){
		this.click(select_create);
	}
		
	//点击创建或更新下拉列表
	public void click_create_update_select(){
		this.click(select_create_update);
	}
		
}
