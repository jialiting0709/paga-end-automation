package com.paga.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PathDetailPage extends BasePage{

	public PathDetailPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//定位Path Name
	@FindBy(xpath="//app-add-path-dialog/div[1]/mat-form-field[1]/div/div[1]/div/input")
	private WebElement Path_Name;
	
	//定位Status下拉列表
	@FindBy(xpath="//div/mat-form-field[1]/div/div[1]/div/mat-select/div/div[2]/div")
	private WebElement status;
	
	//定位Status下拉列表第一项
	@FindBy(xpath="//mat-option/span")
	private WebElement status_list_one;
	
	//定位Initial/Renewal下拉列表
	@FindBy(xpath="//app-add-path-dialog/div[1]/div/mat-form-field[2]/div/div[1]/div/mat-select/div/div[2]")
	private WebElement Initial_Renewal;
	
	//定位Initial/Renewal下拉列表第一项
	@FindBy(xpath="//mat-option/span")
	private WebElement Initial_Renewal_one;
	
	//定位summary input
	@FindBy(xpath="//app-add-path-dialog/div[1]/mat-form-field[2]/div/div[1]/div/input")
	private WebElement summary_input;
	
	//定位save按钮
	@FindBy(xpath="//app-add-path-dialog/div[2]/button[2]")
	private WebElement save_button;
	
	//点击save按钮
	public void click_save(){
		this.click(save_button);
	}
	
	
	//输入summary input
	public void input_summary(String s){
		this.sendkeys(summary_input, s);
	}
	
	
	//点击Initial/Renewal下拉列表第一项
	public void click_Initial_Renewal_one(){
		this.click(Initial_Renewal_one);
	}
	
	//点击Initial/Renewal下拉列表
	public void click_Initial_Renewal(){
		this.click(Initial_Renewal);
	}
	
	
	//点击Status下拉列表第一项
	public void click_status_list_one(){
		this.click(status_list_one);
	}
	
	
	
	//点击Status下拉列表
	public void click_status(){
		this.click(status);
	}
	
	//输入Path_Name
	public void input_Path_Name(String s){
		this.sendkeys(Path_Name, s);
	}
	
	
}
