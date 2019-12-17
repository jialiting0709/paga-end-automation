package com.paga.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TaskProfilePage extends BasePage{

	public TaskProfilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//定位Guideline Name
	@FindBy(xpath="//mat-form-field[1]/div/div[1]/div/input")
	private WebElement Guideline_Name;
	
	//定位Guideline Type下拉按钮
	@FindBy(xpath="//mat-form-field[2]/div/div[1]/div/mat-select/div/div[2]")
	private WebElement Guideline_Type;
	
	//定位Guideline Type下拉第一项
	@FindBy(xpath="//mat-option/span")
	private WebElement Guideline_Type_span;
	
	//定位Assign To下拉按钮
	@FindBy(xpath="//app-in-harvesting/div/p/mat-form-field[3]/div/div[1]/div/mat-select/div/div[2]/div")
	private WebElement Assign_To;
	
	//定位Assign To下拉第二项
	@FindBy(xpath="//mat-option[2]/span")
	private WebElement Assign_To_span;
	
	//定位Add Path
	@FindBy(xpath="//mat-tab-group/mat-tab-header/div[2]/div/div/div[2]/div")
	private WebElement Add_Path;
	
	//定位AddPath按钮
	@FindBy(xpath="//app-add-path/div/p/button/span")
	private WebElement Add_Path_button;
	
	
	//点击AddPath按钮
	public void click_Add_Path_button(){
		this.click(Add_Path_button);
	}
	
	
	//点击Add Path
	public void click_Add_Path(){
		this.click(Add_Path);
	}
	
	//点击Assign To按钮
	public void click_Assign_To_span(){
		this.click(Assign_To_span);
	}
	
	//点击Assign To按钮
	public void click_Assign_To(){
		this.click(Assign_To);
	}
	
	//点击Guideline Type下拉第一项
	public void click_Guideline_Type_span(){
		this.click(Guideline_Type_span);
	}
	
	//点击Guideline Type按钮
	public void click_Guideline_Type(){
		this.click(Guideline_Type);
	}
	
	//输入Guideline Name
	public void input_Guideline_Name(String s){
		this.sendkeys(Guideline_Name, s);
	}
	
}
