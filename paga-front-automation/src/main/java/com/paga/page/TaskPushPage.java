package com.paga.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskPushPage extends BasePage{

	public TaskPushPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//app-comments/div/mat-form-field/div/div/div[2]/mat-icon")
	private WebElement comment;
	
	@FindBy(xpath="//textarea[@placeholder='Add Comment']")
	private WebElement comment_input;
	
	@FindBy(xpath="//app-comments/div/p/button")
	private WebElement comment_button;
	
	public void click_comment_button(){
		this.click(comment_button);
	}
	
	public void input_comment(String s){
		this.sendkeys(comment_input, s);
	}
	
	public void click_comment(){
		this.click(comment);
	}


}
