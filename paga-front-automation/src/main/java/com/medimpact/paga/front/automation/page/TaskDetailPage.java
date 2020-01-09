package com.medimpact.paga.front.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskDetailPage extends BasePage{

	public TaskDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//mat-card-title/span[2]")
	private  WebElement card_title;
	
	@FindBy(xpath="//app-task-information/p/button[1]")
	private WebElement detail_edit_button;
	
	@FindBy(xpath="//mat-form-field/div/div[1]/div[1]/textarea")
	private WebElement taskDescription;
	
	@FindBy(xpath="//app-task-information/p/button[2]")
	private WebElement detail_save_button;

	@FindBy(xpath="//mat-card-content/mat-list[1]/mat-list-item[1]/div/div[3]/span")
	private WebElement taskDescription_span;
	
	@FindBy(xpath="//app-task-information/p/button[3]")
	private WebElement Submit;
	
	@FindBy(xpath="//mat-toolbar/mat-icon[1]")
	private WebElement arrow_back;
	
	public void scrollSubmit(){
		this.elementScroll(Submit);
	}
	
	public void click_arrow_back(){
		this.click(arrow_back);
	}
	
	public void click_Submit_button(){
		this.click(Submit);
	}
	
	public String getTaskDescription_span(){
		return taskDescription_span.getText();
	}
	
	public void click_detail_save_button(){
		this.click(detail_save_button);
	}	
	
	public void input_taskDescription(String s){
		this.sendkeys(taskDescription, s);
	}
	
	public void click_detail_edit_button(){
		this.click(detail_edit_button);
	}	
	
	public String getMat_card_title(){
		return card_title.getText();
	}
	

}
