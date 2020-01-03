package com.paga.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskReviewPage extends BasePage{

	public TaskReviewPage(WebDriver driver) {
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
	
	//定位Assign to输入框
	@FindBy(xpath="//input[@placeholder='Assign to']")
	private WebElement Assign_to;
	
	//定位Assign按钮
	@FindBy(xpath="//app-assign-to-detail/div[2]/button[2]")
	private WebElement Assign_button;
	
	//定位Reject按钮
	@FindBy(xpath="//*[contains(text(),'Reject')]")
	private WebElement Reject_button;
	
	//点击Reject按钮
	public void click_Reject_button(){
		this.click(Reject_button);
	}
	
	
	//点击Assign按钮
	public void click_Assign_button(){
		this.click(Assign_button);
	}
	
	//输入Assign to
	public void input_Assign_to(String s){
		this.sendkeys(Assign_to, s);
	}
	
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
