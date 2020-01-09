package com.medimpact.paga.front.automation.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PathDetailPage extends BasePage{

	public PathDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//app-add-path-dialog/div[1]/mat-form-field[1]/div/div[1]/div/input")
	private WebElement Path_Name;
	
	@FindBy(xpath="//div/mat-form-field[1]/div/div[1]/div/mat-select/div/div[2]/div")
	private WebElement status;
	
	@FindBy(xpath="//mat-option/span")
	private WebElement status_list_one;
	
	@FindBy(xpath="//app-add-path-dialog/div[1]/div/mat-form-field[2]/div/div[1]/div/mat-select/div/div[2]")
	private WebElement Initial_Renewal;
	
	@FindBy(xpath="//mat-option/span")
	private WebElement Initial_Renewal_one;
	
	@FindBy(xpath="//app-add-path-dialog/div[1]/mat-form-field[2]/div/div[1]/div/input")
	private WebElement summary_input;
	
	@FindBy(xpath="//app-add-path-dialog/div[2]/button[2]")
	private WebElement save_button;
	
	public void click_save(){
		this.click(save_button);
	}
	
	public void input_summary(String s){
		this.sendkeys(summary_input, s);
	}
	
	public void click_Initial_Renewal_one(){
		this.click(Initial_Renewal_one);
	}
	
	public void click_Initial_Renewal(){
		this.click(Initial_Renewal);
	}
	

	public void click_status_list_one(){
		this.click(status_list_one);
	}
	
	public void click_status(){
		this.click(status);
	}
	
	public void input_Path_Name(String s){
		this.sendkeys(Path_Name, s);
	}
	
	
}
