package com.paga.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubTaskReviewPage extends BasePage {

	public SubTaskReviewPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//定位Path List下拉框
	@FindBy(xpath="//app-review/div/div/mat-accordion[2]/mat-expansion-panel[2]/mat-expansion-panel-header/span[2]")
	private WebElement Path_List;
	
	//定位Path List操作按钮
	@FindBy(xpath="//app-path-list/div/table/tbody/tr/td[4]/button")
	private WebElement more_vert;
	
	//定位Preview
	@FindBy(xpath="//*[contains(text(),'Preview')]")
	private WebElement Preview;
	
	//定位mode_edit按钮
	@FindBy(xpath="//app-comments/div/mat-form-field/div/div/div[2]")
	private WebElement mode_edit;
	
	//定位comment输入框
	@FindBy(xpath="//textarea[@placeholder='Add Comment']")
	private WebElement add_comment;
	
	//定位Complete
	@FindBy(xpath="//button[@class='font-weight-bold margin-right-30 mat-button mat-primary']")
	private WebElement Complete;
	
	//定位Assign to输入框
	@FindBy(xpath="//app-assign-to-detail/div/form/mat-form-field/div/div/div/input")
	private WebElement Assign_to;
	
	//定位Assign按钮
	@FindBy(xpath="//app-assign-to-detail/div[2]/button[2]")
	private WebElement Assign;
	
	//点击Assign按钮
	public void click_Assign(){
		this.click(Assign);
	}

	//输入Assign to
	public void input_Assign_to(String s){
		this.sendkeys(Assign_to, s);
	} 
	
	//点击Complete
	public void click_Complete(){
		this.click(Complete);
	}
	
	//输入add_comment
	public void input_add_comment(String s){
		this.sendkeys(add_comment, s);
	}
	
	//点击mode_edit按钮
	public void click_mode_edit(){
		this.click(mode_edit);
	}
	
	//点击Preview
	public void click_Preview(){
		this.click(Preview);
	}
	
	//点击Path List操作按钮
	public void click_more_vert(){
		this.click(more_vert);
	}

	
	
	//点击Path List下拉框
	public void click_Path_List(){
		this.click(Path_List);
	}

}
