package com.paga.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskDetailPage extends BasePage{

	public TaskDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	//定位task detail
	@FindBy(xpath="//mat-card-title/span[2]")
	private  WebElement card_title;
	
	//定位Edit按钮
	@FindBy(xpath="//app-task-information/p/button[1]")
	private WebElement detail_edit_button;
	
	//定位taskDescription
	@FindBy(xpath="//mat-form-field/div/div[1]/div[1]/textarea")
	private WebElement taskDescription;
	
	//定位保存按钮
	@FindBy(xpath="//app-task-information/p/button[2]")
	private WebElement detail_save_button;
	
	//定位taskDescription文本
	@FindBy(xpath="//mat-card-content/mat-list[1]/mat-list-item[1]/div/div[3]/span")
	private WebElement taskDescription_span;
	
	//定位Submit按钮
	@FindBy(xpath="//app-task-information/p/button[3]")
	private WebElement Submit;
	
	//定位返回按钮
	@FindBy(xpath="//mat-toolbar/mat-icon[1]")
	private WebElement arrow_back;
	
	//滚动条滚动到Submit
	public void scrollSubmit(){
		this.elementScroll(Submit);
	}
	
	//点击arrow_back按钮
	public void click_arrow_back(){
		this.click(arrow_back);
	}
	
	//点击Submit按钮
	public void click_Submit_button(){
		this.click(Submit);
	}
	
	//获取taskDescription文本
	public String getTaskDescription_span(){
		return taskDescription_span.getText();
	}
	
	
	//点击保存按钮
	public void click_detail_save_button(){
		this.click(detail_save_button);
	}	
	
	
	
	//输入taskDescription更改内容
	public void input_taskDescription(String s){
		this.sendkeys(taskDescription, s);
	}
	
	//点击编辑按钮
	public void click_detail_edit_button(){
		this.click(detail_edit_button);
	}	
	
	//获取文本
	public String getMat_card_title(){
		return card_title.getText();
	}
	

}
