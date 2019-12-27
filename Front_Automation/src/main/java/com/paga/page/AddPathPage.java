package com.paga.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddPathPage extends BasePage{

	public AddPathPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//定位Add Path按钮
	@FindBy(xpath="//app-add-path/div/p/button/span")
	private WebElement Add_Path;
	
	//定位PathName输入框
	@FindBy(xpath="//app-add-path-dialog/div/mat-form-field/div/div/div/input")
	private WebElement PathName;
	
	//定位status下拉框
	@FindBy(xpath="//app-add-path-dialog/div/div/mat-form-field/div/div/div/mat-select")
	private WebElement status_select;
	
	//定位status下拉框第一项
	@FindBy(xpath="//body/div[2]/div[4]/div/div/div/mat-option")
	private WebElement status_select_list;
	
	//定位Initial/Renewal下拉框
	@FindBy(xpath="//app-add-path-dialog/div/div/mat-form-field[2]/div/div/div/mat-select")
	private WebElement Initial_Renewal_select;
	
	//定位Initial/Renewal下拉框第一项
	@FindBy(xpath="//body/div[2]/div[4]/div/div/div/mat-option")
	private WebElement nitial_Renewal_select_list;
	
	//定位Summary输入框
	@FindBy(xpath="//textarea[@ng-reflect-placeholder='Summary']")
	private WebElement Summary;
	
	//定位Instructions输入框
	@FindBy(xpath="//textarea[@ng-reflect-placeholder='Instructions']")
	private WebElement Instructions;
	
	//定位Approval_Text输入框
	@FindBy(xpath="//textarea[@ng-reflect-placeholder='Approval Text']")
	private WebElement Approval_Text;
	
	//定位Add按钮
	@FindBy(xpath="//app-add-path-dialog/div/p/button")
	private WebElement Add_button;
	
	//定位OK按钮
	@FindBy(xpath="//app-path-group-dialog/div[2]/button[2]")
	private WebElement OK_button;
	
	//定位Criteria下拉框
	@FindBy(xpath="//app-add-path-dialog/div/table/tbody/tr/td[3]/p/mat-form-field/div/div/div/mat-select")
	private WebElement Criteria;
	
	//定位Criteria下拉列表第一项
	@FindBy(xpath="//*[contains(text(),'Requested Drug')]")
	private WebElement Criteria_list;
	
	//定位Condition下拉列表
	@FindBy(xpath="//mat-select[@ng-reflect-placeholder='Condition']")
	private WebElement Condition;
	
	//定位Condition下拉列表第一项
	@FindBy(xpath="//*[contains(text(),'The brand name of the requested drug is:')]")
	private WebElement Condition_list;
	
	//定位Value
	@FindBy(xpath="//input[@placeholder='Value']")
	private WebElement Value;
	
	//定位Save按钮
	@FindBy(xpath="//*[contains(text(),'Save')]")
	private WebElement Save_button;
	
	//定位获取添加后的pathName text
	@FindBy(xpath="//app-add-path/div/table/tbody/tr/td")
	private WebElement pathName_text;
	
	//定位Complete按钮
	@FindBy(xpath="//app-in-harvesting/p/button")
	private WebElement Complete_button;
	
	//定位Assigon to输入框
	@FindBy(xpath="//input[@ng-reflect-placeholder='Assign to']")
	private WebElement Assigon_to;
	
	//定位Assigon按钮
	@FindBy(xpath="//app-assign-to-detail/div[2]/button[2]")
	private WebElement Assigon_button;
	
	//点击Assigon按钮
	public void click_Assigon_button(){
		this.click(Assigon_button);
	}
	
	//输入Assigon to
	public void input_Assigon_to(String s){
		this.sendkeys(Assigon_to, s);
	}
	
	//点击Complete按钮
	public void click_Complete_button(){
		this.click(Complete_button);
	}
	
	//获取添加后的pathName text
	public String getPatnNameText(){
		return pathName_text.getTagName();
	}
	
	//点击Save
	public void click_Save_button(){
		this.click(Save_button);
	}
	
	//输入Value
	public void input_Value(String s){
		this.sendkeys(Value, s);
	}
	
	//点击Condition下拉框第一项
	public void click_Condition_select_list(){
		this.click(Condition_list);
	}
	
	
	//点击Condition下拉框
	public void click_Condition_select(){
		this.click(Condition);
	}
	
	//点击Criteria下拉框第一项
	public void click_Criteria_select_list(){
		this.click(Criteria_list);
	}
	
	//点击Criteria下拉框
	public void click_Criteria_select(){
		this.click(Criteria);
	}
	
	//点击OK按钮
	public void click_OK_button(){
		this.click(OK_button);
	}
	
	//点击Add按钮
	public void click_Add_button(){
		this.click(Add_button);
	}
	
	//输入Approval_Text
	public void input_Approval_Text(String s){
		this.sendkeys(Approval_Text, s);
	}
	
	//输入Instructions
	public void input_Instructions(String s){
		this.sendkeys(Instructions, s);
	}
	
	//输入Summary
	public void input_Summary(String s){
		this.sendkeys(Summary, s);
	}
	
	
	//点击status下拉框第一项
	public void click_nitial_Renewal_select_list(){
		this.click(nitial_Renewal_select_list);
	}
	
	//点击Initial/Renewal下拉框
	public void click_Initial_Renewal_select(){
		this.click(Initial_Renewal_select);
	}
	
	//点击status下拉框第一项
	public void click_status_select_list(){
		this.click(status_select_list);
	}
	
	//点击status下拉框
	public void click_status_select(){
		this.click(status_select);
	}
	
	
	//输入PathName
	public void input_PathName(String s){
		this.sendkeys(PathName, s);
	}
	
	
	//点击Add_Path
	public void click_Add_Path(){
		this.click(Add_Path);
	}
	

}
