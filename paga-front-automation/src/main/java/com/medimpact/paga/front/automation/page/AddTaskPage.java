package com.medimpact.paga.front.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddTaskPage extends BasePage{

	public AddTaskPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//*[@id='mat-select-1']/div/div[2]")
	private WebElement select_create_update;
	
	@FindBy(xpath="//body/div[2]/div[2]/div/div/div/mat-option")
	private WebElement select_create;
	
	@FindBy(xpath="//app-add-task/div/form/p/mat-form-field[2]/div/div/div[3]/input")
	private WebElement mat_input;
	
	@FindBy(xpath="//form/p[4]/mat-form-field/div/div/div[3]/input")
	private WebElement task_Description_input;
	
	@FindBy(xpath="//form/p[4]/mat-form-field/div/div/div[3]/input")
	private WebElement sales_Force_Case_Number_input;
	
	@FindBy(xpath="//app-add-task-step/mat-toolbar/button[2]")
	private WebElement next_button;
	
	@FindBy(xpath="//form/p[2]/mat-form-field/div/div/div[3]/mat-select/div/div[2]/div")
	private WebElement requested_by;
	
	@FindBy(xpath="//*[contains(text(),'N/A')]")
	private WebElement NA;
	
	@FindBy(xpath="//form/p[2]/mat-form-field[2]/div/div/div[3]/input")
	private WebElement Requested_Email;
	
	@FindBy(xpath="//form/p[3]/mat-form-field/div/div/div[3]/input")
	private WebElement task_Due;
	
	@FindBy(xpath="")
	private WebElement sales_Force_Case_Number;
	
	public void input_task_Due(String input){
		this.sendkeys(task_Due, input);
	}
	
	public void input_Requested_Email(String input){
		this.sendkeys(Requested_Email, input);
	}
	
	
	public void click_NA(){
		this.click(NA);
	}
	
	public void click_requested_by(){
		this.click(requested_by);
	}
	
	public void click_next_button(){
		this.click(next_button);
	}
	
	public void input_sales_Force_Case_Number(String input){
		this.sendkeys(sales_Force_Case_Number_input,input);
	}
	
	public void input_task_Description(String input){
		this.sendkeys(task_Description_input, input);
	}
	
	public void input_mat(String input){
		this.sendkeys(mat_input, input);
	}
	
	public void click_select_create(){
		this.click(select_create);
	}
		
	public void click_create_update_select(){
		this.click(select_create_update);
	}
		
}
