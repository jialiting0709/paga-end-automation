package com.paga.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskPushPage extends BasePage{

	public TaskPushPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//定位comments按钮
	@FindBy(xpath="//app-comments/div/mat-form-field/div/div/div[2]/mat-icon")
	private WebElement comment;
	
	//定位comments输入框
	@FindBy(xpath="//textarea[@placeholder='Add Comment']")
	private WebElement comment_input;
	
	//定位Comlete按钮
	@FindBy(xpath="//app-comments/div/p/button")
	private WebElement comment_button;
	
	//点击Comlete按钮
	public void click_comment_button(){
		this.click(comment_button);
	}
	
	//输入comment
	public void input_comment(String s){
		this.sendkeys(comment_input, s);
	}
	
	//点击comment
	public void click_comment(){
		this.click(comment);
	}


}
