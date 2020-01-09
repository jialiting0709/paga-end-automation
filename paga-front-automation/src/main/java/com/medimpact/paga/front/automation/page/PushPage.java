package com.medimpact.paga.front.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PushPage extends BasePage{

	public PushPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//app-comments/div/mat-form-field/div/div/div[2]/mat-icon")
	private WebElement comment;
	
	@FindBy(xpath="//textarea[@placeholder='Add Comment']")
	private WebElement comment_input;
	
	@FindBy(xpath="//app-push/div/app-comments/div/p/button")
	private WebElement comment_button;
	
	@FindBy(xpath="//input[@placeholder='Choose a date']")
	private WebElement data_input;
	
	@FindBy(xpath="//app-due-date-dialog/div[2]/button[2]")
	private WebElement ok_button;
	
	public void click_ok_button(){
		this.click(ok_button);
	}
	
	public void input_data_input(String s){
		this.sendkeys(data_input, s);
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
