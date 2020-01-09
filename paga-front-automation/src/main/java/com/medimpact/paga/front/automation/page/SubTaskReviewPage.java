package com.medimpact.paga.front.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubTaskReviewPage extends BasePage {

	public SubTaskReviewPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//app-review/div/div/mat-accordion[2]/mat-expansion-panel[2]/mat-expansion-panel-header/span[2]")
	private WebElement Path_List;
	

	@FindBy(xpath="//app-path-list/div/table/tbody/tr/td[4]/button")
	private WebElement more_vert;

	@FindBy(xpath="//*[contains(text(),'View')]")
	private WebElement View;
	
	@FindBy(xpath="//app-comments/div/mat-form-field/div/div/div[2]")
	private WebElement mode_edit;
	
	@FindBy(xpath="//textarea[@placeholder='Add Comment']")
	private WebElement add_comment;
	
	@FindBy(xpath="//button[@class='font-weight-bold margin-right-30 mat-button mat-primary']")
	private WebElement Complete;
	
	@FindBy(xpath="//app-assign-to-detail/div/form/mat-form-field/div/div/div/input")
	private WebElement Assign_to;

	@FindBy(xpath="//app-assign-to-detail/div[2]/button[2]")
	private WebElement Assign;
	
	public void click_Assign(){
		this.click(Assign);
	}

	public void input_Assign_to(String s){
		this.sendkeys(Assign_to, s);
	} 
	
	public void click_Complete(){
		this.click(Complete);
	}
	
	public void input_add_comment(String s){
		this.sendkeys(add_comment, s);
	}
	
	public void click_mode_edit(){
		this.click(mode_edit);
	}
	
	public void click_Preview(){
		this.click(View);
	}
	
	public void click_more_vert(){
		this.click(more_vert);
	}

	public void click_Path_List(){
		this.click(Path_List);
	}

}
