package com.paga.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LinkCriteriaPage extends BasePage{

	public LinkCriteriaPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//定位Add DRUG按钮
	@FindBy(xpath="//tfoot/tr/td/button/span")
	private WebElement Add_DRUG;
	
	//定位HICL编号
	@FindBy(xpath="//app-link-criteria-hicl-detail/div/mat-form-field/div/div/div/input")
	private WebElement HICL;
	
	//定位HICL下拉框第一项
	@FindBy(xpath="//body/div[2]/div[3]/div/div/mat-option/span")
	private WebElement HICL_list;
	
	//定位ADD DRUG添加后列表
	@FindBy(xpath="//tbody/tr/td[8]/p")
	private WebElement HICL_list_Delete;
	
	//ADD DRUG添加后列表文本
	public String get_HICL_list_Delete_text(){
		return HICL_list_Delete.getText();
	}
	
	//点击HICL下拉框第一项
	public void click_HICL_list(){
		this.click(HICL_list);
	}
	
	//点击AddPath按钮
	public void input_HICL(String s){
		this.sendkeys(HICL, s);
	}
	
	//点击回车
	public void enter_HICL(){
		HICL.sendKeys(Keys.ENTER);
	}
		
	//点击Add DRUG按钮
	public void click_Add_DRUG(){
		this.click(Add_DRUG);
	}
	
}
