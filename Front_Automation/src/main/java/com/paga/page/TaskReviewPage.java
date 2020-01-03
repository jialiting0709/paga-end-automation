package com.paga.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskReviewPage extends BasePage{

	public TaskReviewPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//app-comments/div/mat-form-field/div/div/div[2]/mat-icon")
	private WebElement comment;
	
	@FindBy(xpath="//textarea[@placeholder='Add Comment']")
	private WebElement comment_input;
	
	@FindBy(xpath="//app-comments/div/p/button")
	private WebElement comment_button;
	
	@FindBy(xpath="//input[@placeholder='Assign to']")
	private WebElement Assign_to;
	
	@FindBy(xpath="//app-assign-to-detail/div[2]/button[2]")
	private WebElement Assign_button;
	
	@FindBy(xpath="//*[contains(text(),'Reject')]")
	private WebElement Reject_button;
	
	public void click_Reject_button(){
		this.click(Reject_button);
	}
	

	public void click_Assign_button(){
		this.click(Assign_button);
	}
	

	public void input_Assign_to(String s){
		this.sendkeys(Assign_to, s);
	}
	

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
